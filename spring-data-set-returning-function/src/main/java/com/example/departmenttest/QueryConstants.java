package com.example.departmenttest;

public class QueryConstants {

	public static final String QUERY_SET_RETURN_FUNCTION = "select new com.example.departmenttest.dto.DepartmentDto(d.id, d.name) from getDepartementFunction(:date) d";

}
