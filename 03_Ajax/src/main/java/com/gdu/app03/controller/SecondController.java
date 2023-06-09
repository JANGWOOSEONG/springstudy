package com.gdu.app03.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app03.domain.BmiVO;
import com.gdu.app03.service.ISecondService;



@Controller
public class SecondController {

	private ISecondService secondService;
	
	//@AllArgsConstructor 생성자를 만들어주고 @Autowired는 생략 할 수 있기 때문에 아래 코드를 생략할 수 있다.
	@Autowired // 생성자에서 @Autowired는 생략할 수 있다.
	public SecondController(ISecondService secondService) {
		super();
		this.secondService = secondService;
	}
	
	@ResponseBody
	@GetMapping(value="/second/bmi1", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BmiVO> bmi1(HttpServletRequest request){
		return secondService.execute1(request);
		
	}
	
	@ResponseBody
	@GetMapping("/second/bmi2") // produces가 없음에 주의합니다. (반환 객체 ResponseEntity에 Content-Type을 작성해서 보냅니다.)
	public ResponseEntity<Map<String, Object>> bmi2(BmiVO bmiVO){
		return secondService.execute2(bmiVO);
	}
	
	
	/*
	@ResponseBody
	@GetMapping(value="/second/bmi1", produces=MediaType.APPLICATION_JSON_VALUE) // MediaType.APPLICATION_JSON_VALUE는 "application/json 이다.
	public BmiVO bmi1(HttpServletRequest request, HttpServletResponse response) {
		return secondService.execute1(request, response);
	}
		
	@ResponseBody
	@GetMapping(value="/second/bmi2", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> bmi2(BmiVO bmiVO) {
		return secondService.execute2(bmiVO);
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
}
