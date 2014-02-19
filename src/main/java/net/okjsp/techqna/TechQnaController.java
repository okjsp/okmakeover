package net.okjsp.techqna;

import java.util.List;

import net.okjsp.common.model.Paging;
import net.okjsp.common.model.PagingList;
import net.okjsp.techqna.model.TechQna;
import net.okjsp.techqna.service.TechQnaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TechQna Controller
 * 
 * @author yjc0703
 *
 */
@Controller
@RequestMapping(value = "/techqna")
public class TechQnaController {
	
	@Autowired
	private TechQnaService techQnaService;
	
	@RequestMapping(value="/list.json")
	public @ResponseBody PagingList list(Paging paging, 
			@RequestParam(defaultValue="newest") String sort, 
			@RequestParam(defaultValue="") String tag) {
		
		List<TechQna> list = techQnaService.selectTechQnaList(paging, sort, tag);
		
		int totalCount = techQnaService.selectTechQnaByTagTotalCount(tag);
		paging.setTotalCount(totalCount);
		paging.setListCount(list.size());
		
		PagingList pagingList = new PagingList(paging, list);
		
		return pagingList;
	}
	
	@RequestMapping(value="/")
	public String listAsHtml(Paging paging, 
			@RequestParam(defaultValue="newest") String sort, 
			@RequestParam(defaultValue="") String tag,
			Model model) {
		PagingList pagingList = this.list(paging, sort, tag);
		
		model.addAttribute("questions", pagingList.getList());
        model.addAttribute("paging", pagingList.getPaging());
		
		return "/techqna/list";
	}
	
}
