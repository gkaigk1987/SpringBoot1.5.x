package gk.springboot.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gk.springboot.com.property.MyConfiguration;
import gk.springboot.com.service.IUserService;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	private static Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private IUserService userService;
	
	@Autowired
	private MyConfiguration MyConfiguration;
	
	@RequestMapping(value = "/index")
	public String testHtml(Model model) {
		userService.getAllUsers();
		model.addAttribute("name", "gk");
		System.out.println(MyConfiguration.getName());
		return "test/index";
	}
	
}
