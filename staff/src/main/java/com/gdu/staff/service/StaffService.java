package com.gdu.staff.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gdu.staff.domain.StaffDTO;

public interface StaffService {
	
	public List<StaffDTO> getStaffList();
	public String addStaff(HttpServletRequest request);
}
