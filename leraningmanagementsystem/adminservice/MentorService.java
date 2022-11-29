package com.te.leraningmanagementsystem.adminservice;

import java.util.List;

import com.te.leraningmanagementsystem.admindto.MentorDto;
import com.te.leraningmanagementsystem.adminpojo.Mentor;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;

public interface MentorService {


	public Mentor create(MentorDto dto);

	public Mentor findMentor(int mentorId);

	public void delete(int mentorId);

	public Mentor update(int mentorId, MentorDto dto);
	
	public List<Mentor> findAllMentor();

	public PageResponse getAllMentorDetails(int pageNumber, int pageSize, String mentorName);
}
