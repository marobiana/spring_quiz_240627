package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson04.domain.Realtor;

@Mapper
public interface RealtorMapper {

	public void insertRealtor(Realtor realtor);
	
	public Realtor selectRealtorById(int id);
}




