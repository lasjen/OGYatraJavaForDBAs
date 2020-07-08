package no.eritec.demo.SpringJpaDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import no.eritec.demo.SpringJpaDemo.entity.Employee;
import no.eritec.demo.SpringJpaDemo.repository.EmployeeEMRepository;
import no.eritec.demo.SpringJpaDemo.repository.EmployeeRepository;

@SpringBootTest
class SpringJpaDemoApplicationTests {
	Logger log = LoggerFactory.getLogger(SpringJpaDemoApplicationTests.class);
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	EmployeeEMRepository empEmRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void EmployeeRepositoryTest1() throws SQLException {
		List<Employee> list = empRepo.findAll();
		for (Employee emp:list) {
			log.info("Employee:" + emp.getEname() + ", Department:" + emp.getDepartment().getDname());
		}
		assertEquals(3, list.size());
	}
	
	@Test
	void EmployeeRepositoryTest2() throws SQLException {
		Employee emp = empEmRepo.getEmployeeById(1);
		log.info("Employee:" + emp.getEname() + ", Department:" + emp.getDepartment().getDname());
		
		assertEquals("LARRY", emp.getEname());		
	}
	
	
}
