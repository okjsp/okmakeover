package net.okjsp.main;

import net.okjsp.layout.BasicLayoutController;
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
public class MainController extends BasicLayoutController {

    @RequestMapping(value = "/")
    public String main(Model model) {

        model.addAttribute("message", "Hello OK JSP!!!");

        return "main";
    }
}
