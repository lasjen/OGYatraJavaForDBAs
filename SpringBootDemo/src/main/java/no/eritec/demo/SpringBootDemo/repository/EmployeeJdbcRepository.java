package no.eritec.demo.SpringBootDemo.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import no.eritec.demo.SpringBootDemo.entity.Employee;

@Repository
public class EmployeeJdbcRepository {
	@Autowired
	DataSource datasource;

	public List<Employee> findAll() throws SQLException {
		Connection conn = datasource.getConnection();
		Statement stmt = null;
		String query = "select * from emp";
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt("empno")); 
				emp.setManagerNo(rs.getInt("mgr"));
				
				list.add(emp);
			}
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
		}
		
		return list;
	}

}
