package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {

	// public RecruitEntity findById(int id);
	
	// JPQL => Entity에 조회하는 것
	public List<RecruitEntity> findByCompanyId(int companyId);
}
