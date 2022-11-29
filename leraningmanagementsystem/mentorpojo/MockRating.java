package com.te.leraningmanagementsystem.mentorpojo;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class MockRating {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mockId;

	private String mockType;

	private String mockTakenBy;

	private String parcticalKnowledgeMarksOutOff100;

	private String theoreticalKnowledgeMarksOutOff100;

	@Convert(converter = StringListConverter.class)
	private List<String> overallFeedback;

	@Convert(converter = StringListConverter.class)
	private List<String> detailedFeedback;

}
