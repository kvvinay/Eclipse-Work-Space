package com.kvvinay;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Trim the spaces at first and last of the String
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimmer);
	}
	
	@RequestMapping("/showForm")
	public String ShowPage(Model model) {
		model.addAttribute("customer",new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String ProcessFrom(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindResult) {
		System.out.println("\n\n\n");
		System.out.println(bindResult);

		if(bindResult.hasErrors()) {
			return "customer-form";
		}else {
			return "customer-processsfrom";
		}
	
	}
	
	
	

}
