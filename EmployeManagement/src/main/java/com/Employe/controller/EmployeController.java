package com.Employe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/employe/{id}")
	public Optional<Employe> getEmployeById(@PathVariable Integer id){
		Optional<Employe> employe = employeService.getEmployeById(id);
		return employe;
	}
	
	@DeleteMapping("/employe/{id}")
	public ResponseEntity<Employe> deleteEmployeById(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<Employe> responseEntity =new ResponseEntity<>(HttpStatus.OK);
		try {
			employeService.deleteEmployeById(id);
		}catch(Exception e) {
			e.printStackTrace();
			responseEntity =new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity ;
		
	}
	
	@DeleteMapping("/deleteall")
	public String deleteAllEmployes() {
		return employeService.deleteAllEmployes();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employe> updateEmploye(@PathVariable("id") Integer id,@RequestBody Employe employe){
		return new ResponseEntity<Employe>(employeService.updateEmploye(employe, id), HttpStatus.OK);
	}

	
	
	
	
	
	

}
