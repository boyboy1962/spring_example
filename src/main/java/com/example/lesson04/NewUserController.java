package com.example.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/lesson04")
@Controller
public class NewUserController {
	
	// 요청 URL : http://localhost/lesson04/ex01/1
	@RequestMapping(method = RequestMethod.GET, path = "/ex01/1") // 이것은 get 방식이다.
	public String ex01_1() {
		return "lesson04/addUser"; // /WEB-INF/jsp/		lesson04/addUser	.jsp 
	}
	
	// 요청 URL : http://localhost/lesson04/ex01/add_user
	//@RequestMapping(method = RequestMethod.POST, path = "/ex01/add_user") // 이것이 post 방식이다. 
	@PostMapping("/ex01/add_user") // 이것이 더 간단한 post 방식이다. 
	public String addUser(
				@RequestParam("name") String name,
				@RequestParam("yyyymmdd") String yyyymmdd,
				@RequestParam("email") String email,
				@RequestParam(value = "introduce", required = false) String introduce // 비필수라서 값이 들어오지 않을 수 있다.
			) {
		// DB Insert
		
		return "lesson04/afterAddUser";
	}
	
}
