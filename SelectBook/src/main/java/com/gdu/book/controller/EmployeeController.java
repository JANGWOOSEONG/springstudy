package com.gdu.book.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdu.book.service.EmployeeListService;
@RequestMapping("/book")
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeListService employeeListService;
	
	@GetMapping("/pagination.do")
	public String pagination(HttpServletRequest request, Model model) {
		employeeListService.getEmployeeListUsingPagination(request, model);
		return "book/pagination";
	}

}
