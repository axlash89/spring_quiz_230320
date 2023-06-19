package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {
	
	public RealEstate selectRealEstateById(int id);

	public List<RealEstate> selectRealEstateListByRentPrice(@Param("rentPrice")int rentPrice);
	
	public List<RealEstate> selectRealEstateListByAreaPrice(@Param("area")int area, @Param("price")int price);
															// 두개 이상일때는 반드시 @Param 표기
															// mybatis는 파라미터를 하나만 인식할 수 있기 때문에
															// 하나의 맵으로 만들어 보내야 한다.
															// 맵으로 만들어주는 어노테이션 @Param
															// @Param("키") => xml #{키}
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId, 
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice);
	
	public int updateTypePriceById(
			int id, 
			String type, 
			int price);
	
}
