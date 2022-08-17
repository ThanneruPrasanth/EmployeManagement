package com.Employe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employe.exception.ResouceNotFoundException;
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

	@Override
	public Optional<Employe> getEmployeById(Integer id) {

		return employeRepository.findById(id);
	}

	@Override
	public void deleteEmployeById(Integer id) {
		employeRepository.deleteById(id);
	}

	@Override
	public String deleteAllEmployes() {
		employeRepository.deleteAll();
		return "Delete all";

	}

	@Override
	public Employe updateEmploye(Employe employe, Integer id) {

		Employe existingemploye = employeRepository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Employe", "id", id));

		existingemploye.setFirstname(employe.getFirstname());
		existingemploye.setLastname(employe.getLastname());
		existingemploye.setEmail(employe.getEmail());

		employeRepository.save(existingemploye);

		return existingemploye;
	}
	

}
