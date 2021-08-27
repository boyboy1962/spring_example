package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	//요청 url: http://localhost/lesson03/ex01?id=#
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			//@RequestParam(value="id") int id						// 필수 파라미터 	id를 빼고 요청을 하면 에러가 난다.
			//@RequestParam(value="id", required = true) int id		// 필수 파라미터
			//@RequestParam("id") int id							// 필수 파라미터
			@RequestParam(value = "id", required = false) Integer id// 비-필수 파라미터 
			) {
		System.out.println("### id = " + id);
		Review review = reviewBO.getReviewById(id);
		return review;
	}
	
}
