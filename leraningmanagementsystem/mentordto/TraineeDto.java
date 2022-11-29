package com.te.leraningmanagementsystem.mentordto;

import com.te.leraningmanagementsystem.mentorpojo.AddMock;
import com.te.leraningmanagementsystem.mentorpojo.Attendence;
import com.te.leraningmanagementsystem.mentorpojo.BatchStrength;
import com.te.leraningmanagementsystem.mentorpojo.MockRating;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraineeDto {

	private int employeeNo;

	private String employeeId;

	private String employeeName;

	private AddMock addMock;

	private MockRating mockRating;

	private Attendence attendence;

	private String status;

	private BatchStrength batchStrength;

}
