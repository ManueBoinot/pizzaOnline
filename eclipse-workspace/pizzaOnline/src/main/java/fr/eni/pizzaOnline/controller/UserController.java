package fr.eni.pizzaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eni.pizzaOnline.service.UtilisateurService;

@Controller
public class UserController {
	
	@Autowired
	UtilisateurService utilisateurService;
	
	@GetMapping("/login")
	public String commander(Model model) {
		return "login";
	}

}
