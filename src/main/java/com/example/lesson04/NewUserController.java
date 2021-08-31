package com.example.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson04")
@Controller
public class NewUserController {
	
	// 요청 URL : http://localhost/lesson04/ex01/1
	@RequestMapping("/ex01/1")
	public String ex01_1() {
		return "lesson04/addUser"; // /WEB-INF/jsp/		lesson04/addUser	.jsp
	}
	
}
