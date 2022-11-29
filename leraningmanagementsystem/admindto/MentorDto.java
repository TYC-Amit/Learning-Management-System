package com.te.leraningmanagementsystem.admindto;

import java.util.List;

import com.te.leraningmanagementsystem.adminpojo.Batch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentorDto {
	
	private String mentorName;

	private String employeeId;

	private String mail;

	private List<String> skills;
	
	private List<Batch> batch;

}