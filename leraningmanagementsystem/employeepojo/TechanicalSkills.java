package com.te.leraningmanagementsystem.employeepojo;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.te.leraningmanagementsystem.converter.StringListConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TechanicalSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int techanicalSkillsId;
	
	@NotNull(message = "Skill Type Should Not Be Null")
	@NotEmpty(message = "Skill Type Is Mandatory")
	private String skillType;
	
	@NotNull(message = "Skill Rating Should Not Be Null")
	@NotEmpty(message = "Skill Rating Is Mandatory")
	private String skillRating;
	
	@Valid
	@Convert(converter = StringListConverter.class)
	private List<@NotNull(message = "Year Of Experience Should Not Be Null")
	@NotEmpty(message = "Year Of Experience Is Mandatory")String> yearOfExperience;
}
