package com.te.leraningmanagementsystem.mentormodulecontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.internal.Path;
import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;
import com.te.leraningmanagementsystem.mentordto.FinalBatchDto;
import com.te.leraningmanagementsystem.mentordto.TraineeDto;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;
import com.te.leraningmanagementsystem.mentormoduleservice.TraineeService;
import com.te.leraningmanagementsystem.mentorpojo.FinalBatch;
import com.te.leraningmanagementsystem.mentorpojo.Trainee;
import com.te.leraningmanagementsystem.response.Response;

@RestController
public class TraineeController {
	
	@Autowired
	private TraineeService traineeService;
	
	@PostMapping("/add-final-batch")
	public ResponseEntity<Response> addFinalBatch(@RequestBody FinalBatchDto finalBatchDto){
		FinalBatch addFinalBatch = traineeService.addFinalBatch(finalBatchDto);
		return new ResponseEntity<>(new Response(false, "Final Batch Added Succesfully", addFinalBatch),HttpStatus.OK);
	}
	
	@PostMapping("/add-trainee")
	public ResponseEntity<Response> addTrainee(@RequestBody TraineeDto traineeDto){
		Trainee addTrainee = traineeService.addTrainee(traineeDto);
		return new ResponseEntity<>(new Response(false, "Add Tarinee Succesfully", addTrainee),HttpStatus.OK);
	}

	@GetMapping("/find-trainee-id")
	public ResponseEntity<Response> findTraineeId(@RequestParam int traineeId){
		Trainee findTraineeId = traineeService.findTraineeId(traineeId);
		return new ResponseEntity<>(new Response(false, "Trainee Id Is Found", findTraineeId),HttpStatus.OK);
		
	}
	
	@PutMapping("/update-trainee/{traineeId}")
	public ResponseEntity<Response> updateTrainee(@PathVariable("traineeId")int traineeId,@RequestBody TraineeDto traineeDto){
		Trainee updateTrainee = traineeService.updateTrainee(traineeDto, traineeId);
		return new ResponseEntity<>(new Response(false, "Trainee Updated", updateTrainee),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-trainee")
	public ResponseEntity<Response> deleteTrainee(@RequestParam int traineeId){
		traineeService.deleteTrainee(traineeId);
		return new ResponseEntity<>(new Response(false, "Data Deleted Sucessfully", null),HttpStatus.OK);
	
	}
	
	@GetMapping("/find-all-batchId-in-trainee")
	public ResponseEntity<Response> findAllTrainee(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)int pageNumber,
			                                       @RequestParam(value = "pageSize",defaultValue = "2",required = false)int pageSize){
	   
		List<TraineeDto> trainee=traineeService.findAllTrainee(pageNumber, pageSize);
		return new ResponseEntity<>(new Response(false, "List Of BatchId In Mentor Module", trainee),HttpStatus.OK);	
	}
	
	@GetMapping("/getalltraineedeatils/{pageNumber}/{pageSize}/{name}")
	public ResponseEntity<Response> getAllTraineeDetails(@PathVariable int pageNumber, @PathVariable int pageSize,
			@PathVariable String name) {
		PageResponse allTraineeDetails = traineeService.getAllTraineeDetails(pageNumber, pageSize, name);
		return new ResponseEntity<>(new Response(false, "All Mentor Data", allTraineeDetails), HttpStatus.OK);
	}
	
	@GetMapping("/mockrating")
	public ResponseEntity<Response> getAllTraineDetails(){
		Map details = traineeService.getAllTraineeDetails();
		return new ResponseEntity<>(new Response(false, "Mock Rating", details),HttpStatus.OK);
		
	}
	
}
