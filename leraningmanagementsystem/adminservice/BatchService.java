package com.te.leraningmanagementsystem.adminservice;

import java.util.List;

import com.te.leraningmanagementsystem.admindto.BatchDto;
import com.te.leraningmanagementsystem.adminpojo.Batch;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;

public interface BatchService {

	Batch create(BatchDto batchDto);

	Batch getBatch(int id);

	void deleteBatch(int id);

	Batch updateBatch(int id, BatchDto batchDto);
	
	List<Batch> findAllBatch();

	PageResponse getAllBatchDetails(int pageNumber, int pageSize, String batchName);

	
}
