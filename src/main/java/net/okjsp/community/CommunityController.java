package net.okjsp.community;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.okjsp.common.model.PagingList;
import net.okjsp.community.model.Article;
import net.okjsp.community.model.Board;
import net.okjsp.community.model.Comment;
import net.okjsp.community.service.BoardService;
import net.okjsp.community.service.CommentService;
import net.okjsp.community.service.CommunityService;
import net.okjsp.common.model.Paging;
import net.okjsp.layout.BasicLayoutController;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/community")
public class CommunityController extends BasicLayoutController {
	
	@Autowired
    CommunityService communityService;

    @Autowired
    CommentService commentService;

    @Autowired
    BoardService boardService;

    private static Map<Integer,String> boardNames;

	@RequestMapping(value="")
	public String boardList() {
		return "community/boards";
	}


    /**
     * 게시판별 게시글 목록 호출
     * @param boardId
     * @param categoryId
     * @param paging
     * @return
     */
	@RequestMapping(value="/{boardId}/{categoryId}.json", method = RequestMethod.GET)
	public PagingList list(
			@PathVariable int boardId,
			@PathVariable int categoryId,
            Paging paging) {

        List<Article> list = communityService.getArticles(boardId, categoryId, paging);

        int count = communityService.getTotalCount(boardId, categoryId);

        paging.setListCount(list.size());
        paging.setTotalCount(count);

        PagingList pagingList = new PagingList(paging, list);

        return pagingList;

	}


    //게시판별 게시글 목록 호출
    @RequestMapping(value="/{boardId}/{categoryId}", method = RequestMethod.GET)
    public String listAsHTML(
            @PathVariable int boardId,
            @PathVariable int categoryId,
            Paging paging,
            Model model) {

        PagingList pagingList = this.list(boardId, categoryId, paging);

        model.addAttribute("articles", pagingList.getList());
        model.addAttribute("paging", pagingList.getPaging());
        model.addAttribute("boardId", boardId);
        model.addAttribute("categoryId", categoryId);

        return "community/community_list";

    }
	
	//게시글 호출
	@RequestMapping(value = "/{boardId}/{categoryId}/{writeNo}", method = RequestMethod.GET)
	public String view(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			@PathVariable int writeNo,
			Model model) {

        communityService.addArticleHit(writeNo);

		Article article = communityService.getArticle(writeNo);

        //TODO 댓글 페이징 구현
		
		model.addAttribute("boardId", boardId);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("article", article);
        
        return "community/community_view";
		
	}
	
    //TODO : 게시글 등록 폼 호출
	@Secured("ROLE_USER")
	@RequestMapping(value = "/{boardId}/{categoryId}/create", method = RequestMethod.GET)
	public String createForm(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			Model model) {

        Article article = new Article();

        model.addAttribute("article", article);
		model.addAttribute("boardId", boardId);
		model.addAttribute("categoryId", categoryId);

		return "community/community_create";
	}

    //게시글 등록
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{boardId}/{categoryId}", method = RequestMethod.POST)
    public String create(
            @PathVariable int boardId,
            @PathVariable int categoryId,
            @Valid @ModelAttribute Article article,
            BindingResult result,
            Authentication authentication) throws IOException {

        if(result.hasErrors()){
            return "community/community_create";
        }

        User user = (User) authentication.getPrincipal();

        article.setBoardId(boardId);
        article.setCategoryId(categoryId);
        article.setUserId(user.getUserId());

        communityService.create(article);

        return "redirect:/community/" + boardId + "/" + categoryId;
    }

	//TODO : 게시글 수정 폼 호출
	@Secured("ROLE_USER")
	@RequestMapping(value="/{boardId}/{categoryId}/{writeNo}/modify", method = RequestMethod.GET)
	public String modifyForm(
			@PathVariable int boardId,
			@PathVariable int categoryId,
            @PathVariable int writeNo,
			Model model,
			Authentication authentication,
			HttpServletResponse response
			) throws IOException {
		
		User user = (User) authentication.getPrincipal();

		Article article = communityService.getArticle(writeNo);
		
		if (article.getUser().getUserId() == user.getUserId()) {
            model.addAttribute("article", article);
            model.addAttribute("boardId", boardId);
            model.addAttribute("categoryId", categoryId);
		} else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "게시물 수정 권한이 없습니다");
        }
		
		return "community/community_modify";
	}

    //게시글 수정
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{boardId}/{categoryId}/{writeNo}", method = RequestMethod.POST)
    public String modify(
    		@PathVariable int boardId,
            @PathVariable int categoryId,
            @PathVariable int writeNo,
            @ModelAttribute Article article,
            Authentication authentication,
            HttpServletResponse response) throws IOException {

        User user = (User) authentication.getPrincipal();

        int userId = communityService.getUserIdFromArticle(writeNo);

        if(user.getUserId() == userId) {
            article.setWriteNo(writeNo);
            article.setUser(user);

            communityService.modify(article);

            return "redirect:/community/" + boardId + "/" + categoryId;

        } else {

            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "게시물 수정 권한이 없습니다");

            return "community/community_modify";
        }
    }

    
    //게시글 삭제
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{boardId}/{categoryId}/{writeNo}", method = RequestMethod.DELETE)
    public String remove(
    		@PathVariable int boardId,
            @PathVariable int categoryId,
            @PathVariable int writeNo,
            Authentication authentication,
            RedirectAttributes redirectAttributes) {

        User user = (User) authentication.getPrincipal();

        int userId = communityService.getUserIdFromArticle(writeNo);
        if(user.getUserId() == userId) {

            communityService.delete(writeNo);

        } else {
            redirectAttributes.addAttribute("message", "게시물 수정 권한이 없습니다");
        }

        return "redirect:/community/" + boardId + "/" + categoryId;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/{boardId}/{categoryId}/{writeNo}/comment", method = RequestMethod.POST)
    public String createComment(
            @PathVariable int boardId,
            @PathVariable int categoryId,
            @PathVariable int writeNo,
            @ModelAttribute Comment comment,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();


        int userId = communityService.getUserIdFromArticle(writeNo);

        comment.setUserId(user.getUserId());

        commentService.create(comment);

        return "redirect:/community/" + boardId + "/" + categoryId + "/" + writeNo;

    }

    @ModelAttribute("BOARD_NAMES")
    public Map<Integer, String> getBoardNameByCategoryId() {

        if(boardNames == null) {

            boardNames = new HashMap<>();

            List<Board> boards = boardService.getBoardListById(3);

            Iterator iterator = boards.iterator();

            while (iterator.hasNext()) {
                Board board = (Board) iterator.next();
                boardNames.put(board.getCategoryId(), board.getCategoryName());
            }
        }

        return boardNames;
    }
}
