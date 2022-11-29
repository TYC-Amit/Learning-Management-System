package com.te.leraningmanagementsystem.dashboard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;
import com.te.leraningmanagementsystem.employeerepository.EmployeeRepo;
import com.te.leraningmanagementsystem.exceptionhandler.IdNotFoundException;
import com.te.leraningmanagementsystem.mentormodulerepo.TraineeRepo;
import com.te.leraningmanagementsystem.mentorpojo.FinalBatch;

@Service
public class DashboardServiceImpl implements DashBoardServices {

	@Autowired
	private Dashrepo repo;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private TraineeRepo traineeRepo;

	@Override
	public Map<String, Long> pichart(String batchId) {
		try {
			Optional<FinalBatch> batch = repo.findByBatchId(batchId);
//			List<FinalBatch> list = repo.findAll().stream().filter(t -> t.getBatchId().equalsIgnoreCase(batchId)).toList();
					if (!batch.isPresent()) {
						throw new IdNotFoundException("Batch You Want Is Not Present");
					} else {
						List<EmployeePrimaryInfo> emp = batch.get().getEmployeePrimaryInfo();
						long male = emp.stream().filter(t -> t.getGender().equalsIgnoreCase("male")).count();
						long female = emp.stream().filter(t -> t.getGender().equalsIgnoreCase("female")).count();
						Map<String, Long> chart = new HashMap<>();
						chart.put("Male", male);
						chart.put("Female", female);
						return chart;
					}

				} catch (Exception e) {
					throw e;
				}
			}
	

	@Override
	public Map<String, Long> barGraph(String batchId) {
		try {
			Optional<FinalBatch> batch = repo.findByBatchId(batchId);
			if (!batch.isPresent()) {
				throw new IdNotFoundException("Batch You Want Is Not Present");
			} else {
				List<EmployeePrimaryInfo> emp = batch.get().getEmployeePrimaryInfo();				
				long year2020 = emp.stream().filter(t -> t.getEducationDetails().getYearOfPassing()==2020).count();
				long year2021 = emp.stream().filter(t -> t.getEducationDetails().getYearOfPassing()==2021).count();
				long year2022 = emp.stream().filter(t -> t.getEducationDetails().getYearOfPassing()==2022).count();
				long year2023 = emp.stream().filter(t -> t.getEducationDetails().getYearOfPassing()==2023).count();
				
				Map<String, Long> chart = new HashMap<>();
				
				chart.put("2020", year2020);
				chart.put("2021", year2021);
				chart.put("2022", year2022);
				chart.put("2023", year2023);
				return chart;
			}
		} catch (Exception e) {
			throw e;
		}
			}
		
	@Override
	public Map<String, Long> barGraphDegree(String batchId) {
		try {
			Optional<FinalBatch> batch = repo.findByBatchId(batchId);
			if (!batch.isPresent()) {
				throw new IdNotFoundException("Batch You Want Is Not Present");
			} else {
				List<EmployeePrimaryInfo> emp = batch.get().getEmployeePrimaryInfo();
				Map<String, Long> graph = new HashMap<>();
				graph.put("Graduation",emp.stream().filter(t -> t.getEducationDetails().getEducationType().equalsIgnoreCase("Graduation")).count());
				graph.put("Post Graduation",emp.stream().filter(t -> t.getEducationDetails().getEducationType().equalsIgnoreCase("Post Graduation")).count());
				return graph;
			}
		} catch (Exception e) {
			throw e;
	
	}
}


	@Override
	public Map<String, Long> barGraphExperience(String batchId) {
		try {
			Optional<FinalBatch> batch = repo.findByBatchId(batchId);
			if (!batch.isPresent()) {
				throw new IdNotFoundException("BATCH_YOU_WANT_IS_NOT_PRESENT");
			} else {
				List<EmployeePrimaryInfo> emp = batch.get().getEmployeePrimaryInfo();
				Map<String, Long> graph = new HashMap<>();
				List<java.util.stream.Stream<Integer>> collect = emp.stream().map(e -> e.getExperience().stream().map(t -> {
					return t.getYearOfExperience();
				})).collect(Collectors.toList());
				List<Integer> collect2 = collect.stream().flatMap(e -> e).collect(Collectors.toList());
				graph.put("Fresher", collect2.stream().filter(t -> t == 0).count());
				graph.put("1", collect2.stream().filter(t -> t == 1).count());
				graph.put("2", collect2.stream().filter(t -> t == 2).count());
				graph.put("5", collect2.stream().filter(t -> t == 5).count());
				graph.put("10", collect2.stream().filter(t -> t == 10).count());
				return graph;
			}
		} catch (Exception e) {
			throw e;
		}
	}

}