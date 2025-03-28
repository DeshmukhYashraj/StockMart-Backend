package com.smartmart.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartmart.app.models.UserProfile;
import com.smartmart.app.services.RegistartionService;


@RestController
@RequestMapping("/register")
public class RegistrationController {
	@Autowired
	private RegistartionService registartionService;
	@PostMapping("/peronalInfo")
	public String savePersonalDetail(@RequestBody UserProfile uProfile) {
		boolean result = registartionService.isSaveData(uProfile);
        return result  ? "User profile saved successfully" : "Failed to save user profile";
	}
	
	@GetMapping("/login")
	public String getRole(@RequestParam String username, @RequestParam String password) {
	    return registartionService.isGetRole(username, password); 
	}

	

}
