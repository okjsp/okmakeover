package net.okjsp.sample;

import net.okjsp.common.model.Paging;
import net.okjsp.layout.BasicLayoutController;
import net.okjsp.sample.model.Sample;
import net.okjsp.sample.service.SampleBoardService;
import net.okjsp.user.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 10. 30.
 * Time: 오전 1:30
 * Description : Sample Controller
 */

@Controller
@RequestMapping(value="/sample")
public class SampleController extends BasicLayoutController {

    @Autowired
    SampleBoardService sampleBoardService;

    /**
     * 목록으로 Redirection
     * @return
     */
    @RequestMapping(value="")
    public String main() {
        return "redirect:/sample/1";
    }

    /**
     * Sample 목록
     * @param categoryId
     * @param paging
     * @param model
     * @return
     */
    @RequestMapping(value="/{categoryId}", method = RequestMethod.GET)
    public String list(@PathVariable int categoryId, Paging paging, Model model) {

        List<Sample> list = sampleBoardService.getList(categoryId, paging);

        int count = sampleBoardService.getTotalCount(categoryId);

        paging.setListCount(list.size());
        paging.setTotalCount(count);

        model.addAttribute("samples", list);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("paging", paging);

        return "sample/sample_list";
    }

    /**
     * Sample 내용 보기
     * @param categoryId
     * @param id
     * @param paging
     * @param model
     * @return
     */
    @RequestMapping(value="/{categoryId}/{id}", method = RequestMethod.GET)
    public String view(
            @PathVariable int categoryId,
            @PathVariable int id,
            Paging paging,
            Model model) {

        Sample sampleBoard = sampleBoardService.getOne(id);

        model.addAttribute("sample", sampleBoard);
        model.addAttribute("categoryId", categoryId);

        return "sample/sample_view";
    }

    /**
     * Sample 등록 폼
     * @param categoryId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{categoryId}/create", method = RequestMethod.GET)
    public String createForm(
            @PathVariable int categoryId,
            Model model) {

        Sample sampleBoard = new Sample();

        model.addAttribute("sampleBoardForm", sampleBoard);
        model.addAttribute("categoryId", categoryId);

        return "sample/sample_form";
    }

    /**
     * Sample 등록
     * @param categoryId
     * @param sample
     * @param model
     * @return
     */
    @RequestMapping(value = "/{categoryId}/create", method = RequestMethod.POST)
    public String create(
            @PathVariable int categoryId,
            Sample sample,
            Model model) {

        sample.setCategoryId(categoryId);
        sample.setWriteId("테스터");

        sampleBoardService.create(sample);

        return "redirect:/sample/"+categoryId;
    }

    /**
     * Sample 수정 폼
     * @param categoryId
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{categoryId}/modify/{id}", method = RequestMethod.GET)
    public String modifyForm(
            @PathVariable int categoryId,
            @PathVariable int id,
            Model model) {

        Sample sampleBoard = sampleBoardService.getOne(id);

        model.addAttribute("sampleBoardForm", sampleBoard);
        model.addAttribute("categoryId", categoryId);

        return "sample/sample_form";

    }

    /**
     * Sample 수정
     * @param categoryId
     * @param sample
     * @return
     */
    @RequestMapping(value = "/{categoryId}/modify/{id}", method = RequestMethod.POST)
    public String modify(
            @PathVariable int categoryId,
            Sample sample) {

        sampleBoardService.modify(sample);

        return "redirect:/sample/"+categoryId;
    }

    /**
     * Sample 삭제
     * @param categoryId
     * @param id
     * @return
     */
    @RequestMapping(value = "/{categoryId}/remove/{id}", method = RequestMethod.DELETE)
    public String remove(
            @PathVariable int categoryId,
            @PathVariable int id) {

        sampleBoardService.destroy(id);

        return "redirect:/sample/"+categoryId;
    }

}
