package net.okjsp.techqna;

import net.okjsp.techqna.service.TechQnaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	

}
