package com.Employe.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employe.model.Employe;

public interface IEmployeRepository extends JpaRepository<Employe, Integer> {

}
