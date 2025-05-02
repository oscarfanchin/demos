package com.example.departmenttest;

public class QueryConstants {
	
	private QueryConstants() {}

	public static final String QUERY_SET_RETURN_FUNCTION = """

			select new com.example.departmenttest.dto.DepartmentDto(d.idFunction, d.nameFunction)
			from getDepartementFunction(:date,:integerValue) d
			""";
	
	public static final String QUERY_SET_RETURN_FUNCTION_FIXED_PARAM = """

			select new com.example.departmenttest.dto.DepartmentDto(d.idFunction, d.nameFunction)
			from getDepartementFunction(CURRENT_DATE,1) d
			""";


	public static final String QUERY_SET_RETURN_FUNCTION_NO_ALIAS = """
			select new com.example.departmenttest.dto.DepartmentDto(idFunction, nameFunction) from getDepartementFunction(:date,:integerValue)
			""";

	public static final String QUERY_JOIN_FUNCTION = """
			select new com.example.departmenttest.dto.DepartmentDto(d.id, x.nameFunction)
			from Department d join getDepartementFunction(:date,:integerValue) x on (d.id = x.idFunction)
			""";

	public static final String QUERY_JOIN_FUNCTION_NO_ALIAS = """
			select new com.example.departmenttest.dto.DepartmentDto(d.id, nameFunction)
			from Department d join getDepartementFunction(:date,:integerValue) on (d.id = idFunction)
			""";

	public static final String QUERY_PRIMARY_JOIN_FUNCTION = """
			select new com.example.departmenttest.dto.DepartmentDto(x.idFunction, d.name)
			from getDepartementFunction(:date,:integerValue) x inner join Department d on (d.id = x.idFunction)
			""";

	public static final String QUERY_FUNCTION_FROM_SUB_QUERY = """
			   select new com.example.departmenttest.dto.DepartmentDto(d.idFunction, d.nameFunction)
			   from(

			   select x.idFunction idFunction , x.nameFunction nameFunction from getDepartementFunction(:date,:integerValue) x

			   ) d
			""";

	public static final String QUERY_JOIN_FUNCTION_FROM_SUB_QUERY = """
			   select new com.example.departmenttest.dto.DepartmentDto(k.id, d.nameFunction)
			   from Department k inner join (

			   select x.idFunction idFunction , x.nameFunction nameFunction from getDepartementFunction(:date,:integerValue) x

			   ) d on (k.id = d.idFunction)
			""";

	public static final String QUERY_JOIN_LATERAL_FUNCTION_FROM_SUB_QUERY = """
			   select new com.example.departmenttest.dto.DepartmentDto(k.id, d.nameFunction)
			   from Department k join lateral (

			   select x.idFunction idFunction , x.nameFunction nameFunction from getDepartementFunction(:date, :integerValue) x
			   where x.idFunction = k.id
			   ) d
			""";

	public static final String QUERY_SET_RETURN_FUNCTION_JOIN_WITH_FUNCTION = """

			select new com.example.departmenttest.dto.DepartmentDto(d.idFunction, d.nameFunction)
			from getDepartementFunction(:date,:integerValue) d inner join getDepartmentFunctionSingleParam(:date) k
			on (d.idFunction = k.idFunctionSP)
			""";
	
	
	
	public static final String TEST_STANDARD_QUERY = """

			select new com.example.departmenttest.dto.EmployeeDto(e.idEmployee, e.nameEmployee, name)
			from Employee e join lateral (
				select d.name name from Department d
				where d.id = e.fkDepartment
			)
			""";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
