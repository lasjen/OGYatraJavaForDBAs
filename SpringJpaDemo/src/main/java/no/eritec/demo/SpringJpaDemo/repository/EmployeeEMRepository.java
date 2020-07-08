package no.eritec.demo.SpringJpaDemo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import no.eritec.demo.SpringJpaDemo.entity.Employee;

@Repository
public class EmployeeEMRepository {
	@PersistenceContext
	EntityManager em;
	
	public Employee getEmployeeById(Integer empno) {
		Employee emp = (Employee) em.createQuery("select e from Employee e join fetch e.department where e.empno = :no", Employee.class)
				.setParameter("no", empno).getSingleResult();
		return emp;
	}
}
