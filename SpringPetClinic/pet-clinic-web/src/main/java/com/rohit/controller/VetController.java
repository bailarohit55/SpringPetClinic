package com.rohit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rohit.services.VetService;

@Controller
public class VetController {

	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}
	
	@RequestMapping({"/vets","/vets/index","/vets/index.html"})
	public String listVet(Model model) {
		
		model.addAttribute("vets", vetService.findAll());
		
		return "Vets/index.html";
	}
	
}
