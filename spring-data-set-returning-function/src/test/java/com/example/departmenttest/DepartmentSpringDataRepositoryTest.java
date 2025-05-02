
package com.example.departmenttest;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.departmenttest.dto.DepartmentDto;
import com.example.departmenttest.repository.DepartmentSpringDataPagedRepository;
import com.example.departmenttest.repository.DepartmentSpringDataRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest
class DepartmentSpringDataRepositoryTest {

	@Autowired
	private DepartmentSpringDataRepository departmentSpringDataRepository;

	@Test
	void testFindDepartementWithFunctionFixedParam() {
		List<DepartmentDto> departments = departmentSpringDataRepository.findDepartementWithFunctionFixedParam();
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}
	
	
	@Test
	void testFindDepartementWithFunction() {
		List<DepartmentDto> departments = departmentSpringDataRepository.findDepartementWithFunction(LocalDate.now(), 1);
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementWithFunctionNoAlias() {
		List<DepartmentDto> departments = departmentSpringDataRepository.findDepartementWithFunctionNoAlias(LocalDate.now(), 1);
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementWithFunctionJoin() {
		List<DepartmentDto> departments = departmentSpringDataRepository.findDepartementWithJoinFunction(LocalDate.now(), 1);
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementWithFunctionJoinNoAlias() {
		List<DepartmentDto> departments = departmentSpringDataRepository.findDepartementWithJoinFunctionNoAlias(LocalDate.now(),
				1);
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementWithPrimaryJoinFunction() {
		List<DepartmentDto> departments = departmentSpringDataRepository.findDepartementWithPrimaryJoinFunction(LocalDate.now(),
				1);
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementFunctionSubQuery() {
		List<DepartmentDto> departments = departmentSpringDataRepository.findDepartementByFunctionFromSubQuery(LocalDate.now(),
				1);
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementJoinFunctionIntoSubQuery() {
		List<DepartmentDto> departments = departmentSpringDataRepository.findDepartementJoinFunctionIntoSubQuery(LocalDate.now(),
				1);
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}



	@Test
	void testFindDepartementJoinLateralFunctionIntoSubQuery() {
		List<DepartmentDto> departments = departmentSpringDataRepository.findDepartementJoinLateralFunctionIntoSubQuery(LocalDate.now(),
				1);
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}
	
	@Test
	void testFindDepartementJoinTwoFunctions() {
		List<DepartmentDto> departments = departmentSpringDataRepository.findDepartementJoinFunctions(LocalDate.now(),
				1);
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}
}
