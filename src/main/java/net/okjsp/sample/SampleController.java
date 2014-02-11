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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
     * @return
     */
    @RequestMapping(value="/{categoryId}.json", method = RequestMethod.GET)
    public @ResponseBody PagingList list(@PathVariable int categoryId, Paging paging) {

        List<Sample> list = sampleBoardService.getList(categoryId, paging);

        int count = sampleBoardService.getTotalCount(categoryId);

        paging.setListCount(list.size());
        paging.setTotalCount(count);

        PagingList pagingList = new PagingList(paging, list);

        return pagingList;
    }

    /**
     * Sample 목록 As HTML
     * @param categoryId
     * @param paging
     * @param model
     * @return
     */
    @RequestMapping(value="/{categoryId}", method = RequestMethod.GET)
    public String listAsHTML(@PathVariable int categoryId, Paging paging, Model model) {

        PagingList pagingList = this.list(categoryId, paging);

        model.addAttribute("samples", pagingList.getList());
        model.addAttribute("paging", pagingList.getPaging());
        model.addAttribute("categoryId", categoryId);

        return "sample/sample_list";
    }



    /**
     * Sample 내용 보기
     * @param categoryId
     * @param id
     * @return
     */
    @RequestMapping(value="/{categoryId}/{id}.json", method = RequestMethod.GET)
    public @ResponseBody Sample view(
            @PathVariable int categoryId,
            @PathVariable int id) {

        //조회수 증가
        sampleBoardService.addViewCount(id);

        Sample sampleBoard = sampleBoardService.getOne(id);

        return sampleBoard;
    }


    /**
     * Sample 내용 보기 As HTML
     * @param categoryId
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/{categoryId}/{id}", method = RequestMethod.GET)
    public String viewAsHTML(
            @PathVariable int categoryId,
            @PathVariable int id,
            Model model) {

        Sample sampleBoard = this.view(categoryId, id);

        model.addAttribute("sample", sampleBoard);
        model.addAttribute("categoryId", categoryId);

        return "sample/sample_view";
    }

    /**
     * Sample 등록
     * @param categoryId
     * @param sample
     * @param authentication
     * @return
     *
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{categoryId}.json", method = RequestMethod.POST)
    public @ResponseBody Result create(
            @PathVariable int categoryId,
            @RequestBody Sample sample,
            Authentication authentication) {

        Result result;

        User user = (User) authentication.getPrincipal();

        sample.setCategoryId(categoryId);
        sample.setWriteId(user.getUserId());

        boolean isCreated = sampleBoardService.create(sample);

        if(isCreated) {
            result = new Result(isCreated, "등록이 완료되었습니다.");
        } else {
            result = new Result(isCreated, "등록중 오류가 발생하였습니다.");
        }

        return result;
    }

    /**
     * Sample 등록 폼
     * @param categoryId
     * @param model
     * @return
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{categoryId}/create", method = RequestMethod.GET)
    public String createFormAsHTML(
            @PathVariable int categoryId,
            Model model) {

        Sample sampleBoard = new Sample();

        model.addAttribute("sampleBoard", sampleBoard);
        model.addAttribute("categoryId", categoryId);

        return "sample/sample_create";
    }

    /**
     * Sample 등록 By Form Submit
     * @param categoryId
     * @param sample
     * @param authentication
     * @return
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{categoryId}", method = RequestMethod.POST)
    public String createByForm(
            @PathVariable int categoryId,
            Sample sample,
            Authentication authentication,
            Model model,
            RedirectAttributes redirectAttributes) {

        Result result = this.create(categoryId, sample, authentication);

        if(result.isSuccess()) {
            redirectAttributes.addFlashAttribute("result", result);
            return "redirect:/sample/"+categoryId;
        } else {
            model.addAttribute("result", result);
            return "sample/sample_create";
        }
    }

    /**
     * Sample 수정
     * @param categoryId
     * @param sample
     * @return
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{categoryId}/{id}.json", method = RequestMethod.POST)
    public @ResponseBody Result modify(
            @PathVariable int categoryId,
            @PathVariable int id,
            @RequestBody Sample sample,
            Authentication authentication) {

        Result result;

        User user = (User) authentication.getPrincipal();

        sample.setId(id);
        sample.setCategoryId(categoryId);
        sample.setUpdateId(user.getUserId());

        boolean isUpdated = sampleBoardService.modify(sample);

        if(isUpdated) {
            result = new Result(isUpdated, "수정이 완료되었습니다.");
        } else {
            result = new Result(isUpdated, "수정중 오류가 발생하였습니다.");
        }

        return result;
    }

    /**
     * Sample 수정 폼 AS HTML
     * @param categoryId
     * @param id
     * @param model
     * @return
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{categoryId}/{id}/modify", method = RequestMethod.GET)
    public String modifyFormAsHTML(
            @PathVariable int categoryId,
            @PathVariable int id,
            Model model) {

        Sample sampleBoard = sampleBoardService.getOne(id);

        model.addAttribute("sampleBoard", sampleBoard);
        model.addAttribute("categoryId", categoryId);

        return "sample/sample_modify";

    }

    /**
     * Sample 수정 By Form Submit
     * @param categoryId
     * @param sample
     * @return
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{categoryId}/{id}", method = RequestMethod.POST)
    public String modifyByForm(
            @PathVariable int categoryId,
            @PathVariable int id,
            Sample sample,
            Model model,
            RedirectAttributes redirectAttributes,
            Authentication authentication) {

        Result result = this.modify(categoryId, id, sample, authentication);

        if(result.isSuccess()) {
            redirectAttributes.addFlashAttribute("result", result);
            return "redirect:/sample/"+categoryId;
        } else {
            model.addAttribute("result", result);
            return "sample/sample_modify";
        }
    }

    /**
     * Sample 삭제
     * @param categoryId
     * @param id
     * @return
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{categoryId}/{id}.json", method = RequestMethod.DELETE)
    public @ResponseBody Result remove(
            @PathVariable int categoryId,
            @PathVariable int id,
            Authentication authentication) {

        Result result;

        boolean isDeleted = sampleBoardService.destroy(id);

        if(isDeleted) {
            result = new Result(isDeleted, "삭제가 완료되었습니다.");
        } else {
            result = new Result(isDeleted, "삭제중 오류가 발생하였습니다.");
        }

        return result;
    }

    /**
     * Sample 삭제 By Form Submit
     * @param categoryId
     * @param id
     * @return
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/{categoryId}/{id}", method = RequestMethod.DELETE)
    public String removeByForm(
            @PathVariable int categoryId,
            @PathVariable int id,
            Model model,
            RedirectAttributes redirectAttributes,
            Authentication authentication) {

        Result result = this.remove(categoryId, id, authentication);
        redirectAttributes.addFlashAttribute("result", result);

        return "redirect:/sample/"+categoryId;
    }

}
