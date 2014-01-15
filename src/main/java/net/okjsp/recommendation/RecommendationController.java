package net.okjsp.recommendation;


import net.okjsp.recommendation.model.Recommendation;
import net.okjsp.recommendation.service.RecommendationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/recommendation")
public class RecommendationController {
	
	@Autowired
	RecommendationService recommendationService;
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test(Model model) {
		
		return "recommendation/test";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String test(@ModelAttribute Recommendation r) {
		System.out.println(r.getUserId());
		System.out.println(r.getBoardId());
		System.out.println(r.getWriteNo());
		System.out.println(r.getCommentId());
		System.out.println(r.getGuboonId());
		
		recommendationService.setRecommendation(r);
		
		return "redirect:/test";
	}
}

