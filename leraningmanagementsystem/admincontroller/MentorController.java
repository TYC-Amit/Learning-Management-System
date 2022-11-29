package com.te.leraningmanagementsystem.admincontroller;

import java.util.List;

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

import com.te.leraningmanagementsystem.admindto.BatchDto;
import com.te.leraningmanagementsystem.admindto.MentorDto;
import com.te.leraningmanagementsystem.adminpojo.Batch;
import com.te.leraningmanagementsystem.adminpojo.Mentor;
import com.te.leraningmanagementsystem.adminservice.MentorService;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;
import com.te.leraningmanagementsystem.response.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MentorController {

	private final MentorService service;

	@PostMapping("/create-mentor")
	public ResponseEntity<Response> createMentor(@RequestBody MentorDto dto) {
		Mentor create = service.create(dto);
		return new ResponseEntity<>(new Response(false, "Mentor Added Sucessfully In Batch", create), HttpStatus.OK);
	}

	@GetMapping("/find-mentor")
	public ResponseEntity<Response> findMentor(@RequestParam int mentorId) {
		Mentor findMentor = service.findMentor(mentorId);
		return new ResponseEntity<>(new Response(false, "Mentor Found Based On MentorId", findMentor), HttpStatus.OK);
	}

	@DeleteMapping("/delete-mentor")
	public ResponseEntity<Response> delete(@RequestParam int mentorId) {
		service.delete(mentorId);
		return new ResponseEntity<>(new Response(false, "Mentor Deleted Sucessfully Form Batch", service), HttpStatus.OK);
	}

	@PutMapping("/update-mentor/{mentorId}")
	public ResponseEntity<Response> updateMentor(@PathVariable int mentorId, @RequestBody MentorDto dto) {
		Mentor update = service.update(mentorId, dto);
		return new ResponseEntity<>(new Response(false, "Mentor Updated Sucessfully", update), HttpStatus.OK);
	}
	
	@GetMapping("/find-all-mentor")
	public ResponseEntity<Response> findAllMentor(){
		List<Mentor> findAllMentor = service.findAllMentor();
		return new ResponseEntity<>(new Response(false, "List Of Mentor Is There", findAllMentor),HttpStatus.OK);
		
	}
	
	@GetMapping("/getallmentordeatils/{pageNumber}/{pageSize}/{mentorName}")
	public ResponseEntity<Response> getAllMentorDetails(@PathVariable int pageNumber, @PathVariable int pageSize,
			@PathVariable String mentorName) {
		PageResponse allBatchDetails = service.getAllMentorDetails(pageNumber, pageSize, mentorName);
		return new ResponseEntity<>(new Response(false, "All Mentor Data", allBatchDetails), HttpStatus.OK);
	}
}