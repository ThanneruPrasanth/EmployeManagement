package com.Employe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employe.model.Employe;
import com.Employe.service.IEmployeService;

@RestController
public class EmployeController {
	
	@Autowired
	IEmployeService employeService;
	
	@GetMapping("/hello")
	public String displayString() {
		
		return "Good Morning ! ";
	}
	
	@PostMapping("/employe")
	Integer createEmploye(@RequestBody Employe employe) {
		Integer id=employeService.saveEmploye(employe);
		System.out.println(id);
		return id;
		
	}
	
	@GetMapping("/allemployes")
	public List<Employe> getEmployes(){
		
		return employeService.getAllEmployes() ;
	}
	
	
	
	
	
	
	

}
