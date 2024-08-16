package com.nyeong.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 해당 클래스의 모든 메소드는 ResponseBody가 적용된다.
@RestController // @Controller + @ResponseBody
@RequestMapping("lifecycle/ex01")
public class Ex01RestController {

	// 직접 만든 클래스 객체 리턴
	@RequestMapping("/3")
	public Person objectResponse() {
		Person me = new Person("강수녕", 20);
		
		return me;
		
	}
	
	// status code 전달
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse(){
		Person me = new Person("강수녕", 25);
		
		// HTTP Status Code
		// 200 OK 정상
		// 404 NOT FOUND : 페이지가 없다(주소 확인)
		// 400 BAD REQUEST : 요청이 잘못되었다. (파라미터 개수, 이름 일치 확인)
		// 405 METHOD NOT ALLOW : 메소드가 일치하지 않음(Get, Post)
		// 500 INTERNAL SERVER ERROR : 서버 에러(내 코드 확인)
		
		return new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
