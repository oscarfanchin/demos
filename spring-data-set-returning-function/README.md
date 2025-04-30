# Spring Data JPA add support to Set-returning Functions in `from` Clause

### Context

This [test suite](https://github.com/oscarfanchin/demos/tree/main/spring-data-set-returning-function)  test suite demonstrates the current behavior of Spring Data JPA when handling SQL set-returning functions (SRF) in the `FROM` clause, as described in the [Hibernate ORM documentation](https://docs.jboss.org/hibernate/orm/7.0/userguide/html_single/Hibernate_User_Guide.html#hql-from-set-returning-functions). While such queries work correctly when executed directly via Hibernate (e.g., through `EntityManager`) or declared with `@NativeQuery`, they currently cause a `BeanCreationException` when used in a Spring Data JPA repository method.

This does not necessarily indicate a limitation, but rather that support for this pattern may not yet have been considered or integrated into the Spring Data JPA query parser. This document can serve as a reference for evaluating the possibility of supporting this usage in future versions.

## Spring Boot Versions

We test the same codebase using different POM files to control the Spring Boot version:

- **Spring Boot 3.4.5**: default execution (no `-f` parameter).
- **Spring Boot 3.5.0-RC1**: executed with `-f pom350RC1.xml`.
- **Spring Boot 4.0.0-SNAPSHOT**: executed with `-f pom400SNAP.xml`.

## Hibernate

All examples use Hibernate 7.0.0.CR1 and JPA 3.2.

## Function Mapping

The PostgreSQL set-returning function is mapped using a custom `FunctionContributor`, allowing us to call:

```sql
select d.id, d.name from get_department_function(:date) d
```

The mapped function returns a result set that can be queried via JPQL.

---

## Repository Tests

### 1. `DepartmentSpringDataRepositorySimpleTest`

```java
@Test
void testFindAllDepartments() {
    List<Department> departments = springDataRepository.findAll();
    ...
}
```

- A basic `findAll()` test using Spring Data JPA.

```java
@Test
void testFindDepartementsNativeFunctionCall() {
    List<DepartmentInterfaceProjection> departments = springDataRepository.findAllDepartments(LocalDate.now());
    ...
}
```

- A native query test using `@NativeQuery`, introduced in Spring Data 3.2.

```java
@NativeQuery(value = "select d.id, d.name from get_department_function(:date) d")
List<DepartmentInterfaceProjection> findAllDepartments(@Param("date") LocalDate date);
```

---

### 2. `DepartmentManualRepositoryTest`

```java
@Test
void testFindAllDepartmentsHibernateDirect() {
    List<DepartmentDto> departments = manualRepository.findAllDepartments(LocalDate.now());
    ...
}
```

- Executes the same set-returning function query using Hibernate directly via `EntityManager`.

```java
@Repository
public class DepartmentManualRepository {
    ...
    public List<DepartmentDto> findAllDepartments(LocalDate date) {
        return entityManager.createQuery(
            QueryConstants.QUERY_SET_RETURN_FUNCTION,
            DepartmentDto.class
        ).setParameter("date", date).getResultList();
    }
}
```

---

### 3. `DepartmentSpringDataRepositoryTest`

```java
@Test
void testThatContextFailsToStartDueToInvalidQuery() {
    assertThrows(BeanCreationException.class, () -> {
        new SpringApplicationBuilder(DepartmentTestApplication.class)
            .properties("test.broken-query.enabled=true").run();
    });
}
```

- This test demonstrates that Spring Data's parser currently fails to parse a query using a set-returning function in the `from` clause.
- The same query works perfectly via `EntityManager`.

---

## Query Constants

```java
public class QueryConstants {
    public static final String QUERY_SET_RETURN_FUNCTION = 
        "select new com.example.departmenttest.dto.DepartmentDto(d.id, d.name) " +
        "from getDepartementFunction(:date) d";
}
```

---

## Summary

- ✅ **Spring Data @NativeQuery** supports set-returning functions with direct native SQL.
- ✅ **Hibernate with EntityManager** fully supports `from get_department_function(:date)`.
- ❌ **Spring Data JPQL parsing** currently does not support this feature (BeanCreationException).

See also: [Hibernate 7 User Guide - Set-returning functions](https://docs.jboss.org/hibernate/orm/7.0/userguide/html_single/Hibernate_User_Guide.html#hql-from-set-returning-functions)