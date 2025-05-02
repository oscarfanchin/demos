package com.example.departmenttest.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.departmenttest.QueryConstants;
import com.example.departmenttest.dto.DepartmentDto;
import com.example.departmenttest.entity.Department;

public interface DepartmentSpringDataSortRepository extends JpaRepository<Department, Long> {


	@Query(QueryConstants.QUERY_SET_RETURN_FUNCTION)
	List<DepartmentDto> findDepartementWithFunction(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Sort sort);


	@Query(QueryConstants.QUERY_SET_RETURN_FUNCTION_NO_ALIAS)
	List<DepartmentDto> findDepartementWithFunctionNoAlias(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Sort sort);


	@Query(QueryConstants.QUERY_JOIN_FUNCTION)
	List<DepartmentDto> findDepartementWithJoinFunction(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Sort sort);


	@Query(QueryConstants.QUERY_JOIN_FUNCTION_NO_ALIAS)
	List<DepartmentDto> findDepartementWithJoinFunctionNoAlias(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Sort sort);


	@Query(QueryConstants.QUERY_PRIMARY_JOIN_FUNCTION)
	List<DepartmentDto> findDepartementWithPrimaryJoinFunction(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Sort sort);


	@Query(QueryConstants.QUERY_FUNCTION_FROM_SUB_QUERY)
	List<DepartmentDto> findDepartementByFunctionFromSubQuery(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Sort sort);


	@Query(QueryConstants.QUERY_JOIN_FUNCTION_FROM_SUB_QUERY)
	List<DepartmentDto> findDepartementJoinFunctionIntoSubQuery(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Sort sort);


	@Query(QueryConstants.QUERY_JOIN_LATERAL_FUNCTION_FROM_SUB_QUERY)
	List<DepartmentDto> findDepartementJoinLateralFunctionIntoSubQuery(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Sort sort);


	@Query(QueryConstants.QUERY_SET_RETURN_FUNCTION_JOIN_WITH_FUNCTION)
	List<DepartmentDto> findDepartementJoinFunctions(@Param("date") LocalDate date, @Param("integerValue") Integer integerValue, Sort sort);



}