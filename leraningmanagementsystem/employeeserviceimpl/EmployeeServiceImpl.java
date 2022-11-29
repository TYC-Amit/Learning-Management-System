package com.te.leraningmanagementsystem.employeeserviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.te.leraningmanagementsystem.adminpojo.Batch;
import com.te.leraningmanagementsystem.employeedto.EmployeePrimaryInfoDto;
import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;
import com.te.leraningmanagementsystem.employeerepository.EmployeeRepo;
import com.te.leraningmanagementsystem.employeeservice.EmployeeService;
import com.te.leraningmanagementsystem.exceptionhandler.EmployeeNotFoundException;
import com.te.leraningmanagementsystem.exceptionhandler.IdNotFoundException;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeePrimaryInfo addAllDeatilsEmp(EmployeePrimaryInfoDto employeedto) {
		try {
			EmployeePrimaryInfo employeePrimaryInfo = new EmployeePrimaryInfo();
			BeanUtils.copyProperties(employeedto, employeePrimaryInfo);

			if (employeedto == null) {
				throw new EmployeeNotFoundException("Insert Data Properly");
			} else {
				List<EmployeePrimaryInfo> findAll = employeeRepo.findAll();
				employeePrimaryInfo.setEmployeeId("TYC022" + String.format("%03d", findAll.size() + 1));
				return employeeRepo.save(employeePrimaryInfo);
			}

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Optional<EmployeePrimaryInfo> findByEmployeeId(String employeeId) {
		Optional<EmployeePrimaryInfo> findByEmployeeId = employeeRepo.findByEmployeeId(employeeId);
		try {
			if (findByEmployeeId.isEmpty()) {
				throw new EmployeeNotFoundException("Please Enter Proper EmployeeId");
			}
		} catch (Exception e) {
			throw e;
		}
		return findByEmployeeId;
	}

	@Override
	public EmployeePrimaryInfo updateEmployeeInfo(String employeeId, EmployeePrimaryInfoDto employeedto) {
		try {
			Optional<EmployeePrimaryInfo> findByEmployeeId = employeeRepo.findByEmployeeId(employeeId);
			EmployeePrimaryInfo employeePrimaryInfo = findByEmployeeId.get();

			if (findByEmployeeId.isEmpty()) {
				throw new EmployeeNotFoundException("Employee Is Not Present");
			} else {
				BeanUtils.copyProperties(employeedto, employeePrimaryInfo);
				EmployeePrimaryInfo save = employeeRepo.save(employeePrimaryInfo);
				return save;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<EmployeePrimaryInfo> findAllEmployeePrimaryInfo() {
		return employeeRepo.findAllByDeleted(false);
	}

	@Override
	public PageResponse getAllEmployeeDetails(int pageNumber, int pageSize, String str) {
		try {
			PageRequest of = PageRequest.of(pageNumber, pageSize);
		 Page<EmployeePrimaryInfo> page = employeeRepo
					.findAllByEmployeeNameContainingIgnoreCase(str, of);

			List<EmployeePrimaryInfo> content = page.getContent();

			if (content.isEmpty()) {
				throw new IdNotFoundException("No Any Employee Presents At The Moment");
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
			e.printStackTrace();
			throw e;
		}
	}

	
}
