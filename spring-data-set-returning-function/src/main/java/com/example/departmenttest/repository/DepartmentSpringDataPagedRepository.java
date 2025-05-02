package com.example.departmenttest.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.departmenttest.QueryConstants;
import com.example.departmenttest.dto.DepartmentDto;
import com.example.departmenttest.entity.Department;

public interface DepartmentSpringDataPagedRepository extends JpaRepository<Department, Long> {


	
	//Paginati
	
	@Query(QueryConstants.QUERY_SET_RETURN_FUNCTION)
	Page<DepartmentDto> findDepartementWithFunction(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Pageable pageable);

	@Query(QueryConstants.QUERY_SET_RETURN_FUNCTION_NO_ALIAS)
	Page<DepartmentDto> findDepartementWithFunctionNoAlias(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Pageable pageable);

	@Query(QueryConstants.QUERY_JOIN_FUNCTION)
	Page<DepartmentDto> findDepartementWithJoinFunction(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Pageable pageable);

	@Query(QueryConstants.QUERY_JOIN_FUNCTION_NO_ALIAS)
	Page<DepartmentDto> findDepartementWithJoinFunctionNoAlias(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Pageable pageable);

	@Query(QueryConstants.QUERY_PRIMARY_JOIN_FUNCTION)
	Page<DepartmentDto> findDepartementWithPrimaryJoinFunction(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Pageable pageable);

	@Query(QueryConstants.QUERY_FUNCTION_FROM_SUB_QUERY)
	Page<DepartmentDto> findDepartementByFunctionFromSubQuery(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Pageable pageable);

	@Query(QueryConstants.QUERY_JOIN_FUNCTION_FROM_SUB_QUERY)
	Page<DepartmentDto> findDepartementJoinFunctionIntoSubQuery(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Pageable pageable);

	@Query(QueryConstants.QUERY_JOIN_LATERAL_FUNCTION_FROM_SUB_QUERY)
	Page<DepartmentDto> findDepartementJoinLateralFunctionIntoSubQuery(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Pageable pageable);

	@Query(QueryConstants.QUERY_SET_RETURN_FUNCTION_JOIN_WITH_FUNCTION)
	Page<DepartmentDto> findDepartementJoinFunctions(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Pageable pageable);


}