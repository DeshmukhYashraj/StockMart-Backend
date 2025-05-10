package com.smartmart.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartmart.app.models.UserProfile;
import com.smartmart.app.repositories.ResgistrationRepo;

@Service
public class RegistartionService {
	@Autowired
	private ResgistrationRepo repo;
	public boolean isSaveData(UserProfile userProfile) {
		return repo.isSaveData(userProfile);
	}
	public String isGetRole(String username,String password) {
		return repo.isGetRole(username, password);
	}
}
