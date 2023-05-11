package com.gdu.staff.service;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffMapper staffMapper; // 서비스 임플이 사용하는 필드는 매퍼다!
	
	@Override
	public List<StaffDTO> getStaffList() {
		List<StaffDTO> staffList = staffMapper.getStaffList();
		return staffList;
	}
	
	@Override
	public String addStaff(HttpServletRequest request) {
	      try {
	         String sno = request.getParameter("sno");
	         String name = request.getParameter("name");
	         String dept = request.getParameter("dept");	
	         StaffDTO staffDTO = new StaffDTO(sno, name, dept, 0);
	         staffMapper.addStaff(staffDTO); //예시) 사원번호가 5byte 초과되거나 중복되거나 null인 경우 예외 발생
	         
	         return "사원 등록이 성공했습니다.";
	      } catch(Exception e) {
	         return "사원 등록이 실패했습니다."; // 캐치에서 넘기는건 $.ajax의 error로 전달된다!!
	      }
	   }
}
