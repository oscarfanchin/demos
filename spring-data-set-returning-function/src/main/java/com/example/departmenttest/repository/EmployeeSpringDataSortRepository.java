package com.example.departmenttest.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.departmenttest.QueryConstants;
import com.example.departmenttest.dto.EmployeeDto;
import com.example.departmenttest.entity.Employee;

public interface EmployeeSpringDataSortRepository extends JpaRepository<Employee, Long> {
 
	@Query(QueryConstants.TEST_STANDARD_QUERY)
	List<EmployeeDto> findTestStandardQuery(Sort sort);



}