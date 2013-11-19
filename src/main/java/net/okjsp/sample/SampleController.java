package net.okjsp.sample;

import net.okjsp.common.model.Paging;
import net.okjsp.sample.model.SampleBoard;
import net.okjsp.sample.service.SampleBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 10. 30.
 * Time: 오전 1:30
 * Description :
 */

@Controller
@RequestMapping(value="/sample")
public class SampleController {

    @Autowired
    SampleBoardService sampleBoardService;

    @RequestMapping(value="")
    public String main() {
        return "redirect:/sample/1";
    }

    @RequestMapping(value="/{categoryId}")
    public String list(@PathVariable int categoryId, Paging paging, Model model) {

        List<SampleBoard> list = sampleBoardService.getList(categoryId, paging);

        model.addAttribute("data", list);

        return "sample/list";
    }

    @RequestMapping(value="/{categoryId}/{id}")
    public String list(
            @PathVariable int categoryId,
            @PathVariable int id,
            Paging paging,
            Model model) {

        SampleBoard sampleBoard = sampleBoardService.getOne(id);

        model.addAttribute("data", sampleBoard);

        return "sample/view";
    }

}
