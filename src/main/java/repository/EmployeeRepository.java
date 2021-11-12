package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
}
