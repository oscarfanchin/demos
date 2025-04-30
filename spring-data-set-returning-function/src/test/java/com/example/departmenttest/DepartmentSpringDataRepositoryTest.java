
package com.example.departmenttest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest
class DepartmentSpringDataRepositoryTest {

	@Test
	void testThatContextFailsToStartDueToInvalidQuery() {

		assertThrows(BeanCreationException.class, () -> {
			new SpringApplicationBuilder(DepartmentTestApplication.class).properties("test.broken-query.enabled=true")
					.run();
		});
	}
}
