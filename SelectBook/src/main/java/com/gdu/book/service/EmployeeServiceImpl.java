package com.gdu.book.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.book.mapper.EmployeeListMapper;
@Service
public class EmployeeServiceImpl implements EmployeeListService {
	
	@Autowired
	private EmployeeListMapper employeeListMapper;

	@Override
	public void getEmployeeListUsingPagination(HttpServletRequest request, Model model) {
		
		model.addAttribute("employees", employeeListMapper.getEmployeeListUsingPagination(null));
	}

	@Override
	public Map<String, Object> getEmployeeListUsingScroll(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getEmployeeListUsingSearch(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, Object> getAutoComplete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
