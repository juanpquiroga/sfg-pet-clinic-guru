package co.com.rockthorum.sfgpetclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.rockthorum.sfgpetclinic.services.VetService;

@RequestMapping("/vets")
@Controller
public class VetController {
	
	private VetService vetService;
	
	@Autowired
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	
	@RequestMapping({"","/","/index","/index.html"})
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
}
