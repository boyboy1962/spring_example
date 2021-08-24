package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 메소드에 붙은 mapping 먼저 적용
@Controller
public class Ex01Controller {
	
	// 요청 URL : http://localhost/lesson01/ex01/1
	@RequestMapping("/1") 	// 주소 매핑 꼭 "/"이게 앞에 있다.
	// 메소드가 리턴하는 값을.../메소드 마다 하나씩 필요시에
	@ResponseBody				// 리턴되는 값을 HTML Response Body로 보낸다.
	public String printString() {
		String text = "예제 1번<br>문자열을 response body로 보내느 예제";
		return text;
	}
	
	// 요청 URL : http://localhost/lesson01/ex01/2
	@RequestMapping ("/2")
	public @ResponseBody Map<String, Object> printMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("포도", 4);
		map.put("파인에플", 4);
		map.put("apple", 4);
		
		// map을 리턴하면 json으로 나타난다. wev starter 에 jackson 이라는 라이브러리가 표함되어 있기 때문
		// @ResponseBody 어노테이션이 있기 때문에 jackson이 동작함
		return map;
	}
}
