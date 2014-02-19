package net.okjsp.post;

import java.util.List;

import net.okjsp.common.model.Paging;
import net.okjsp.layout.BasicLayoutController;
import net.okjsp.post.model.Post;
import net.okjsp.post.service.PostService;
import net.okjsp.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: choong
 * Date: 2014. 02. 18.
 * Time: 오후 2:07
 * Description : PostController
 */
@Controller
@RequestMapping(value = "/user")
public class PostController extends BasicLayoutController {

    @Autowired
    private PostService postService;

    @Secured("ROLE_USER")
    @RequestMapping(value = "/messageList/{type}", method = RequestMethod.GET)
    public String messageList(@PathVariable String type, Model model, Paging paging, Authentication authentication ) {
    	
    	User user = (User) authentication.getPrincipal();
    	
    	List<Post> postList = postService.getPostList(String.valueOf(user.getUserId()), type, paging);
    	int totalCounlt = postService.getPostTotalCount(String.valueOf(user.getUserId()), type);
    	
    	paging.setListCount(postList.size());
        paging.setTotalCount(totalCounlt);

        model.addAttribute("postList", postList);
        model.addAttribute("paging", paging);
        
        return "user/message_list";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String viewMessage(@RequestParam(value="targetId", defaultValue="") String targetId, 
    		Model model) {
    	model.addAttribute("targetId", targetId);
        return "user/message_from";
    }
    @Secured("ROLE_USER")
    @RequestMapping(value = "/message/{targetId}", method = RequestMethod.POST)
    public String sendMessage(@PathVariable String targetId,Post post ) {
    	Post fromPost = new Post();
    	Post toPost = new Post();
    	postService.addPost(fromPost, toPost);
        return "redirect:user/message_from";
    }
    
    @Secured("ROLE_USER")
    @RequestMapping(value = "/messageInfo/{id}", method = RequestMethod.GET)
    public String sendMessage(@PathVariable String id, Model model,Authentication authentication ) {
    	User user = (User) authentication.getPrincipal();
    	List<Post> postList = postService.getPostDetailList(id, String.valueOf(user.getUserId()));
    	model.addAttribute("postList", postList);
    	
        return "redirect:user/message_view";
    }
    
}
