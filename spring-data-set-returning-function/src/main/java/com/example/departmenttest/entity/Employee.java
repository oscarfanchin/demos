package com.example.departmenttest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {

    @Id
    @Column(name = "id_employee")
    private Long idEmployee;
    
    @Column(name = "fk_department")

    private Long fkDepartment;

    public Long getFkDepartment() {
		return fkDepartment;
	}

	public void setFkDepartment(Long fkDepartment) {
		this.fkDepartment = fkDepartment;
	}

	public Long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String name) {
		this.nameEmployee = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "name_employee")
	private String nameEmployee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_department",insertable = false, updatable = false)
    private Department department;

    // Getters and setters
}