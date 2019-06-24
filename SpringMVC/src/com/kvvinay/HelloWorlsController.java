package com.kvvinay;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HelloWorlsController {
	
	@RequestMapping("/showForm")
	public String ShowForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String ProcessForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormV2")
	public String letsShoutDude(HttpServletRequest req, Model model) {
		String name = req.getParameter("studentName");
		
		name = name.toUpperCase();
		
		String result  = "YO! "+ name;
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormV3")
	public String newOne(@RequestParam("studentName") String name, Model model) {
		name = "new version V3 " + name.toUpperCase();
		model.addAttribute("message",name);
		return "helloworld";
	}
}
