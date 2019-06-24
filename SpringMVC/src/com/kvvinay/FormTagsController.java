package com.kvvinay;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class FormTagsController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		FormTags tags = new FormTags();
		
		model.addAttribute("student",tags);
			
		return "student-form";
		
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") FormTags tags ) {
		
		
		System.out.println("Firstname: "+tags.getFirstName());
		System.out.println("Last name: "+tags.getLastName());
		System.out.println("Country: "+tags.getCountry());
		System.out.println("Language: "+tags.getLanguage());

		return "Studentprocess-form";
	}
	
	

}
