package com.gdu.staff.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.service.StaffService;

@Controller
public class StaffController {
	
	@Autowired
	private StaffService staffService;// 컨트롤러가 사용하는 서비스 
	
	@ResponseBody // Map/list로 반환하고 싶으면 이거 해야함 ResponseEntity 로 반환하고 싶으면 안적음!!
	@GetMapping(value="/list.json", produces=MediaType.APPLICATION_JSON_VALUE) // 이 요청을 받음
	public List<StaffDTO>list(){
		return staffService.getStaffList();
	}
	
	@ResponseBody
	@PostMapping(value="/add.do", produces="text/plain; charset=UTF-8")
	public String add(HttpServletRequest request) {
		return staffService.addStaff(request);
	}
	
	@ResponseBody
	@GetMapping(value="/search.json",produces=MediaType.APPLICATION_JSON_VALUE)
	public String search(HttpServletRequest request) {
		
		staffService.searchStaff(request);
		return "employees/search";
	}
	

}
