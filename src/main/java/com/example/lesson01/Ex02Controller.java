package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex02Controller {
	
	// 요청 URL : http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	// @ResponseBody
	public String ex02() {
		// @Controller 어노테이션만 있을 때(@ResponseBody가 없음)
		// ViewResolver 클래스 작동 -> 리턴된 String 이름의 view를 찾아서 ciew 화면이 구성된다.
		
		return"lesson01/ex02";
	}
	
}
