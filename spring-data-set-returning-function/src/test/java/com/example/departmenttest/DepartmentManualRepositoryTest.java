
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
      List<DepartmentDto> departments = manualRepository.findAllDepartments(LocalDate.now(),1);
      assertNotNull(departments);
      assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
      departments.forEach(dept ->
          System.out.println(dept.getId() + " - " + dept.getName()));
    }
    
    @Test
    void testFindAllDepartmentsHibernateDirectNoAlias() {
      List<DepartmentDto> departments = manualRepository.findAllDepartmentsNoAlias(LocalDate.now(),1);
      assertNotNull(departments);
      assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
      departments.forEach(dept ->
          System.out.println(dept.getId() + " - " + dept.getName()));
    }
    
    @Test
    void testFindAllDepartmentsHibernateDirectJoinFunction() {
      List<DepartmentDto> departments = manualRepository.findAllDepartmentsJoinFunction(LocalDate.now(),1);
      assertNotNull(departments);
      assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
      departments.forEach(dept ->
          System.out.println(dept.getId() + " - " + dept.getName()));
    }
    
    @Test
    void testFindAllDepartmentsHibernateDirectJoinFunctionNoAlias() {
      List<DepartmentDto> departments = manualRepository.findAllDepartmentsJoinFunctionNoAlias(LocalDate.now(),1);
      assertNotNull(departments);
      assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
      departments.forEach(dept ->
          System.out.println(dept.getId() + " - " + dept.getName()));
    }
    
    
    @Test
    void testFindAllDepartmentsHibernateDirectPrimaryJoinFunction() {
      List<DepartmentDto> departments = manualRepository.findAllDepartmentsPrimaryJoinFunction(LocalDate.now(),1);
      assertNotNull(departments);
      assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
      departments.forEach(dept ->
          System.out.println(dept.getId() + " - " + dept.getName()));
    }
    
    @Test
    void testFindAllDepartmentsHibernateDirectFunctionFromSubQuery() {
      List<DepartmentDto> departments = manualRepository.findAllDepartmentsFromFunctionIntoSubQuery(LocalDate.now(),1);
      assertNotNull(departments);
      assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
      departments.forEach(dept ->
          System.out.println(dept.getId() + " - " + dept.getName()));
    }
    
    @Test
    void testFindAllDepartmentsHibernateDirectJoinFunctionIntoSubQuery() {
      List<DepartmentDto> departments = manualRepository.findAllDepartmentsJoinWithFunctionIntoSubQuery(LocalDate.now(),1);
      assertNotNull(departments);
      assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
      departments.forEach(dept ->
          System.out.println(dept.getId() + " - " + dept.getName()));
    }
    
    @Test
    void testFindAllDepartmentsHibernateDirectJoinLateralFunctionIntoSubQuery() {
      List<DepartmentDto> departments = manualRepository.findAllDepartmentsJoinLateralWithFunctionIntoSubQuery(LocalDate.now(),1);
      assertNotNull(departments);
      assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
      departments.forEach(dept ->
          System.out.println(dept.getId() + " - " + dept.getName()));
    }
    
    @Test
    void testFindAllDepartmentsHibernateDirectJoinTwoFunctions() {
      List<DepartmentDto> departments = manualRepository.findAllDepartmentsJoinFunctions(LocalDate.now(),1);
      assertNotNull(departments);
      assertFalse(departments.isEmpty(), "La lista dei dipartimenti non dovrebbe essere vuota");
      departments.forEach(dept ->
          System.out.println(dept.getId() + " - " + dept.getName()));
    }
}
