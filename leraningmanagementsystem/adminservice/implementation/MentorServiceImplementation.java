package com.te.leraningmanagementsystem.adminservice.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.te.leraningmanagementsystem.admindto.MentorDto;
import com.te.leraningmanagementsystem.adminpojo.Batch;
import com.te.leraningmanagementsystem.adminpojo.Mentor;
import com.te.leraningmanagementsystem.adminrepo.MentorRepository;
import com.te.leraningmanagementsystem.adminservice.MentorService;
import com.te.leraningmanagementsystem.exceptionhandler.IdNotFoundException;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MentorServiceImplementation implements MentorService {

	
	private final MentorRepository repo;

	@Override
	public Mentor create(MentorDto dto) {
		try {
			Mentor mentor = Mentor.builder().build();
			BeanUtils.copyProperties(dto, mentor);
			if (dto == null) {
				throw new IdNotFoundException("Insert Data Properly");
			} else {
				List<Mentor> findAll = repo.findAll();
				mentor.setEmployeeId("TYC022" + String.format("%03d", findAll.size() + 1));
				return repo.save(mentor);
			}
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Mentor findMentor(int mentorId) {
		try {
			return repo.findById(mentorId).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(int mentorId) {
		try {

			Mentor mentor = repo.findById(mentorId).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
			repo.delete(mentor);
            
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Mentor update(int mentorId,MentorDto dto) {
		try {
			Mentor mentor = repo.findById(mentorId).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
			BeanUtils.copyProperties(dto, mentor);
			repo.save(mentor);
			return mentor;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<Mentor> findAllMentor() {
		return repo.findAllByDeleted(false);
	}

	@Override
	public PageResponse getAllMentorDetails(int pageNumber, int pageSize, String str) {
		try {
			PageRequest of = PageRequest.of(pageNumber, pageSize);
			Page<Mentor> page = repo
					.findAllByMentorNameContainingIgnoreCaseOrMailContainingIgnoreCaseOrEmployeeIdContainingIgnoreCase(
							str, str, str, of);

			List<Mentor> content = page.getContent();

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