package com.te.leraningmanagementsystem.admincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.leraningmanagementsystem.admindto.BatchDto;
import com.te.leraningmanagementsystem.adminpojo.Batch;
import com.te.leraningmanagementsystem.adminservice.BatchService;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;
import com.te.leraningmanagementsystem.response.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BatchController {

	@Autowired
	private  BatchService batchService;

//	@PreAuthorize("hasAnyRole('Admin')")
	@PostMapping("/create-batch")
	public ResponseEntity<Response> createBatch(@RequestBody BatchDto batchDto) {
		Batch create = batchService.create(batchDto);
		return new ResponseEntity<>(new Response(false, "Batch Created Sucessfully", create), HttpStatus.OK);
	}

	@GetMapping("/get-batch")
	public ResponseEntity<Response> getBatch(@RequestParam int id) {
		return new ResponseEntity<>(new Response(false, "Batch Details Based On Id", batchService.getBatch(id)),
				HttpStatus.OK);
	}

	@DeleteMapping("/delete-batch")
	public ResponseEntity<Response> deleteBatch(@RequestParam int id) {
		batchService.deleteBatch(id);
		return new ResponseEntity<>(new Response(false, "Batch Deleted Sucessfully", batchService), HttpStatus.OK);
	}

	@PutMapping("/update-batch/{id}")
	public ResponseEntity<Response> updateBatch(@PathVariable int id, @RequestBody BatchDto batchDto) {
		Batch updateBatch = batchService.updateBatch(id, batchDto);
		return new ResponseEntity<>(new Response(false, "Batch Updated Sucessfully", updateBatch), HttpStatus.OK);
	}

	@GetMapping("/find-all-batch")
	public ResponseEntity<Response> findAllBatch(){
		List<Batch> findAllBatch = batchService.findAllBatch();
		return new ResponseEntity<>(new Response(false, "List Of Batch IS There", findAllBatch),HttpStatus.OK);
		
	}
	
	@GetMapping("/getallbatchdeatils/{pageNumber}/{pageSize}/{batchName}")
	public ResponseEntity<Response> getAllBatchDetails(@PathVariable int pageNumber, @PathVariable int pageSize,
			@PathVariable String batchName) {
		PageResponse allBatchDetails = batchService.getAllBatchDetails(pageNumber, pageSize, batchName);
		return new ResponseEntity<>(new Response(false, "All Mentor Data", allBatchDetails), HttpStatus.OK);
	}
}