package com.te.leraningmanagementsystem.employeecontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.leraningmanagementsystem.employeedto.EmployeePrimaryInfoDto;
import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;
import com.te.leraningmanagementsystem.employeeservice.EmployeeService;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;
import com.te.leraningmanagementsystem.response.Response;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeinterface;
	
	@PostMapping("add-All-Deatils-Emp")
	public ResponseEntity<Response> addAllDeatilsEmp(@Valid @RequestBody EmployeePrimaryInfoDto employeedto){
		EmployeePrimaryInfo addAllDeatilsEmp = employeeinterface.addAllDeatilsEmp(employeedto);
		return new ResponseEntity<>(new Response(false, "Add All The Primary Info OF Employee", addAllDeatilsEmp),HttpStatus.OK);
		
	}
	
	@GetMapping("find-By-EmployeeId")
	public ResponseEntity<Response> findByEmployeeId(@RequestParam String employeeId){
		Optional<EmployeePrimaryInfo> findByEmployeeId = employeeinterface.findByEmployeeId(employeeId);
		return new ResponseEntity<>(new Response(false, "Employee Find By Employee Id", findByEmployeeId),HttpStatus.OK);
		
	}
	
	@PutMapping("update-Employee-Info/{employeeId}")
	public ResponseEntity<Response> updateEmployeeInfo(@PathVariable("employeeId")String employeeId,@RequestBody EmployeePrimaryInfoDto employeedto){
		EmployeePrimaryInfo updateEmployeeInfo = employeeinterface.updateEmployeeInfo(employeeId, employeedto);
		return new ResponseEntity<>(new Response(false, "Employee Primary Deatils Updated", updateEmployeeInfo),HttpStatus.OK);
		
	}
	
	@GetMapping("/find-all-employee-primary-info")
	public ResponseEntity<Response> findAllEmployeePrimaryInfo(){
		List<EmployeePrimaryInfo> findAllEmployeePrimaryInfo = employeeinterface.findAllEmployeePrimaryInfo();
		return new ResponseEntity<>(new Response(false, "List Of Employee Primary Info Is There", findAllEmployeePrimaryInfo),HttpStatus.OK);
	}
	
	@GetMapping("/getallemployeedeatils/{pageNumber}/{pageSize}/{employeeName}")
	public ResponseEntity<Response> getAllEmployeeDetails(@PathVariable int pageNumber, @PathVariable int pageSize,
			@PathVariable String employeeName) {
		PageResponse allEmployeeDetails = employeeinterface.getAllEmployeeDetails(pageNumber, pageSize, employeeName);
		return new ResponseEntity<>(new Response(false, "All Employee Data", allEmployeeDetails), HttpStatus.OK);
	}
}
