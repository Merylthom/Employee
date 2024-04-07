package com.employee.employeeManagement.controller;

import java.text.ParseException;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeeManagement.service.APIService;
import com.employee.employeeManagement.controller.DeleteMapping;
import com.employee.employeeManagement.controller.ExceptionHandler;
import com.employee.employeeManagement.controller.Page;
import com.employee.employeeManagement.controller.PathVariable;
import com.employee.employeeManagement.controller.PostMapping;
import com.employee.employeeManagement.controller.RequestBody;
import com.employee.employeeManagement.controller.ResponseEntity;
import com.employee.employeeManagement.model.EmployeeHistory;
import com.employee.employeeManagement.model.EmployeePage;
import com.employee.employeeManagement.model.EmployeeSearchCriteria;
import com.employee.employeeManagement.model.Employee;
import com.employee.employeeManagement.responses.GeneralResponse;
import com.employee.employeeManagement.responses.EmployeeResponse;
import com.employee.employeeManagement.responses.Status;
import com.employee.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class APIController {
	
	private final APIService APIService;

	APIController(APIService APIService) {
		this.APIService = APIService;
	}
	
	String empId = null;
	String firstName = null;
	String lastName = null;
	String email = null;
	String phoneNumber = null;
	Date doj ;
	int salary = 0;
	
	@GetMapping("/getEmployeeDetails")
	public ResponseEntity<T> getEmployeeDetails() {
		
	}
	@PostMapping("/createSalary")
	ResponseEntity<GeneralResponse> createEmployee(@RequestBody Employee newEmployee) throws ParseException {
		if (null == newEmployee || null == newEmployee.getEmployee() || ("").equals(newEmployee.getEmployee())
				|| null == newEmployee.getSalary() || 0 > newEmployee.getSalary()) {
			Status status = new Status(Status.EMPTY_REQUEST);
			GeneralResponse response = new GeneralResponse(status);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		Employee employee = employeeService.storeEmployeeSalary(newEmployee);

		if (null == employee) {
			Status status = new Status(Status.DATABASE_ERROR);
			GeneralResponse response = new GeneralResponse(status);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new EmployeeResponse(employee.getId(), employee.getEmployee(), employee.getSalary(), employee.getTime()));
	}

	@GetMapping("/getSalary/{id}")
	Employee getSalary(@PathVariable(required = true, name = "id") Long id) {
		return employeeService.findByID(id);
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<GeneralResponse> deleteEmployee(@PathVariable(required = true, name = "id") Long id) {
		Status status = new Status(Status.NO_PLAYER);
		GeneralResponse response = new GeneralResponse(status);
		Employee employee = employeeService.findByID(id);
		employeeService.deleteById(employee.getId());
		status = new Status(Status.OK);
		response = new GeneralResponse(status);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/getListOfSalary")
	ResponseEntity<Page<Employee>> getListOfSalary(EmployeePage employeesPage, EmployeeSearchCriteria employeeSearchCriteria) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.searchEmployeeDetails(employeesPage, employeeSearchCriteria));
	}

	@GetMapping("/getEmployeeHistory/{employee}")
	ResponseEntity<EmployeeHistory> getEmployeeHistory(@PathVariable(required = true, name = "employee") String employee) throws ParseException {
		return new ResponseEntity<EmployeeHistory>(employeeService.employeeHistoryDetails(employee), HttpStatus.OK);
	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
		return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
