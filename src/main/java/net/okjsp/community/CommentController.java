package net.okjsp.community;

import java.util.List;

import net.okjsp.community.model.Comment;
import net.okjsp.community.service.CommentService;
import net.okjsp.common.model.Paging;
import net.okjsp.layout.BasicLayoutController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/comment")
public class CommentController extends BasicLayoutController {
	@Autowired
    CommentService commentService;

    @Secured("ROLE_USER")
    @RequestMapping(value="/comment/list/{boardNo}/{writeNo}", method = RequestMethod.GET)
    public String list(
    		@PathVariable String boardNo,
    		@PathVariable String writeNo,
            String searchflg,
            String search,
            String sort,
            Paging paging, 
            Model model) {
 
        List<Comment> list = commentService.getList(boardNo, writeNo, searchflg, search, sort, paging);

        int count = commentService.getTotalCount(boardNo, writeNo);

        paging.setListCount(list.size());
        paging.setTotalCount(count);

        model.addAttribute("comments", list);
        model.addAttribute("paging", paging);

        return "comment/comment_list";
    }

 
    @Secured("ROLE_USER")
    @RequestMapping(value="/comment/view/{boardNo}/{writeNo}/{commentId}", method = RequestMethod.GET)
    public String view(
    		@PathVariable String boardNo,
    		@PathVariable String writeNo,
    		@PathVariable String commentId, 
            Model model) {

        Comment comment = commentService.getOne(boardNo, writeNo, commentId);

        model.addAttribute("Comment", comment); 
        return "comment/comment_view";
    }

 
 
    @Secured("ROLE_USER")
    @RequestMapping(value = "/comment/create_form/{boardNo}/{writeNo}", method = RequestMethod.GET)
    public String createForm(
    		@PathVariable String boardNo,
    		@PathVariable String writeNo,
            Model model) {

        Comment comment = new Comment();
        comment.setBoardNo(boardNo);
        comment.setWriteNo(writeNo);

        model.addAttribute("comment", comment); 

        return "comment/comment_form";
    }

 
    @Secured("ROLE_USER")
    @RequestMapping(value = "/comment/create", method = RequestMethod.POST)
    public String create(
            Comment comment,
            Model model) {

         commentService.create(comment);

        return "redirect:/comment/list/{" + comment.getBoardNo() +"}/{" + comment.getWriteNo() + "}";
    }

 
    @Secured("ROLE_USER")
    @RequestMapping(value = "/comment/modify/{boardNo}/{writeNo}/{commentNo}", method = RequestMethod.GET)
    public String modifyForm(
    		@PathVariable String boardNo,
    		@PathVariable String writeNo,
    		@PathVariable String commentId,
            Model model) {

        Comment comment = new Comment();
        comment.setBoardNo(boardNo);
        comment.setWriteNo(writeNo);
        comment.setCommentId(commentId);

        model.addAttribute("CommentForm", comment); 

        return "comment/comment_form";

    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/comment/modify", method = RequestMethod.POST)
    public String modify(
            Comment comment) {

        commentService.modify(comment);

        return "redirect:/comment/list/{" + comment.getBoardNo() +"}/{" + comment.getWriteNo() + "}";
    }

 
    @Secured("ROLE_USER")
    @RequestMapping(value = "/comment/remove", method = RequestMethod.DELETE)
    public String remove( Comment comment) {

        commentService.destroy(comment);

        return "redirect:/comment/list/{" + comment.getBoardNo() +"}/{" + comment.getWriteNo() + "}";
           }	
}
