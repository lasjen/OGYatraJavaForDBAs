package no.eritec.demo.SpringJpaDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import no.eritec.demo.SpringJpaDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
