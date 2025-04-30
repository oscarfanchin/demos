package com.example.departmenttest.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.departmenttest.QueryConstants;
import com.example.departmenttest.dto.DepartmentDto;
import com.example.departmenttest.entity.Department;

@Repository
@ConditionalOnProperty(name = "test.broken-query.enabled", havingValue = "true", matchIfMissing = false)
public interface BrokenQueryRepository extends JpaRepository<Department, Long> {

	@Query(QueryConstants.QUERY_SET_RETURN_FUNCTION)
	List<DepartmentDto> boom(@Param("date") LocalDate date);
}