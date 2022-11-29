package com.te.leraningmanagementsystem.mentorpojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BatchStrength {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int batchStrengthId;
	
	private int intialStrength;
	
	private int dropout;
	
	private int terminateds;
	
	private int absconding;
	
	private int presentStrength;
}
