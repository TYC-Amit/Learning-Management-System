package com.te.leraningmanagementsystem.mentormodulepageresponse;

import java.util.List;

import javax.persistence.Convert;

import com.te.leraningmanagementsystem.converter.StringListConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationResponse {

	private boolean error;
	
	@Convert(converter = StringListConverter.class)
	private List<String> message;
	
	private Object data;
}