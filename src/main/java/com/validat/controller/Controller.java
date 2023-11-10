package com.validat.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validat.entity.User;

import jakarta.validation.Valid;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/form")
	public String openForm(Model model) {
		System.out.println("Opening Form");
		model.addAttribute("user",new User());
		return "form";
	}
	

	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("user") User user,BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		System.out.println("user is "+user);
		return "success";
	}
}
