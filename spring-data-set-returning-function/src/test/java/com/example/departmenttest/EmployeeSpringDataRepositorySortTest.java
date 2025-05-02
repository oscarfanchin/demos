package com.example.departmenttest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

import com.example.departmenttest.dto.EmployeeDto;
import com.example.departmenttest.repository.EmployeeSpringDataSortRepository;
@Disabled("TODO:Esempio")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest
class EmployeeSpringDataRepositorySortTest {

	@Autowired
	private EmployeeSpringDataSortRepository employementSpringDataSortedRepository;
	

	@Test
	void testFindDepartementWithFunctionSorted() {
		
        Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("nameEmployee"));//, Sort.Order.asc("name"));
		
		List<EmployeeDto> departments = employementSpringDataSortedRepository
				.findTestStandardQuery(sortByNameFunctionAsc);
		assertNotNull(departments);
		assertFalse(departments.isEmpty());
		departments.forEach(dept -> System.out.println(dept.getIdEmployee() + " - " +dept.getNameEmployee()+ " - " + dept.getNameDepartement()));
	}
 

//	@Test
//	void testFindDepartementWithJoinFunctionNoAliasSorted() {
//		
//	    Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("nameFunction"), Sort.Order.asc("id"));
//
//		
//		List<DepartmentDto> departments = departmentSpringDataSortedRepository
//				.findDepartementWithJoinFunctionNoAlias(today, value, sortByNameFunctionAsc);
//		assertNotNull(departments);
//		assertFalse(departments.isEmpty());
//		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
//	}
//
//	@Test
//	void testFindDepartementWithPrimaryJoinFunctionSorted() {
//		List<DepartmentDto> departments = departmentSpringDataSortedRepository
//				.findDepartementWithPrimaryJoinFunction(today, value, sortByNameAsc);
//		assertNotNull(departments);
//		assertFalse(departments.isEmpty());
//		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
//	}
//
//	@Test
//	void testFindDepartementByFunctionFromSubQuerySorted() {
//		List<DepartmentDto> departments = departmentSpringDataSortedRepository
//				.findDepartementByFunctionFromSubQuery(today, value, sortByNameAsc);
//		assertNotNull(departments);
//		assertFalse(departments.isEmpty());
//		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
//	}
//
//	@Test
//	void testFindDepartementJoinFunctionIntoSubQuerySorted() {
//		List<DepartmentDto> departments = departmentSpringDataSortedRepository
//				.findDepartementJoinFunctionIntoSubQuery(today, value, sortByNameAsc);
//		assertNotNull(departments);
//		assertFalse(departments.isEmpty());
//		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
//	}
//
//	@Test
//	void testFindDepartementJoinLateralFunctionIntoSubQuerySorted() {
//		List<DepartmentDto> departments = departmentSpringDataSortedRepository
//				.findDepartementJoinLateralFunctionIntoSubQuery(today, value, sortByNameAsc);
//		assertNotNull(departments);
//		assertFalse(departments.isEmpty());
//		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
//	}
//
//	@Test
//	void testFindDepartementJoinFunctionsSorted() {
//		List<DepartmentDto> departments = departmentSpringDataSortedRepository
//				.findDepartementJoinFunctions(today, value, sortByNameAsc);
//		assertNotNull(departments);
//		assertFalse(departments.isEmpty());
//		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
//	}
}
