package com.te.leraningmanagementsystem.mentormoduleservice;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;

import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;
import com.te.leraningmanagementsystem.mentordto.FinalBatchDto;
import com.te.leraningmanagementsystem.mentordto.TraineeDto;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;
import com.te.leraningmanagementsystem.mentorpojo.FinalBatch;
import com.te.leraningmanagementsystem.mentorpojo.Trainee;

public interface TraineeService {
	
	public FinalBatch addFinalBatch(FinalBatchDto finalBatchDto);

	public Trainee addTrainee(TraineeDto traineeDto);

	public Trainee findTraineeId(int traineeId);
	
	public Trainee updateTrainee(TraineeDto traineeDto,int traineeId);
	
	public void deleteTrainee(int traineeId);
	
	public List<TraineeDto> findAllTrainee(int pageNumber,int pageSize);

	public PageResponse getAllTraineeDetails(int pageNumber, int pageSize, String str);
	
	
	public Map getAllTraineeDetails();

}
