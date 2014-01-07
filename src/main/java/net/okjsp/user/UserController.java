package net.okjsp.user;

import net.okjsp.common.model.Result;
import net.okjsp.layout.BasicLayoutController;
import net.okjsp.user.model.User;
import net.okjsp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * User: langerhans
 * Date: 2013. 12. 26.
 * Time: 오후 2:07
 * Description : UserController
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BasicLayoutController {

    @Autowired
    UserService userService;

    /**
     * 회원 로그인 Form
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {

        return "user/login";
    }

    /**
     * 회원 가입 Form
     * @return
     */
    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public String signUpForm(Model model) {

        model.addAttribute("userForm", new User());

        return "user/sign_up";
    }

    /**
     * 회원 가입 Processing
     * @param user
     * @return
     */
    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String signUp(
            @ModelAttribute("userForm") @Valid User user,
            BindingResult bindingResult,
            RedirectAttributes ra) {

        if(bindingResult.hasErrors()){
            return "user/sign_up";
        }

        try {
            boolean success = userService.create(user);
            ra.addFlashAttribute("result", new Result(success, "가입이 완료되었습니다."));
        } catch (Exception e) {
            bindingResult.addError(new ObjectError("", e.getMessage()));
            return "user/sign_up";
        }

        return "redirect:/user/login";
    }
}
