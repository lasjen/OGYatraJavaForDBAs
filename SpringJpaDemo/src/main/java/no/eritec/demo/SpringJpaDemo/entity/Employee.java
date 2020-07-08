package no.eritec.demo.SpringJpaDemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="emp")
@Getter
@Setter
public class Employee {
	@Id
	@SequenceGenerator(name = "empSeq", sequenceName = "emp_seq", initialValue = 1, allocationSize = 100)
	@GeneratedValue(generator = "empSeq")
	private Integer empno;
    private String ename;
    private String job;
    @Column(name="mgr")
    private Integer managerNo;
    private Date hiredate;
    @Column(name="sal")
    private Integer salary;
    @Column(nullable=true)
    private Integer comm;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deptno")
    private Department department;
    
    public Employee() {
		super();
	}

    // Getters & Setters
	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(Integer managerNo) {
		this.managerNo = managerNo;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getComm() {
		return comm;
	}

	public void setComm(Integer comm) {
		this.comm = comm;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
