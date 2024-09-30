package com.quiz.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	// input: id(int)
	// output: RealEstate(DTO)
	public RealEstate selectRealEstateById(int id);
}
