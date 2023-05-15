package com.gdu.app12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/user")
@Controller
public class UserController {
	
	@GetMapping("/agree.form")
	public String agreeForm() {
		return "user/agree";
	}

	@GetMapping("/join.form")
	public String joinForm(@RequestParam(value="location", required=false) String location // 파라미터 locationd이 전달되지 않으면 빈 문자열("")이 Stirng location에 저장된다.
						, @RequestParam(value="event",required=false) String event		  // 파라미터 event가 전달되지 않으면 빈 문자열("")이 Stirng event에 저장된다.
						, Model model) {
		model.addAttribute("location", location);
		model.addAttribute("event", event);
		return "user/join";
		
	}
}
