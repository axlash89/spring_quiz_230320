package com.quiz.lesson07.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;

@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {
	
	// 이건 다 JPQL => Entity에 조회하는 개념
	public List<RecruitEntity> findByCompanyId(int companyId);
	
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
//	public List<RecruitEntity> findByRegionAndSalaryGreaterThanEqualAndSalaryLessThanEqual(String region, int minSalary, int maxSalary);
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int start, int end);
	
	
	// native query => DB에 직접 조회(Mysql 쿼리문)
	@Query(value = "select * from recruit where deadline > :deadline and salary >= :salary and type = :type order by salary desc", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAndSalaryAndType(@Param("deadline") String deadline, @Param("salary") int salary, @Param("type") String type);
	
}
