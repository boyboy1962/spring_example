package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson04")
@Controller
public class NewUserController {
	
	@Autowired
	private NewUserBO newUserBO;
	
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
	
	
	@GetMapping("/ex1/last_user")
	public String getLastUser(Model model) {
		
		NewUser user = newUserBO.getLastNameUser();
		
		model.addAttribute("user", user);
		model.addAttribute("title", "회원 정보");
		
		return "lesson04/lastUser";
		
	}
	
}
