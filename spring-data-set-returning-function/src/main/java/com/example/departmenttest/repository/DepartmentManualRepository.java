
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

    public List<DepartmentDto> findAllDepartments(LocalDate date) {
        return entityManager.createQuery(
            QueryConstants.QUERY_SET_RETURN_FUNCTION,
            DepartmentDto.class
        ).setParameter("date", date).getResultList();
    }
}
