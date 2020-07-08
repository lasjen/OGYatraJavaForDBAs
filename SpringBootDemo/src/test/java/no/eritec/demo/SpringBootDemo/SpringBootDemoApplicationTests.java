package no.eritec.demo.SpringBootDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import no.eritec.demo.SpringBootDemo.entity.Department;
import no.eritec.demo.SpringBootDemo.entity.Employee;
import no.eritec.demo.SpringBootDemo.repository.DepartmentRepository;
import no.eritec.demo.SpringBootDemo.repository.EmployeeJdbcRepository;

@SpringBootTest
class SpringBootDemoApplicationTests {
	Logger log = LoggerFactory.getLogger(SpringBootDemoApplicationTests.class);
	
	@Autowired
	EmployeeJdbcRepository empRepo;
	
	@Autowired
	DepartmentRepository deptRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void EmployeeJdbcRepositoryTest() throws SQLException {
		List<Employee> list = empRepo.findAll();
		assertEquals(3, list.size());
	}
	
	@Test
	void DepartmentRepositoryTest() throws SQLException {
		List<Department> list = deptRepo.findAll();
		
		assertEquals(3, list.size());
		
		deptRepo.save(new Department(40,"DUMMY","NOWHERE"));
		
		list = deptRepo.findAll();
		for (Department dept:list) {
			log.info("DEPARTMENT: " + dept.getDname());
		}
		assertEquals(4, list.size());
		
		deptRepo.deleteById(40);
		
		assertEquals(3, deptRepo.count());
	}

}
