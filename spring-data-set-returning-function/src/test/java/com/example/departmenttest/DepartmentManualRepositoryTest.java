
package com.example.departmenttest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.departmenttest.dto.DepartmentDto;
import com.example.departmenttest.repository.DepartmentManualRepository;
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest
class DepartmentManualRepositoryTest {

    @Autowired
    private DepartmentManualRepository manualRepository;

    @Test
    void testFindAllDepartmentsHibernateDirect() {
      List<DepartmentDto> departments = manualRepository.findAllDepartments(LocalDate.now());
      assertNotNull(departments);
      assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
      departments.forEach(dept ->
          System.out.println(dept.getId() + " - " + dept.getName()));
    }
}
