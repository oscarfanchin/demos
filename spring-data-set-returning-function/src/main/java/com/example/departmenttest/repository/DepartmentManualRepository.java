
package com.example.departmenttest.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.departmenttest.QueryConstants;
import com.example.departmenttest.dto.DepartmentDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DepartmentManualRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<DepartmentDto> findAllDepartments(LocalDate date, Integer integerValue) {
		return entityManager.createQuery(QueryConstants.QUERY_SET_RETURN_FUNCTION, DepartmentDto.class)
				.setParameter("date", date).setParameter("integerValue", integerValue).getResultList();
	}
	

	public List<DepartmentDto> findAllDepartmentsNoAlias(LocalDate date, Integer integerValue) {
		return entityManager.createQuery(QueryConstants.QUERY_SET_RETURN_FUNCTION_NO_ALIAS, DepartmentDto.class)
				.setParameter("date", date).setParameter("integerValue", integerValue).getResultList();
	}
	
	public List<DepartmentDto> findAllDepartmentsJoinFunction(LocalDate date, Integer integerValue) {
		return entityManager.createQuery(QueryConstants.QUERY_JOIN_FUNCTION, DepartmentDto.class)
				.setParameter("date", date).setParameter("integerValue", integerValue).getResultList();
	}
	
	public List<DepartmentDto> findAllDepartmentsJoinFunctionNoAlias(LocalDate date, Integer integerValue) {
		return entityManager.createQuery(QueryConstants.QUERY_JOIN_FUNCTION_NO_ALIAS, DepartmentDto.class)
				.setParameter("date", date).setParameter("integerValue", integerValue).getResultList();
	}
	
	
	public List<DepartmentDto> findAllDepartmentsPrimaryJoinFunction(LocalDate date, Integer integerValue) {
		return entityManager.createQuery(QueryConstants.QUERY_PRIMARY_JOIN_FUNCTION, DepartmentDto.class)
				.setParameter("date", date).setParameter("integerValue", integerValue).getResultList();
	}
	
	public List<DepartmentDto> findAllDepartmentsFromFunctionIntoSubQuery(LocalDate date, Integer integerValue) {
		return entityManager.createQuery(QueryConstants.QUERY_FUNCTION_FROM_SUB_QUERY, DepartmentDto.class)
				.setParameter("date", date).setParameter("integerValue", integerValue).getResultList();
	}
	
	public List<DepartmentDto> findAllDepartmentsJoinWithFunctionIntoSubQuery(LocalDate date, Integer integerValue) {
		return entityManager.createQuery(QueryConstants.QUERY_JOIN_FUNCTION_FROM_SUB_QUERY, DepartmentDto.class)
				.setParameter("date", date).setParameter("integerValue", integerValue).getResultList();
	}
	
	public List<DepartmentDto> findAllDepartmentsJoinLateralWithFunctionIntoSubQuery(LocalDate date, Integer integerValue) {
		return entityManager.createQuery(QueryConstants.QUERY_JOIN_LATERAL_FUNCTION_FROM_SUB_QUERY, DepartmentDto.class)
				.setParameter("date", date).setParameter("integerValue", integerValue).getResultList();
	}
	
	
	public List<DepartmentDto> findAllDepartmentsJoinFunctions(LocalDate date, Integer integerValue) {
		return entityManager.createQuery(QueryConstants.QUERY_SET_RETURN_FUNCTION_JOIN_WITH_FUNCTION, DepartmentDto.class)
				.setParameter("date", date).setParameter("integerValue", integerValue).getResultList();
	}
	
	
	
}
