package com.helloeating.DemoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helloeating.login.service.MemberSignService;

@Controller
public class JspTest {

	@Autowired
	MemberSignService memberSignService;
	
	@RequestMapping("/test")
	public String jspTest(Model model) throws Exception {
		
		int abc = memberSignService.TESTCount();
		
		System.out.println(abc);
		
		model.addAttribute("test", abc);
		
		return "test";
	}
}
