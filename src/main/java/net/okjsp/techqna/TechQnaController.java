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
// TODO: DB에 있는 boardId/categoryId 외에 있는 자료가 올때 하는 처리 필요.
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
	
	private static Map<Integer,String> boardNames;
	
	@RequestMapping(value="/.json")
	public @ResponseBody PagingList list(@PathVariable int boardId, @PathVariable int categoryId,
										 Paging paging, 
										 @RequestParam(defaultValue="newest") String sort, @RequestParam(defaultValue="") String tag) {
		List<TechQna> list = techQnaService.selectTechQnaList(boardId, categoryId, paging, sort, tag);
		
		int totalCount = techQnaService.selectTechQnaByTagTotalCount(boardId, categoryId, tag);
		paging.setTotalCount(totalCount);
		paging.setListCount(list.size());
		
		PagingList pagingList = new PagingList(paging, list);
		
		return pagingList;
	}
	// TODO: "" Mapping는 함수로 따로 빼는게 좋을지도.. 좀더 확인해보자.
	@RequestMapping(value={"", "/"}, method=RequestMethod.GET)
	public String listAsHtml(@PathVariable int boardId, @PathVariable int categoryId, Paging paging, 
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
		List<TechQna> answers = techQnaService.selectTechQnaAnswers(boardId, categoryId, writeNo);

		model.addAttribute("question", question);
		model.addAttribute("answers", answers);
		model.addAttribute("answer", new TechQna());
		
		return "techqna/techqna_view";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createForm(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			Model model) {
		
        model.addAttribute("techQna", new TechQna());
		model.addAttribute("boardId", boardId);
		model.addAttribute("categoryId", categoryId);
		
		return "techqna/techqna_create";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String create(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			@Valid @ModelAttribute TechQna techQna,
			BindingResult result,
            Authentication authentication) {
		
		if (result.hasErrors()) {
			return "techqna/techqna_create";
		}
		
		User user = (User) authentication.getPrincipal();
		
		techQna.setBoardId(boardId);
		techQna.setCategoryId(categoryId);
		techQna.setUserId(user.getUserId());
		
		techQnaService.createTechQna(techQna);
		
		return "redirect:/techqna/" + boardId + "/" + categoryId;
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/{writeNo}/modify", method = RequestMethod.GET)
	public String modifyForm(@PathVariable int boardId, 
			                 @PathVariable int categoryId,
			                 @PathVariable int writeNo,
			                 Model model) {
		
		TechQna techQna = techQnaService.selectOneTechQnaQuestion(boardId, categoryId, writeNo);
		
		model.addAttribute("writeNo", writeNo);
		
		return "techqna/techqna_modify";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/{writeNo}", method = RequestMethod.POST)
	public String modify(@PathVariable int boardId, 
			             @PathVariable int categoryId,
			             @PathVariable int writeNo,
			             @Valid @ModelAttribute TechQna techQna,
			             BindingResult result,
			             Authentication authentication) {
		
		if (result.hasErrors()) {
			return "techqna/" + boardId + "/" + categoryId + "/" + writeNo;
		}
		
		techQnaService.updateTechQna(techQna);
		
		return "redirect:/techqna/" + boardId + "/" + categoryId + "/" + writeNo;
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/{writeNo}/answer", method=RequestMethod.POST)
	public String createAnswer(@PathVariable int boardId, 
			                   @PathVariable int categoryId, 
			                   @PathVariable int writeNo,
			                   @Valid @ModelAttribute TechQna techQna,
					           BindingResult result,
					           Authentication authentication) {
		
		if (result.hasErrors()) {
			return "techqna/" + boardId + "/" + categoryId + "/" + writeNo;
		}
		
		User user = (User) authentication.getPrincipal();
		
		techQna.setWriteNo(null);
		techQna.setQnaTitle(String.valueOf(writeNo));
		techQna.setBoardId(boardId);
		techQna.setCategoryId(categoryId);
		techQna.setUserId(user.getUserId());
		techQna.setParentId(writeNo);
		
		// TODO : tagList값이 NULL에 대한 처리 추가 필요
		techQnaService.createTechQna(techQna);
		
		return "redirect:/techqna/" + boardId + "/" + categoryId + "/" + writeNo;
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/{parentId}/answer/{writeNo}/modify", method = RequestMethod.GET)
	public String answerModifyForm(@PathVariable int boardId, 
			                 @PathVariable int categoryId,
			                 @PathVariable int writeNo,
			                 @PathVariable int parentId,
			                 Model model) {
		
		TechQna techQna = techQnaService.selectOneTechQnaAnswer(boardId, categoryId, writeNo, parentId);
		
		model.addAttribute("techQna", techQna);
		
		return "techqna/techqna_answer_modify";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/{parentId}/answer/{writeNo}", method=RequestMethod.POST)
	public String answerModify(@PathVariable int boardId, 
				               @PathVariable int categoryId,
				               @PathVariable int writeNo,
				               @PathVariable int parentId,
			                   @Valid @ModelAttribute TechQna techQna,
					           BindingResult result,
					           Authentication authentication) {
		
		if (result.hasErrors()) {
			return "techqna/" + boardId + "/" + categoryId + "/" + parentId;
		}
		
		// TODO : 수정 권한에 대한 확인 필요
		
		User user = (User) authentication.getPrincipal();
		
		techQna.setUserId(user.getUserId());
		
		// TODO : tagList값이 NULL에 대한 처리 추가 필요
		techQnaService.updateTechQna(techQna);
		
		return "redirect:/techqna/" + boardId + "/" + categoryId + "/" + parentId;
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/{writeNo}/comment", method = RequestMethod.POST)
	public String comment(
            @PathVariable int boardId,
            @PathVariable int categoryId,
            @PathVariable int writeNo,
            @ModelAttribute Comment comment,
            Authentication authentication) {
		
	       User user = (User) authentication.getPrincipal();

	        int userId = communityService.getUserIdFromArticle(writeNo);

	        comment.setUserId(user.getUserId());

	        commentService.create(comment);

	        return "redirect:/techqna/" + boardId + "/" + categoryId + "/" + writeNo;
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
