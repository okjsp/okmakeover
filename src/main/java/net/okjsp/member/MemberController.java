package net.okjsp.member;

import net.okjsp.layout.BasicLayoutController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: langerhans
 * Date: 2013. 12. 26.
 * Time: 오후 2:07
 * Description : MemberController
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController extends BasicLayoutController {

    /**
     * 회원 로그인 Form
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "text/html")
    public String loginForm() {

        return "member/login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET, produces = "text/html")
    public String signUp() {

        return "member/sign_up";
    }
}
