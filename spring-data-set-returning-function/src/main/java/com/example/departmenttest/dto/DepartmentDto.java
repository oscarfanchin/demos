
package com.example.departmenttest.dto;

public class DepartmentDto {
    private final Long id;
    private final String name;

    public DepartmentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}
