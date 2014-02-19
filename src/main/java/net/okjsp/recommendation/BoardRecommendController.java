package net.okjsp.recommendation;

import net.okjsp.recommendation.service.BoardRecommendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/boardRecommend")
public class BoardRecommendController {

    @Autowired
    BoardRecommendService boardRecommendService;

}

