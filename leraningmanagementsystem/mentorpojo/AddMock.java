package com.te.leraningmanagementsystem.mentorpojo;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class AddMock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mockId;

	private String batchId;
	
	private String mockNo;
	
	@Convert(converter = StringListConverter.class)
	private List<String> technologies;
	
	@Convert(converter = StringListConverter.class)
	private List<String> panel;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	private LocalDateTime localDateTime;
}
