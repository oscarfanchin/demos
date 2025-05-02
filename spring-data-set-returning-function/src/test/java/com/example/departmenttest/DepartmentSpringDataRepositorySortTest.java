package com.example.departmenttest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

import com.example.departmenttest.dto.DepartmentDto;
import com.example.departmenttest.repository.DepartmentSpringDataSortRepository;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest
class DepartmentSpringDataRepositorySortTest {

	@Autowired
	private DepartmentSpringDataSortRepository departmentSpringDataSortedRepository;

	private final LocalDate today = LocalDate.now();
	private final int value = 1;

	

	@Test
	void testFindDepartementWithFunctionSorted() {
		
        Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("nameFunction"), Sort.Order.asc("idFunction"));
		
		List<DepartmentDto> departments = departmentSpringDataSortedRepository
				.findDepartementWithFunction(today, value, sortByNameFunctionAsc);
		assertNotNull(departments);
		assertFalse(departments.isEmpty());
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementWithFunctionNoAliasSorted() {
	    Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("nameFunction"), Sort.Order.asc("idFunction"));
		
		List<DepartmentDto> departments = departmentSpringDataSortedRepository
				.findDepartementWithFunctionNoAlias(today, value, sortByNameFunctionAsc);
		assertNotNull(departments);
		assertFalse(departments.isEmpty());
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}
//
	@Test
	void testFindDepartementWithJoinFunctionSorted() {
		
	    Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("x.nameFunction"), Sort.Order.asc("id"));

		
		List<DepartmentDto> departments = departmentSpringDataSortedRepository
				.findDepartementWithJoinFunction(today, value, sortByNameFunctionAsc);
		assertNotNull(departments);
		assertFalse(departments.isEmpty());
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementWithJoinFunctionNoAliasSorted() {
		
	    Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("id"));

		
		List<DepartmentDto> departments = departmentSpringDataSortedRepository
				.findDepartementWithJoinFunctionNoAlias(today, value, sortByNameFunctionAsc);
		assertNotNull(departments);
		assertFalse(departments.isEmpty());
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}
//
	@Test
	void testFindDepartementWithPrimaryJoinFunctionSorted() {
		
		 Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("d.name"), Sort.Order.asc("idFunction"));
		
		List<DepartmentDto> departments = departmentSpringDataSortedRepository
				.findDepartementWithPrimaryJoinFunction(today, value, sortByNameFunctionAsc);
		assertNotNull(departments);
		assertFalse(departments.isEmpty());
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}
//
	@Test
	void testFindDepartementByFunctionFromSubQuerySorted() {
		
		Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("nameFunction"), Sort.Order.asc("idFunction"));

		List<DepartmentDto> departments = departmentSpringDataSortedRepository
				.findDepartementByFunctionFromSubQuery(today, value, sortByNameFunctionAsc);
		assertNotNull(departments);
		assertFalse(departments.isEmpty());
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}
//
	@Test
	void testFindDepartementJoinFunctionIntoSubQuerySorted() {
		
		Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("d.nameFunction"), Sort.Order.asc("id")); 
		
		List<DepartmentDto> departments = departmentSpringDataSortedRepository
				.findDepartementJoinFunctionIntoSubQuery(today, value, sortByNameFunctionAsc);
		assertNotNull(departments);
		assertFalse(departments.isEmpty());
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}
//
	@Test
	void testFindDepartementJoinLateralFunctionIntoSubQuerySorted() {
		
		Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("d.nameFunction"), Sort.Order.asc("id"));
		
		List<DepartmentDto> departments = departmentSpringDataSortedRepository
				.findDepartementJoinLateralFunctionIntoSubQuery(today, value, sortByNameFunctionAsc);
		assertNotNull(departments);
		assertFalse(departments.isEmpty());
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}
//
	@Test
	void testFindDepartementJoinFunctionsSorted() {
		
		Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("nameFunction"),Sort.Order.asc("k.nameFunctionSP"), Sort.Order.asc("idFunction"));

		
		List<DepartmentDto> departments = departmentSpringDataSortedRepository
				.findDepartementJoinFunctions(today, value, sortByNameFunctionAsc);
		assertNotNull(departments);
		assertFalse(departments.isEmpty());
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}
}
