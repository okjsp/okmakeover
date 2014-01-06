package net.okjsp.layout;

import net.okjsp.layout.model.Navigation;
import net.okjsp.layout.service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 12. 22.
 * Time: 오전 5:41
 * Description : 화면 공통 레이아웃을 위한 Controller
 */
@Controller
public class BasicLayoutController {

    @Autowired
    LayoutService layoutService;

    @ModelAttribute("NAV_LIST")
    public List<Navigation> nav() {
        return layoutService.getNav();
    }
}
