package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	// public CompanyEntity save(CompanyEntity companyEntity);
	// public Optional<CompanyEntity> findById(int id);
}
