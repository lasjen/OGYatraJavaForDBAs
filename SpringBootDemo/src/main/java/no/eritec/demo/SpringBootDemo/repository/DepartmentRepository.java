package no.eritec.demo.SpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import no.eritec.demo.SpringBootDemo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>  {

}
