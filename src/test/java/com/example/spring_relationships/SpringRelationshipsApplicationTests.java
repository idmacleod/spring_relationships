package com.example.spring_relationships;

import com.example.spring_relationships.models.Department;
import com.example.spring_relationships.models.Employee;
import com.example.spring_relationships.models.Project;
import com.example.spring_relationships.repositories.DepartmentRepository;
import com.example.spring_relationships.repositories.EmployeeRepository;
import com.example.spring_relationships.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringRelationshipsApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateEmployeeAndDepartment() {
		Department development = new Department("Development");
		departmentRepository.save(development);

		Employee cameron = new Employee("Cameron", "Tait", 123, development);
		employeeRepository.save(cameron);

		Project codeclan = new Project("CodeClan", 5);
		codeclan.addEmployee(cameron);
		projectRepository.save(codeclan);
	}

}
