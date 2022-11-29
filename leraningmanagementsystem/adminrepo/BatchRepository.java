package com.te.leraningmanagementsystem.adminrepo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.leraningmanagementsystem.adminpojo.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {

	List<Batch> findAllByDeleted(boolean deleted);

//	List<Batch> findAllByBatchNameContaining(String batchName);
	
	Page<Batch> findAllByBatchNameContainingIgnoreCaseOrStatusContainingIgnoreCaseOrBatchIdContainingIgnoreCase(
			String str, String str2, String str3, PageRequest of);
}
