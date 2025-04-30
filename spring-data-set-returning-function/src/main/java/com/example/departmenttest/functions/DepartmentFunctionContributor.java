package com.example.departmenttest.functions;

import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.boot.model.FunctionContributor;
import org.hibernate.query.sqm.produce.function.SetReturningFunctionTypeResolver;
import org.hibernate.type.StandardBasicTypes;

public class DepartmentFunctionContributor implements FunctionContributor {

	@Override
	public void contributeFunctions(FunctionContributions contributions) {
		// Register first_word function
		   contributions.getFunctionRegistry()
           .namedSetReturningDescriptorBuilder("getDepartementFunction",
               "get_department_function",
               SetReturningFunctionTypeResolver.builder()
                   .invariant("id", StandardBasicTypes.LONG)
                   .invariant("name", StandardBasicTypes.STRING)
                   .build()
           )
           .setMinArgumentCount(1)
           .register();

	}
}