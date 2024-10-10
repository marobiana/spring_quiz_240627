package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson04.domain.Seller;

@Mapper
public interface SellerMapper {

	// input: params
	// output: 성공한 행 개수(int)
	public int insertSeller(
			@Param("nickname") String nickname,
			@Param("profileImageUrl") String profileImageUrl,
			@Param("temperature") double temperature);
	
	// input:X
	// output:Seller
	public Seller selectLatestSeller();
	
	public Seller selectSellerById(int id);
}




