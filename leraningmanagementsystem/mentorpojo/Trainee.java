package com.te.leraningmanagementsystem.mentorpojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.aspectj.lang.annotation.Before;
import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Trainee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int traineeId;

	private int employeeNo;

	private String employeeId;
	
	private String employeeName;

	@OneToOne(cascade = CascadeType.ALL)
	private AddMock addMock;

	@OneToOne(cascade = CascadeType.ALL)
	private MockRating mockRating;

	@OneToOne(cascade = CascadeType.ALL)
	private Attendence attendence;

	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	private BatchStrength batchStrength;

	private boolean deleted;
	
}


