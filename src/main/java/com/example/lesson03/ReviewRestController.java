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
			//@RequestParam(value="id") int id										// 필수 파라미터 	id를 빼고 요청을 하면 에러가 난다.
			//@RequestParam(value="id", required = true) int id						// 필수 파라미터
			//@RequestParam("id") int id											// 필수 파라미터
			//@RequestParam(value = "id", required = false) Integer id				// 비-필수 파라미터
			@RequestParam(value = "id", required = false, defaultValue = "1") int id// 비 필수 파라미터	하지만 디폴트로 숫자가 정해저 있다.
			) {
		System.out.println("### id = " + id);
		Review review = reviewBO.getReviewById(id);
		return review;
	}
	
	@RequestMapping("/lesson03/ex02")
	public String ex02() {
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("신보람");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 적당");
		
		int rowCount = reviewBO.addReview(review); //
		
		return "라인은 " + rowCount;
	}
	
	// 요청 URL: http://localhost/lesson03/ex02/2
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() {
		int rowCount = reviewBO.addReviewAsField(3, "치즈와퍼", "신바다", 5.0, "치즈 와퍼 좋아요!");
		
		return "성공한 행의 개수는 : " + rowCount;
	}
	
	// 요청 URL: http://localhost/lesson03/ex04?id=24
	@RequestMapping("/lesson03/ex04")
	public String ex04(
				@RequestParam("id") int id
			) {

		int rowCount = reviewBO.deleteReviewById(id);
		
		return "삭제 완료 : " + rowCount;
	}
}
