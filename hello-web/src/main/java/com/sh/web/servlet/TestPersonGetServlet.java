package com.sh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet 클래스
 * - 웹요청을 처리하기 위한 자바클래스
 * - javax.servlet.http.HttpServlet 클래스 상속 (Tomcat 라이브러리에 포함, servlet-api.jar)
 * - GET 방식요청 - doGET요청
 * - POST 방식 요청 - doPost 작성
 * - request(사용자 요청관련 정보), response(응답처리를 위한) 객체 사용
 *
 */
@WebServlet("/testPerson1.do")
public class TestPersonGetServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자 입력값(문자열) 확인
		String name = req.getParameter("name"); // input 태그의 name 속성값
		String color = req.getParameter("color"); 
		String animal = req.getParameter("animal"); 
		String[] foods = req.getParameterValues("food"); 
		
		System.out.println(name);
		System.out.println(color);
		System.out.println(animal);
		System.out.println(Arrays.toString(foods));
		
		// 응답 html 작성
		// 헤더 작성 - MIME타입/작성
		resp.setContentType("text/html; charset= utf-8");
		
		PrintWriter out = resp.getWriter();
		String body = """
		<!doctype html>
		<html>
				<head>
						<meta charset="utf-8"/>
						<title>개인취향 검사 결과 GET</title>
				</head>
				<body>
						<h1>개인취향 검사 결과 GET - ( read 전용 )</h1>
						<p>반갑습니다. %s님</p>
						<p>%s색을 좋아하십니다. </p>
						<p>동물은 %s를 좋아하십니다. </p>
						<p>중국집 음식 중에는 %s을 좋아하십니다. </p>
				</body>
		</html>		
		""".formatted(name, color, animal, Arrays.toString(foods));
		System.out.println(body); // 콘솔에 출력
		
		out.append(body); // 응답 메시지 body에 출력
	}
}
