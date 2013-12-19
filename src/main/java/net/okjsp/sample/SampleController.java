package net.okjsp.sample;

import net.okjsp.common.model.Paging;
import net.okjsp.sample.model.Sample;
import net.okjsp.sample.service.SampleBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value="/{categoryId}", method = RequestMethod.GET, headers = "Accept=text/html")
    public String list(@PathVariable int categoryId, Paging paging, Model model) {

        List<Sample> list = sampleBoardService.getList(categoryId, paging);

        model.addAttribute("data", list);
        model.addAttribute("categoryId", categoryId);

        return "sample/list";
    }

    @RequestMapping(value="/{categoryId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody List<Sample> listAsJson(@PathVariable int categoryId, Paging paging) {

        List<Sample> list = sampleBoardService.getList(categoryId, paging);

        return list;
    }

    @RequestMapping(value="/{categoryId}/{id}", method = RequestMethod.GET, headers = "Accept=text/html")
    public String view(
            @PathVariable int categoryId,
            @PathVariable int id,
            Paging paging,
            Model model) {

        Sample sampleBoard = sampleBoardService.getOne(id);

        model.addAttribute("data", sampleBoard);
        model.addAttribute("categoryId", categoryId);

        return "sample/view";
    }

    @RequestMapping(value = "/{categoryId}/create", method = RequestMethod.GET, headers = "Accept=text/html")
    public String create(
            @PathVariable int categoryId,
            Model model) {

        Sample sampleBoard = new Sample();

        model.addAttribute("sampleBoardForm", sampleBoard);
        model.addAttribute("categoryId", categoryId);

        return "sample/create";
    }

}
