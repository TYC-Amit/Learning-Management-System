package com.te.leraningmanagementsystem.adminservice.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.te.leraningmanagementsystem.admindto.BatchDto;
import com.te.leraningmanagementsystem.adminpojo.Batch;
import com.te.leraningmanagementsystem.adminrepo.BatchRepository;
import com.te.leraningmanagementsystem.adminservice.BatchService;
import com.te.leraningmanagementsystem.exceptionhandler.IdNotFoundException;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchServiceImplementation implements BatchService {

	@Autowired
	private BatchRepository repo;

	@Override
	public Batch create(BatchDto batchDto) {
		try {
			Batch batch = Batch.builder().build();
			BeanUtils.copyProperties(batchDto, batch);
			if (batchDto == null) {
				throw new IdNotFoundException("Insert Data Properly");
			} else {
				List<Batch> findAll = repo.findAll();
				batch.setBatchId("TYBAT" + String.format("%03d", findAll.size()) + 1);
				return repo.save(batch);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Batch getBatch(int id) {
		try {
			return repo.findById(id).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteBatch(int id) {
		try {

			Batch batch = repo.findById(id).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
			repo.delete(batch);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public Batch updateBatch(int id, BatchDto batchDto) {
		try {
			Batch batch = repo.findById(id).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
			BeanUtils.copyProperties(batchDto, batch);
			repo.save(batch);
			return batch;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<Batch> findAllBatch() {
		return repo.findAllByDeleted(false);
	}

	@Override
	public PageResponse getAllBatchDetails(int pageNumber, int pageSize, String str) {
		try {
			PageRequest of = PageRequest.of(pageNumber, pageSize);
			Page<Batch> page = repo
					.findAllByBatchNameContainingIgnoreCaseOrStatusContainingIgnoreCaseOrBatchIdContainingIgnoreCase(
							str, str, str, of);

			List<Batch> content = page.getContent();

			if (content.isEmpty()) {
				throw new IdNotFoundException("No Any Batch Presents At The Moment");
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
}