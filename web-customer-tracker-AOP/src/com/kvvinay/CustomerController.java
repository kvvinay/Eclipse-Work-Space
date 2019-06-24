package com.kvvinay;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.kvvinay.entity.Customer;
import com.kvvinay.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimmer);
	}
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> thecustomer = customerService.getCustomerr();
		
		theModel.addAttribute("customer",thecustomer);
		
		return "list-customers";
	}
	
	@GetMapping("/ShowFormForAdd")
	public String addCustomerForm(Model model) {
		 Customer c = new Customer();
		 
		 model.addAttribute("customer",c);
		
		return "customer-form";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindresult) {
		System.out.println("\n");
		System.out.println(bindresult);
		if(bindresult.hasErrors()) {
			return "customer-form";
		}else {
			customerService.saveCustomer(theCustomer);
			return "redirect:/customer/list";
		}
	}

	@GetMapping("/showFormForUpdate")
	public String showformUpdate(@RequestParam("customer") int id, Model model) {
		
		Customer c = customerService.getCustomer(id);
		
		model.addAttribute("customer",c);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomerFromList(@RequestParam("customer") int id, Model model) {
		System.out.println(id);
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	
}


