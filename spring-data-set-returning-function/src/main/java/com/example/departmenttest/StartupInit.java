package com.example.departmenttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class StartupInit {

	@PostConstruct
	public void createAliasForH2() throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:deptdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL", "sa",
				""); Statement stmt = conn.createStatement()) {

			stmt.execute("CREATE ALIAS IF NOT EXISTS get_department_function FOR \""
					+ "com.example.departmenttest.StartupInit.getDepartmentFunction\"");
			
			
			stmt.execute("CREATE ALIAS IF NOT EXISTS get_department_function_single_param FOR \""
					+ "com.example.departmenttest.StartupInit.getDepartmentFunctionSingleParam\"");
		}
	}

	// La funzione vera e propria
	public static ResultSet getDepartmentFunction(LocalDate inputDate,Long inputInteger) throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:h2:mem:deptdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL", "sa", "");
		PreparedStatement ps = conn.prepareStatement("SELECT id as idFunction, name as nameFunction FROM department");

		return ps.executeQuery();

	}
	
	public static ResultSet getDepartmentFunctionSingleParam(LocalDate inputDate) throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:h2:mem:deptdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL", "sa", "");
		PreparedStatement ps = conn.prepareStatement("SELECT id as idFunctionSP, name as nameFunctionSP FROM department");

		return ps.executeQuery();

	}
}