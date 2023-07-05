package com.quiz.lesson07.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;

@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {
	
	public List<RecruitEntity> findAllByCompanyId(int companyId);
	
	public List<RecruitEntity> findAllByPositionAndType(String position, String type);
	
	public List<RecruitEntity> findAllByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	public List<RecruitEntity> findAllByRegionAndSalaryGreaterThanEqualAndSalaryLessThanEqual(String region, int minSalary, int maxSalary);
	
	// native query
	@Query(value = "select * from recruit where deadline>=:deadline and salary>=:salary and type=:type order by salary desc", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAndSalaryAndType(@Param("deadline") String deadline, @Param("salary") int salary, @Param("type") String type);
	
}
