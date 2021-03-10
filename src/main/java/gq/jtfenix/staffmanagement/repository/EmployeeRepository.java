package gq.jtfenix.staffmanagement.repository;

import gq.jtfenix.staffmanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByBatchCode(String codeId);
}
