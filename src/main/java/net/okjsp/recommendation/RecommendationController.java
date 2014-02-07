package net.okjsp.recommendation;

import net.okjsp.recommendation.service.RecommendationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/recommendation")
public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;

}

