package com.te.leraningmanagementsystem.adminrepo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.te.leraningmanagementsystem.adminpojo.Batch;
import com.te.leraningmanagementsystem.adminpojo.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer>{

	List<Mentor> findAllByDeleted(boolean deleted);
	
	Page<Mentor> findAllByMentorNameContainingIgnoreCaseOrMailContainingIgnoreCaseOrEmployeeIdContainingIgnoreCase(
			String str, String str2, String str3, PageRequest of);
}
