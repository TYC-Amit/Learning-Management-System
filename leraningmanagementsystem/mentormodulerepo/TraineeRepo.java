package com.te.leraningmanagementsystem.mentormodulerepo;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.leraningmanagementsystem.adminpojo.Batch;
import com.te.leraningmanagementsystem.mentorpojo.Trainee;

@Repository
public interface TraineeRepo extends JpaRepository<Trainee, Integer>{

//	List<Trainee> findAllByTraineeNameContaining(String traineeName);
//	List<Trainee> findAllByDeleted(boolean deleted);


	Optional<Trainee> findByEmployeeId(String employeeId);

	Page<Trainee> findByEmployeeNameContainingIgnoreCase(String str, PageRequest p);

	Page<Trainee> findAllByEmployeeNameContainingIgnoreCaseOrStatusContainingIgnoreCaseOrEmployeeIdContainingIgnoreCase(
			String str, String str2, String str3, PageRequest of);
}

