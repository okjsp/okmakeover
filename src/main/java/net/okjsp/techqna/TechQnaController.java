package net.okjsp.techqna;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.okjsp.common.model.Paging;
import net.okjsp.common.model.PagingList;
import net.okjsp.community.model.Board;
import net.okjsp.community.model.Comment;
import net.okjsp.community.service.BoardService;
import net.okjsp.community.service.CommentService;
import net.okjsp.community.service.CommunityService;
import net.okjsp.recommendation.model.BoardRecommend;
import net.okjsp.recommendation.service.BoardRecommendService;
import net.okjsp.techqna.model.TechQna;
import net.okjsp.techqna.service.TechQnaService;
import net.okjsp.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TechQna Controller
 *
 * @author yjc0703
 *
 */
// TODO : DB에 있는 boardId/categoryId 외에 있는 자료가 올때 하는 처리 필요.
// TODO : 몇몇 함수는 비슷한 모양을 가지고 있음. 간략히 할 수 있어 보이므로 추후 변경을 하자.(hasErors redirect가 있는 함수)
// TODO : summary 처리 방안 생각해서 처리해야함.
@Controller
@RequestMapping(value = "/techqna/{boardId}/{categoryId}")
public class TechQnaController {

    @Autowired
    private TechQnaService techQnaService;

    @Autowired
    CommunityService communityService;

    @Autowired
    CommentService commentService;

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRecommendService boardRecommendService;

    private static Map<Integer,String> boardNames;

    @RequestMapping(value="/.json")
    public @ResponseBody PagingList list(@PathVariable int boardId,
                                         @PathVariable int categoryId,
                                         Paging paging,
                                         @RequestParam(defaultValue="newest") String sort,
                                         @RequestParam(defaultValue="") String tag) {

        List<TechQna> list = techQnaService.selectTechQnaList(boardId, categoryId, paging, sort, tag);

        paging.setTotalCount(techQnaService.selectTechQnaByTagTotalCount(boardId, categoryId, tag));
        paging.setListCount(list.size());

        PagingList pagingList = new PagingList(paging, list);

        return pagingList;
    }
    // TODO: "" Mapping는 함수로 따로 빼는게 좋을지도.. 좀더 확인해보자.
    @RequestMapping(value={"", "/"}, method=RequestMethod.GET)
    public String listAsHtml(@PathVariable int boardId,
                             @PathVariable int categoryId,
                             Paging paging,
                             @RequestParam(defaultValue="newest") String sort,
                             @RequestParam(defaultValue="") String tag,
                             Model model) {

        PagingList pagingList = this.list(boardId, categoryId, paging, sort, tag);

        model.addAttribute("questions", pagingList.getList());
        model.addAttribute("paging", pagingList.getPaging());

        return "/techqna/techqna_list";
    }

    @RequestMapping(value="/{writeNo}", method=RequestMethod.GET)
    public String view(@PathVariable int boardId, @PathVariable int categoryId, @PathVariable int writeNo, Model model) {

        TechQna question = techQnaService.selectOneTechQnaQuestion(boardId, categoryId, writeNo);

        if (question == null) {
            return "redirect:/techqna/"+boardId+"/"+categoryId;
        }

        techQnaService.incTechQnaHit(writeNo);

        model.addAttribute("question", question);
        model.addAttribute("answers", techQnaService.selectTechQnaAnswers(boardId, categoryId, writeNo));
        model.addAttribute("answer", new TechQna());

        return "techqna/techqna_view";
    }

