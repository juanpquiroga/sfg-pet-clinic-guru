package co.com.rockthorum.sfgpetclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.rockthorum.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private OwnerService ownerService;
	
	@Autowired
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({"","/","/index","/index.html"})
	public String listOwner(Model model) {
		model.addAttribute("owners",ownerService.findAll());
		return "owners/index";
	}
	
	@RequestMapping({"/find"})
	public String findOwners(Model model) {
		return "notimplemented";
	}
}
