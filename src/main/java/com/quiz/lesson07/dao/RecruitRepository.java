package com.quiz.lesson07.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;

@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {
	
	public List<RecruitEntity> findAllByCompanyId(int companyId);
	
	public List<RecruitEntity> findAllByPositionAndType(String position, String type);
	
	public List<RecruitEntity> findAllByTypeAndSalaryGreaterThanEqual(String type, int salary);
	
}
