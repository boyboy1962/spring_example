package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController		// @Controller + @ ResponseBody 여기는 view로 보내는게 없어서 해당 어노테이션을 쓴다.
public class Ex01RestController {
	
	// 요청 URL : http://localhost/lesson01/ex01/3
	@RequestMapping("/3")
	public String printString () {
		return "@RestController를 사용해서 String을 리턴해본다.";
	}
	
	@RequestMapping("/4")
	public Map<String, String> printMap() {
		Map<String, String> result = new HashMap<>();
		result.put("1", "2");
		result.put("3", "4");
		result.put("5", "6");
		return result;
	}
	
	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data();		// 일반 자바 bean
		data.setId(1);
		data.setName("신보람");
		return data;				//일반 bean 객체도 json으로 내려간다.
	}
	
	@RequestMapping("/6")
	public ResponseEntity<Data> entity() {
		Data data = new Data();		// 일반 자바 bean
		data.setId(100);
		data.setName("신바다");

		//return new ResponseEntity<>(data, HttpStatus.OK);						// 200 OK
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); 	// 500 error 
	}
}
