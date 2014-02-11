package net.okjsp.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.okjsp.community.model.Article;
import net.okjsp.community.model.Board;
import net.okjsp.community.service.CommunityService;
import net.okjsp.common.model.Paging;
import net.okjsp.layout.BasicLayoutController;
import net.okjsp.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/community")
public class CommunityController extends BasicLayoutController {
	
	@Autowired
    CommunityService communityService;

	@RequestMapping(value="")
	public String boardList(Model model) {
		List<Board> communityBoardList = communityService.getCommunityBoardList();

		model.addAttribute("boardList", communityBoardList);

		return "community/boards";
	}
	
	
	//게시판별 게시글 목록 호출
	@RequestMapping(value="/{boardId}/{categoryId}", method = RequestMethod.GET)
	public String list(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
            Paging paging,
			Model model) {
				
		paging.setPage(pageNum);
        List<Article> list = communityService.getArticles(boardId, categoryId, paging);

        int count = communityService.getTotalCount(boardId, categoryId);

        paging.setListCount(list.size());
        paging.setTotalCount(count);
        

        model.addAttribute("posts", list);
        model.addAttribute("boardId", boardId);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("paging", paging);

        return "community/list";

	}
	
	//게시글 호출
	@RequestMapping(value = "/{boardId}/{categoryId}/{writeNo}")
	public String view(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			@PathVariable int writeNo,
			Model model) {
		
		Article article = communityService.getArticle(writeNo);
		
		model.addAttribute("boardId", boardId);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("post", article);
        
        return "community/view";
		
	}
	
    //TODO : 게시글 등록 폼 호출
	@Secured("ROLE_USER")
	@RequestMapping(value = "/{boardId}/{categoryId}/writeForm")
	public String createForm(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			Model model) {
		
		model.addAttribute("boardId", boardId);
		model.addAttribute("categoryId", categoryId);
		
		return "community/create";
	}
	
	//TODO : 게시글 수정 폼 호출
	@Secured("ROLE_USER")
	@RequestMapping(value="/{boardId}/{categoryId}/modifyForm", method = RequestMethod.POST)
	public String modifyForm(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			@RequestParam(value = "writeNo") int writeNo,
			Model model,
			Authentication authentication,
			HttpServletResponse response
			) throws IOException {
		
		User user = (User) authentication.getPrincipal();
		Article article = communityService.getArticle(writeNo);
		
		if (article.getUser().getUserId() != user.getUserId()) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "게시물 수정 권한이 없습니다");
		}
		
		model.addAttribute("boardid", boardId);
		model.addAttribute("categoryid", categoryId);
		model.addAttribute("commboard", article);
		
		return "community/modify";
	}
    
	//게시글 등록
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{boardId}/{categoryId}/write", method = RequestMethod.POST)
    public String create(
    		@PathVariable int boardId,
            @PathVariable int categoryId,
            @ModelAttribute Article article,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        
        article.setBoardId(boardId);
        article.setCategoryId(categoryId);
        article.setUser(user);

        communityService.create(article);

        return "redirect:/community/" + boardId + "/" + categoryId;
    }

    //게시글 수정
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{boardId}/{categoryId}/modify/{writeNo}", method = RequestMethod.POST)
    public String modify(
    		@PathVariable int boardId,
            @PathVariable int categoryId,
            @PathVariable int writeNo,
            @ModelAttribute Article article,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        
        article.setWriteNo(writeNo);
        article.setUser(user);
        
        communityService.modify(article);

        return "redirect:/community/" + boardId + "/" + categoryId;
    }

    
    //게시글 삭제
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{boardId}/{categoryId}/remove/{writeNo}", method = RequestMethod.DELETE)
    public String remove(
    		@PathVariable int boardId,
            @PathVariable int categoryId,
            @PathVariable int writeNo,
            Authentication authentication) {

        communityService.delete(writeNo);

        return "redirect:/community/" + boardId + "/" + categoryId;
    }
}
