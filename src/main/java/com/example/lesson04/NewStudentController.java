package com.example.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.model.NewStudent;

@RequestMapping("/lesson04")
@Controller
public class NewStudentController {
	
	// 요청 URL: http://localhost/lesson04/ex02/1
	@GetMapping("/ex02/1")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// 요청 URL: http://localhost/lesson04/ex02/add_student
	@PostMapping("/ex02/add_student")
	public String addStudent(
				@ModelAttribute NewStudent newStudent	// name 태그 값과 일치하는 필드에 값이 들어간다. 
			) {
		// 학생 정보 파라미터 받기
		
		// DB INSERT
		
		// DB SELECT
		
		// VIEW 데이터 세팅(model)
		
		
		return "lesson04/afterAddStudent";
	}
}
