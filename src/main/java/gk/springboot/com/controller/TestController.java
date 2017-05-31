package gk.springboot.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	
	@RequestMapping(value = "/index")
	public String testHtml(Model model) {
		model.addAttribute("name", "gk");
		return "test/index";
	}
	
}
