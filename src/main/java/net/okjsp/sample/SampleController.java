package net.okjsp.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: langerhans
 * Date: 2013. 10. 30.
 * Time: 오전 1:30
 * Description :
 */

@Controller
public class SampleController {

    @RequestMapping(value="/sample")
    public String list(Model model) {

        return "sample/list";
    }

}
