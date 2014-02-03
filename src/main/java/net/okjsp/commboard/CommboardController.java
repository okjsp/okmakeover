package net.okjsp.commboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.okjsp.commboard.model.Board;
import net.okjsp.commboard.model.Commboard;
import net.okjsp.commboard.service.CommboardService;
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
public class CommboardController  extends BasicLayoutController {
	
	@Autowired
	CommboardService boardService;
	
	@RequestMapping(value="")
	public String CommunityBoardList(Model model) {
		List<Board> communityBoardList = boardService.getCommunityBoardList();
		
		model.addAttribute("boardList", communityBoardList);
		
		return "board/board_list";		
	}
	
	
	//게시판별 게시글 목록 호출
	@RequestMapping(value="/{boardId}/{categoryId}", method = RequestMethod.GET)
	public String CommunityPostListById(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
            Paging paging,
			Model model) {
				
		paging.setPage(pageNum);
        List<Commboard> list = boardService.getCommBoardList(boardId, categoryId, paging);

        int count = boardService.getTotalCount(boardId, categoryId);

        paging.setListCount(list.size());
        paging.setTotalCount(count);
        

        model.addAttribute("commboard", list);
        model.addAttribute("boardid", boardId);
        model.addAttribute("categoryid", categoryId);
        model.addAttribute("paging", paging);

        return "board/board_list/commboard";

	}
	
	//게시글 호출
	@RequestMapping(value = "/{boardId}/{categoryId}/{writeNo}")
	public String readCommboard(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			@PathVariable int writeNo,
			Model model) {
		
		Commboard commboard = boardService.getCommboard(writeNo);
		
		model.addAttribute("boardid", boardId);
        model.addAttribute("categoryid", categoryId);
        model.addAttribute("commboard", commboard);
        
        return "board/writing";
		
	}
	
    //TODO : 게시글 등록 폼 호출
	@Secured("ROLE_USER")
	@RequestMapping(value = "/{boardId}/{categoryId}/writeForm")
	public String openWriteForm(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			Model model) {
		
		model.addAttribute("boardid", boardId);
		model.addAttribute("categoryid", categoryId);
		
		return "board/writeform";
	}
	
	//TODO : 게시글 수정 폼 호출
	@Secured("ROLE_USER")
	@RequestMapping(value="/{boardId}/{categoryId}/modifyForm", method = RequestMethod.POST)
	public String openModifyForm(
			@PathVariable int boardId,
			@PathVariable int categoryId,
			@RequestParam(value = "writeNo") int writeNo,
			Model model,
			Authentication authentication,
			HttpServletResponse response
			) throws IOException {
		
		User user = (User) authentication.getPrincipal();
		Commboard commboard = boardService.getCommboard(writeNo);
		
		if (commboard.getUser().getUserId() != user.getUserId()) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "게시물 수정 권한이 없습니다");
		}
		
		model.addAttribute("boardid", boardId);
		model.addAttribute("categoryid", categoryId);
		model.addAttribute("commboard", commboard);
		
		return "board/modifyform";
	}
    
	//게시글 등록
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{boardId}/{categoryId}/write", method = RequestMethod.POST)
    public String create(
    		@PathVariable int boardId,
            @PathVariable int categoryId,
            @ModelAttribute Commboard commboard,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        
        commboard.setBoardId(boardId);
        commboard.setCategoryId(categoryId);
        commboard.setUser(user);

        boardService.create(commboard);

        return "redirect:/community/" + boardId + "/" + categoryId;
    }

    //게시글 수정
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{boardId}/{categoryId}/modify/{writeNo}", method = RequestMethod.POST)
    public String modify(
    		@PathVariable int boardId,
            @PathVariable int categoryId,
            @PathVariable int writeNo,
            @ModelAttribute Commboard commboard,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        
        commboard.setWriteNo(writeNo);
        commboard.setUser(user);
        
        boardService.modify(commboard);

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

        boardService.delete(writeNo);

        return "redirect:/community/" + boardId + "/" + categoryId;
    }
}
