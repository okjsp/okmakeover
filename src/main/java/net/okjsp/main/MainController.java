package net.okjsp.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: langerhans
 * Date: 2013. 10. 30.
 * Time: 오전 12:45
 * Description : Main
 */
@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String main(Model model) {

        model.addAttribute("message", "Hello OK JSP!!!");

        return "main";
    }
}
