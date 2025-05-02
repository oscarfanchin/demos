package com.example.departmenttest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

import com.example.departmenttest.dto.DepartmentDto;
import com.example.departmenttest.repository.DepartmentSpringDataPagedRepository;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest
class DepartmentSpringDataRepositoryPageAndSortTest {

    @Autowired
    private DepartmentSpringDataPagedRepository departmentSpringDataSortedRepository;

    private final LocalDate today = LocalDate.now();
    private final int value = 1;

    @Test
    void testFindDepartementWithFunctionSorted() {
        Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("nameFunction"), Sort.Order.asc("idFunction"));
        Pageable pageable = PageRequest.of(0, 2, sortByNameFunctionAsc);

        Page<DepartmentDto> departments = departmentSpringDataSortedRepository
                .findDepartementWithFunction(today, value, pageable);
        assertNotNull(departments);
        assertFalse(departments.isEmpty());
    	assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
        departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
    }

    @Test
    void testFindDepartementWithFunctionNoAliasSorted() {
        Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("nameFunction"), Sort.Order.asc("idFunction"));
        Pageable pageable = PageRequest.of(0, 2, sortByNameFunctionAsc);

        Page<DepartmentDto> departments = departmentSpringDataSortedRepository
                .findDepartementWithFunctionNoAlias(today, value, pageable);
        assertNotNull(departments);
        assertFalse(departments.isEmpty());
    	assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
        departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
    }

    @Test
    void testFindDepartementWithJoinFunctionSorted() {
        Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("x.nameFunction"), Sort.Order.asc("id"));
        Pageable pageable = PageRequest.of(0, 2, sortByNameFunctionAsc);

        Page<DepartmentDto> departments = departmentSpringDataSortedRepository
                .findDepartementWithJoinFunction(today, value, pageable);
        assertNotNull(departments);
        assertFalse(departments.isEmpty());
    	assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
        departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
    }

    @Test
    void testFindDepartementWithJoinFunctionNoAliasSorted() {
        Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("id"));
        Pageable pageable = PageRequest.of(0, 2, sortByNameFunctionAsc);

        Page<DepartmentDto> departments = departmentSpringDataSortedRepository
                .findDepartementWithJoinFunctionNoAlias(today, value, pageable);
        assertNotNull(departments);
        assertFalse(departments.isEmpty());
    	assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
        departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
    }

    @Test
    void testFindDepartementWithPrimaryJoinFunctionSorted() {
        Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("d.name"), Sort.Order.asc("idFunction"));
        Pageable pageable = PageRequest.of(0, 2, sortByNameFunctionAsc);

        Page<DepartmentDto> departments = departmentSpringDataSortedRepository
                .findDepartementWithPrimaryJoinFunction(today, value, pageable);
        assertNotNull(departments);
        assertFalse(departments.isEmpty());
    	assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
        departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
    }

    @Test
    void testFindDepartementByFunctionFromSubQuerySorted() {
        Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("nameFunction"), Sort.Order.asc("idFunction"));
        Pageable pageable = PageRequest.of(0, 2, sortByNameFunctionAsc);

        Page<DepartmentDto> departments = departmentSpringDataSortedRepository
                .findDepartementByFunctionFromSubQuery(today, value, pageable);
        assertNotNull(departments);
        assertFalse(departments.isEmpty());
    	assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
        departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
    }

    @Test
    void testFindDepartementJoinFunctionIntoSubQuerySorted() {
        Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("d.nameFunction"), Sort.Order.asc("id"));
        Pageable pageable = PageRequest.of(0, 2, sortByNameFunctionAsc);

        Page<DepartmentDto> departments = departmentSpringDataSortedRepository
                .findDepartementJoinFunctionIntoSubQuery(today, value, pageable);
        assertNotNull(departments);
        assertFalse(departments.isEmpty());
    	assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
        departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
    }

    @Test
    void testFindDepartementJoinLateralFunctionIntoSubQuerySorted() {
        Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("d.nameFunction"), Sort.Order.asc("id"));
        Pageable pageable = PageRequest.of(0, 2, sortByNameFunctionAsc);

        Page<DepartmentDto> departments = departmentSpringDataSortedRepository
                .findDepartementJoinLateralFunctionIntoSubQuery(today, value, pageable);
        assertNotNull(departments);
        assertFalse(departments.isEmpty());
    	assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
        departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
    }

    @Test
    void testFindDepartementJoinFunctionsSorted() {
        Sort sortByNameFunctionAsc = Sort.by(Sort.Order.asc("nameFunction"), Sort.Order.asc("k.nameFunctionSP"), Sort.Order.asc("idFunction"));
        Pageable pageable = PageRequest.of(0, 2, sortByNameFunctionAsc);

        Page<DepartmentDto> departments = departmentSpringDataSortedRepository
                .findDepartementJoinFunctions(today, value, pageable);
        assertNotNull(departments);
        assertFalse(departments.isEmpty());
    	assertEquals(2, departments.getContent().size(), "La pagina dovrebbe contenere esattamente 2 elementi");
        departments.forEach(dept -> System.out.println(dept.getId() + " - " + dept.getName()));
    }
}
