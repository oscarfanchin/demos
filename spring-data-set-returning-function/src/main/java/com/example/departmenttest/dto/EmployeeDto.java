
package com.example.departmenttest.dto;

public class EmployeeDto {
    private final Long idEmployee;
    private final String nameEmployee;
    private final String nameDepartement;

    public String getNameDepartement() {
		return nameDepartement;
	}
	public EmployeeDto(Long id, String name,String nameDepartement) {
        this.idEmployee = id;
        this.nameEmployee = name;
        this.nameDepartement = nameDepartement;
    }
    public Long getIdEmployee() { return idEmployee; }
    public String getNameEmployee() { return nameEmployee; }
}
