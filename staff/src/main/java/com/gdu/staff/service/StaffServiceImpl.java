package com.gdu.staff.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;
import com.gdu.staff.util.PageUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {
	
	private StaffMapper staffMapper; // 서비스 임플이 사용하는 필드는 매퍼다!
	private PageUtil pageUtil;
	
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
	@Override
	public void searchStaff(HttpServletRequest request) {
		
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("column"));
		String column = opt1.orElse("");
		
		
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("query"));
		String query = opt2.orElse("");
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		map.put("query", query);
		
		Optional<String> opt3 = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt3.orElse("1"));
		
		int totalRecord = 10;
		
		int recordPerPage = 10;

		pageUtil.setPageUtil(page, totalRecord, recordPerPage);
		

		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
	
		List<StaffDTO> employees = staffMapper.getsearchStaff(map);
		
		

		
	}
}
