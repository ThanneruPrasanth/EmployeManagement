package com.Employe.service;

import java.util.List;

import com.Employe.model.Employe;

public interface IEmployeService {
	
	Integer saveEmploye(Employe employe);
	
	public List<Employe> getAllEmployes();

}
