package com.te.leraningmanagementsystem.mentormoduleservice.impl;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.te.leraningmanagementsystem.admindto.MentorDto;
import com.te.leraningmanagementsystem.adminpojo.Batch;
import com.te.leraningmanagementsystem.adminpojo.Mentor;
import com.te.leraningmanagementsystem.adminrepo.BatchRepository;
import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;
import com.te.leraningmanagementsystem.employeerepository.EmployeeRepo;
import com.te.leraningmanagementsystem.employeeservice.EmployeeService;
import com.te.leraningmanagementsystem.exceptionhandler.IdNotFoundException;
import com.te.leraningmanagementsystem.mentordto.FinalBatchDto;
import com.te.leraningmanagementsystem.mentordto.TraineeDto;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;
import com.te.leraningmanagementsystem.mentormodulerepo.FinalBatchRepo;
import com.te.leraningmanagementsystem.mentormodulerepo.TraineeRepo;
import com.te.leraningmanagementsystem.mentormoduleservice.TraineeService;
import com.te.leraningmanagementsystem.mentorpojo.FinalBatch;
import com.te.leraningmanagementsystem.mentorpojo.Trainee;

import net.bytebuddy.build.HashCodeAndEqualsPlugin.Sorted;


@Service
public class TraineeServiceImpl implements TraineeService{

	@Autowired
	private TraineeRepo traineeRepo;
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private BatchRepository repo;
	@Autowired
	private BatchRepository batchRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private FinalBatchRepo finalBatchRepo;

	@Override
	public FinalBatch addFinalBatch(FinalBatchDto finalBatchDto) {
		try {
			FinalBatch finalBatch = new FinalBatch();
			BeanUtils.copyProperties(finalBatchDto, finalBatch);
			if(finalBatchDto==null) {
				throw new IdNotFoundException("Final Batch Not Added");
			}else {
				return finalBatchRepo.save(finalBatch);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public Trainee addTrainee(TraineeDto traineeDto) {
		try {
			Trainee trainee = new Trainee();
			BeanUtils.copyProperties(traineeDto, trainee);
			if (traineeDto==null) {
				throw new IdNotFoundException("Not Added Succesfully");
			} else {

				return traineeRepo.save(trainee);
			}
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Trainee findTraineeId(int traineeId) {
			try {
				return traineeRepo.findById(traineeId).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
			} catch (Exception e) {
				throw e;
			}
		}

	@Override
	public Trainee updateTrainee(TraineeDto traineeDto,int traineeId) {
		try {
			Trainee trainee = traineeRepo.findById(traineeId).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
			BeanUtils.copyProperties(traineeDto, trainee);
			traineeRepo.save(trainee);
			return trainee;
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void deleteTrainee(int traineeId) {
		try {
			Trainee trainee = traineeRepo.findById(traineeId).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
            traineeRepo.delete(trainee);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<TraineeDto> findAllTrainee(int pageNumber,int pageSize) {
	
		PageRequest p = PageRequest.of(pageNumber, pageSize);
	    
		Page<Trainee> pagePost = this.traineeRepo.findAll(p);
		
		List<Trainee> allPosts = pagePost.getContent();
		
		List<TraineeDto> collect = allPosts.stream().map((trainee) -> this.modelMapper.map(trainee,TraineeDto.class)).collect(Collectors.toList());
//		List<String> list = collect.stream().map(t -> t.getBatchId()).toList();
		
		
		return collect;
		
		
	}

	@Override
	public PageResponse getAllTraineeDetails(int pageNumber, int pageSize, String str) {
			try {
			   PageRequest of = PageRequest.of(pageNumber, pageSize);
				Page<Trainee> page = traineeRepo.findAllByEmployeeNameContainingIgnoreCaseOrStatusContainingIgnoreCaseOrEmployeeIdContainingIgnoreCase(str, str, str, of);
						
				List<Trainee> content = page.getContent();
				
				if (content.isEmpty()) {
					throw new IdNotFoundException("No Any Mentors Presents At The Moment");
				} else {
					PageResponse responce = new PageResponse();
					responce.setContent(Arrays.asList(content));
					responce.setLastPage(page.isLast());
					responce.setTotalPages(page.getTotalPages());
					responce.setPageNumber(page.getNumber());
					responce.setPageSize(page.getSize());
					responce.setTotalElements(page.getTotalElements());
					return responce;
				}
			} catch (Exception e) {
				throw e;
			}
	}

	@Override
	public Map getAllTraineeDetails() {
		List<Trainee> findAll = traineeRepo.findAll();
   
		Map<String ,List<String>> map = new HashMap<>();
	for(Trainee trainee :findAll) {
		map.put(trainee.getEmployeeName(),trainee.getMockRating().getOverallFeedback());   
   }
		return map;
		
	}

	
	
	
}

