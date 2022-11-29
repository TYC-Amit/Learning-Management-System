package com.te.leraningmanagementsystem.dashboard;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.te.leraningmanagementsystem.response.Response;



@RestController
public class DashBoardController {

	@Autowired
	private DashBoardServices services;
	
	@GetMapping("/piChart/{batchId}")
	public ResponseEntity<Response> pichart(@PathVariable String batchId){
		Map<String, Long> chart= services.pichart(batchId);
		return new ResponseEntity<Response>(new Response(false, "Pi Chart", chart),HttpStatus.OK);
	}
	
	@GetMapping("/barGraph/{batchId}")
	public ResponseEntity<Response> barGraph(@PathVariable String batchId){
		Map<String, Long> chart= services.barGraph(batchId);
		return new ResponseEntity<Response>(new Response(false, "Pi Chart", chart),HttpStatus.OK);
	}
	
	@GetMapping("/barGraphforExperience/{batchId}")
	public ResponseEntity<Response> barGraphExperience(@PathVariable String batchId){
		Map<String, Long> chart= services.barGraphExperience(batchId);
		return new ResponseEntity<Response>(new Response(false, "Pi Chart", chart),HttpStatus.OK);
	}
	
	@GetMapping("/barGraphforDegree/{batchId}")
	public ResponseEntity<Response> barGraphDegree(@PathVariable String batchId){
		Map<String, Long> chart= services.barGraphDegree(batchId);
		return new ResponseEntity<Response>(new Response(false, "Pi Chart", chart),HttpStatus.OK);
	}
	
}