
package com.example.departmenttest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.departmenttest.dto.DepartmentDto;
import com.example.departmenttest.repository.DepartmentSpringDataPagedRepository;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest
class DepartmentSpringDataRepositoryPagedTest {

	@Autowired
	private DepartmentSpringDataPagedRepository brokenQueryRepository;
	
	@Test
	void testFindDepartementWithFunctionPaged() {
		Page<DepartmentDto> departments = brokenQueryRepository.findDepartementWithFunction(LocalDate.now(), 1, PageRequest.of(0, 2));
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementWithFunctionNoAliasPaged() {
		Page<DepartmentDto> departments = brokenQueryRepository.findDepartementWithFunctionNoAlias(LocalDate.now(), 1, PageRequest.of(0, 2));
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementWithFunctionJoinPaged() {
		Page<DepartmentDto> departments = brokenQueryRepository.findDepartementWithJoinFunction(LocalDate.now(), 1, PageRequest.of(0, 2));
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementWithFunctionJoinNoAliasPaged() {
		Page<DepartmentDto> departments = brokenQueryRepository.findDepartementWithJoinFunctionNoAlias(LocalDate.now(), 1, PageRequest.of(0, 2));
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementWithPrimaryJoinFunctionPaged() {
		Page<DepartmentDto> departments = brokenQueryRepository.findDepartementWithPrimaryJoinFunction(LocalDate.now(), 1, PageRequest.of(0, 2));
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementFunctionSubQueryPaged() {
		Page<DepartmentDto> departments = brokenQueryRepository.findDepartementByFunctionFromSubQuery(LocalDate.now(), 1, PageRequest.of(0, 2));
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementJoinFunctionIntoSubQueryPaged() {
		Page<DepartmentDto> departments = brokenQueryRepository.findDepartementJoinFunctionIntoSubQuery(LocalDate.now(), 1, PageRequest.of(0, 2));
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementJoinLateralFunctionIntoSubQueryPaged() {
		Page<DepartmentDto> departments = brokenQueryRepository.findDepartementJoinLateralFunctionIntoSubQuery(LocalDate.now(), 1, PageRequest.of(0, 2));
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

	@Test
	void testFindDepartementJoinTwoFunctionsPaged() {
		Page<DepartmentDto> departments = brokenQueryRepository.findDepartementJoinFunctions(LocalDate.now(), 1, PageRequest.of(0, 2));
		assertNotNull(departments);
		assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
		assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
		departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
	}

}
