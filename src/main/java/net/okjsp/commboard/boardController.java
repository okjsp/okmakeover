package net.okjsp.commboard;

import java.util.List;

import net.okjsp.commboard.model.Board;
import net.okjsp.commboard.service.BoardService;
import net.okjsp.layout.BasicLayoutController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: yawn
 * Date: 2014. 01. 14.
 * Time: 오전 2:46
 * Description : 공통 게시판을 위한 Controller
 */

@Controller
@RequestMapping(value = "/community")
public class boardController extends BasicLayoutController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="")
	public String CommunityBoardList(Model model) {
		List<Board> communityBoardList = boardService.getCommunityBoardList();
		
		model.addAttribute("boardList", communityBoardList);
		
		return "board/board_list";		
	}

}
