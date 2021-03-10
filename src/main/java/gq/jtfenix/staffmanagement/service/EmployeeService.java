package gq.jtfenix.staffmanagement.service;

import gq.jtfenix.staffmanagement.exception.UserNotFoundException;
import gq.jtfenix.staffmanagement.model.Employee;
import gq.jtfenix.staffmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(final Long employeeId) {
        return employeeRepository
            .findById(employeeId)
            .orElseThrow(() -> new UserNotFoundException("Employee by ID " + employeeId + " was not found"));
    }

    public Employee findEmployeeByBatchCode(final String empBatchCode) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByBatchCode(empBatchCode);
        return employeeOptional.orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        employee.setBatchCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> addEmployeeList(List<Employee> employeeList) {
        if (!employeeList.isEmpty()) {
            employeeList.forEach(employee -> employee.setBatchCode(UUID.randomUUID().toString()));
        }
        return employeeRepository.saveAll(employeeList);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(final Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