    // TODO : BoardId, CategoryId를 자동으로 넣는 방법있으면 적용.
    @Secured("ROLE_USER")
    @RequestMapping(value="/create", method=RequestMethod.GET)
    public String createForm(@PathVariable int boardId, @PathVariable int categoryId, Model model) {

        model.addAttribute("techQna", new TechQna());
        model.addAttribute("boardId", boardId);
        model.addAttribute("categoryId", categoryId);

        return "techqna/techqna_create";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute TechQna techQna,
                         @RequestParam String summary,
                         BindingResult result,
                         Authentication authentication) {

        if (result.hasErrors()) {
            return "techqna/techqna_create";
        }

        User user = (User) authentication.getPrincipal();

        techQna.setUserId(user.getUserId());

        techQnaService.createTechQna(techQna, summary);

        return "redirect:/techqna/" + techQna.getBoardId() + "/" + techQna.getCategoryId();
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/{writeNo}/modify", method = RequestMethod.GET)
    public String modifyForm(@PathVariable int boardId,
                             @PathVariable int categoryId,
                             @PathVariable int writeNo,
                             Model model) {

        model.addAttribute("techQna", techQnaService.selectOneTechQnaQuestion(boardId, categoryId, writeNo));

        return "techqna/techqna_modify";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/{writeNo}", method = RequestMethod.POST)
    public String modify(@Valid @ModelAttribute TechQna techQna,
                         @RequestParam String summary,
                         BindingResult result) {

        if (result.hasErrors()) {
            return "techqna/" + techQna.getBoardId() + "/" + techQna.getCategoryId() + "/" + techQna.getWriteNo();
        }

        techQnaService.updateTechQna(techQna, summary);

        return "redirect:/techqna/" + techQna.getBoardId() + "/" + techQna.getCategoryId() + "/" + techQna.getWriteNo();
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/{parentId}/answer", method=RequestMethod.POST)
    public String createAnswer(@Valid @ModelAttribute TechQna techQna,
                               @RequestParam String summary,
                               BindingResult result,
                               Authentication authentication) {

        if (result.hasErrors()) {
            return "techqna/" + techQna.getBoardId() + "/" + techQna.getCategoryId() + "/" + techQna.getParentId();
        }

        User user = (User) authentication.getPrincipal();

        techQna.setQnaTitle(String.valueOf(techQna.getParentId()));
        techQna.setUserId(user.getUserId());

        // TODO : tagList값이 NULL에 대한 처리 추가 필요
        techQnaService.createTechQna(techQna, summary);

        return "redirect:/techqna/" + techQna.getBoardId() + "/" + techQna.getCategoryId() + "/" + techQna.getParentId();
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/{parentId}/answer/{writeNo}/modify", method = RequestMethod.GET)
    public String answerModifyForm(@PathVariable int boardId,
                                   @PathVariable int categoryId,
                                   @PathVariable int writeNo,
                                   @PathVariable int parentId,
                                   Model model) {

        model.addAttribute("techQna", techQnaService.selectOneTechQnaAnswer(boardId, categoryId, writeNo, parentId));

        return "techqna/techqna_answer_modify";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/{parentId}/answer/{writeNo}", method=RequestMethod.POST)
    public String answerModify(@Valid @ModelAttribute TechQna techQna,
                               @RequestParam String summary,
                               BindingResult result,
                               Authentication authentication) {

        if (result.hasErrors()) {
            return "techqna/" + techQna.getBoardId() + "/" + techQna.getCategoryId() + "/" + techQna.getParentId();
        }

        // TODO : 수정 권한에 대한 확인 필요
        User user = (User) authentication.getPrincipal();

        techQna.setUserId(user.getUserId());

        // TODO : tagList값이 NULL에 대한 처리 추가 필요
        techQnaService.updateTechQna(techQna, summary);

        return "redirect:/techqna/" + techQna.getBoardId() + "/" + techQna.getCategoryId() + "/" + techQna.getParentId();
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/{writeNo}/comment", method = RequestMethod.POST)
    public String comment(
            @PathVariable int categoryId,
            @Valid @ModelAttribute Comment comment,
            BindingResult result,
            Authentication authentication) {

        if (result.hasErrors()) {
            return "techqna/" + comment.getBoardId() + "/" + categoryId + "/" + comment.getWriteNo();
        }

        User user = (User) authentication.getPrincipal();

        comment.setUserId(user.getUserId());

        commentService.create(comment);

        return "redirect:/techqna/" + comment.getBoardId() + "/" + categoryId + "/" + comment.getWriteNo();
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/{parentId}/answer/{writeNo}/comment", method = RequestMethod.POST)
    public String answerComment(
            @PathVariable int categoryId,
            @PathVariable int parentId,
            @Valid @ModelAttribute Comment comment,
            BindingResult result,
            Authentication authentication) {

        if (result.hasErrors()) {
            return "techqna/" + comment.getBoardId() + "/" + categoryId + "/" + parentId;
        }

        User user = (User) authentication.getPrincipal();
        comment.setUserId(user.getUserId());

        commentService.create(comment);

        return "redirect:/techqna/" + comment.getBoardId() + "/" + categoryId + "/" + parentId;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/{writeNo}/good")
    public String questionGood(@Valid @ModelAttribute BoardRecommend boardRecommend,
                               @PathVariable int categoryId,
                               BindingResult result,
                               Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        boardRecommend.setTypeId(BoardRecommend.Type.RECOMMEND);
        boardRecommend.setUserId(user.getUserId());
        String returnUrl = boardRecommend.getBoardId() + "/" + categoryId + "/" + boardRecommend.getWriteNo();

        return setRecommendOpposite(result.hasErrors(), boardRecommend, returnUrl);
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/{writeNo}/bad")
    public String questionBad(@Valid @ModelAttribute BoardRecommend boardRecommend,
                              @PathVariable int categoryId,
                              BindingResult result,
                              Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        boardRecommend.setTypeId(BoardRecommend.Type.OPPOSE);
        boardRecommend.setUserId(user.getUserId());
        String returnUrl = boardRecommend.getBoardId() + "/" + categoryId + "/" + boardRecommend.getWriteNo();

        return setRecommendOpposite(result.hasErrors(), boardRecommend, returnUrl);
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/{parentId}/answer/{writeNo}/good")
    public String answerGood(@PathVariable int categoryId,
                             @PathVariable int parentId,
                             @Valid @ModelAttribute BoardRecommend boardRecommend,
                             BindingResult result,
                             Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        boardRecommend.setTypeId(BoardRecommend.Type.RECOMMEND);
        boardRecommend.setUserId(user.getUserId());
        String returnUrl = boardRecommend.getBoardId() + "/" + categoryId + "/" + parentId;

        return setRecommendOpposite(result.hasErrors(), boardRecommend, returnUrl);
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/{parentId}/answer/{writeNo}/bad")
    public String answerBad(@PathVariable int categoryId,
                            @PathVariable int parentId,
                            @Valid @ModelAttribute BoardRecommend boardRecommend,
                            BindingResult result,
                            Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        boardRecommend.setTypeId(BoardRecommend.Type.OPPOSE);
        boardRecommend.setUserId(user.getUserId());
        String returnUrl = boardRecommend.getBoardId() + "/" + categoryId + "/" + parentId;

        return setRecommendOpposite(result.hasErrors(), boardRecommend, returnUrl);

    }

    // TODO : 추천/반대 관련 함수들 간략히 할 수 있으면 간략히 하자.
    // TODO : 함수명을 기능에 맞추어 변경해야 함.
    private String setRecommendOpposite(boolean hasErrors,
                                        BoardRecommend boardRecommend,
                                        String returnUrl) {
        if (hasErrors) {
            return "techqna/" + returnUrl;
        }

        boardRecommendService.addRecommendation(boardRecommend);

        return "redirect:/techqna/" + returnUrl;
    }

    @ModelAttribute("BOARD_NAMES")
    public Map<Integer, String> getBoardNameByCategoryId() {
        if(boardNames == null) {

            boardNames = new HashMap<>();

            List<Board> boards = boardService.getBoardListById(4);

            Iterator iterator = boards.iterator();

            while (iterator.hasNext()) {
                Board board = (Board) iterator.next();
                boardNames.put(board.getCategoryId(), board.getCategoryName());
            }
        }

        return boardNames;
    }
}
