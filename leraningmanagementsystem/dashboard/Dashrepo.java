package com.te.leraningmanagementsystem.dashboard;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;
import com.te.leraningmanagementsystem.mentorpojo.FinalBatch;

@Repository
public interface Dashrepo extends JpaRepository<FinalBatch, Integer>{

        Optional<FinalBatch> findByBatchId(String batchId);
	
//		List<EmployeePrimaryInfo> findByBatchId(String batchId);
}
