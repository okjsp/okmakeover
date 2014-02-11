package net.okjsp.sample;

import net.okjsp.common.model.Paging;
import net.okjsp.common.model.PagingList;
import net.okjsp.common.model.Result;
import net.okjsp.layout.BasicLayoutController;
import net.okjsp.sample.model.Sample;
import net.okjsp.sample.service.SampleBoardService;
import net.okjsp.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 10. 30.
 * Time: 오전 1:30
 * Description : Sample Controller for AngularJS
 */

@Controller
@RequestMapping(value="/sample_ng")
public class SampleNgController extends BasicLayoutController {

    @Autowired
    SampleBoardService sampleBoardService;

    /**
     * 기본 Layout Load
     *
     * AngularJS 의 $routeProvider 의 html5 mode 사용시 Reload / 외부진입을 위해서 when에 사용되는 모든 url을
     * RequestMapping 의 value 에 등록해준다.
     *
     * @return
     */
    @RequestMapping(value = {"/{categoryId}", "/{categoryId}/view/{id}", "/{categoryId}/modify/{id}", "/{categoryId}/create"}, method = RequestMethod.GET)
    public String main() {
        return "sample_ng/sample_ng";
    }

}
