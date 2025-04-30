
package com.example.departmenttest.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;

import com.example.departmenttest.dto.DepartmentInterfaceProjection;
import com.example.departmenttest.entity.Department;

public interface DepartmentSpringDataRepository extends JpaRepository<Department, Long> {

	@NativeQuery(value = "select d.id, d.name from get_department_function(:date) d")
	List<DepartmentInterfaceProjection> findAllDepartments(@Param("date") LocalDate date);

}
