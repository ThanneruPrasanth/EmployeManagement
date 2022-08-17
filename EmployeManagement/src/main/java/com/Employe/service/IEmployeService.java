package com.Employe.service;

import java.util.List;
import java.util.Optional;

import com.Employe.model.Employe;

public interface IEmployeService {
	
Integer saveEmploye(Employe employe);
	
	public List<Employe> getAllEmployes();
	
	Optional<Employe> getEmployeById(Integer id);
	
	public void deleteEmployeById(Integer id);
	
	String deleteAllEmployes();
	
	Employe updateEmploye(Employe employe,Integer id);

}
