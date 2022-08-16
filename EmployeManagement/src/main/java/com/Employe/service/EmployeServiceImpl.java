package com.Employe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employe.model.Employe;

@Service
public class EmployeServiceImpl implements IEmployeService {
	
	@Autowired
	IEmployeRepository employeRepository;

	@Override
	public Integer saveEmploye(Employe employe) {
		Employe savedEmploye = employeRepository.save(employe);
		
		return savedEmploye.getId();
	}

	@Override
	public List<Employe> getAllEmployes() {
		
		return employeRepository.findAll();
	}
	

}
