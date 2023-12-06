package com.sh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * Servlet - 업무로직 처리. jsp로 forwarding
 * JSP - html 작성
 *
 */
@WebServlet("/testPerson3.do")
public class TestPersonServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청메시지에 대한 인코딩 처리 (POST 요청에만 해당)
		req.setCharacterEncoding("utf-8");
		
		// 사용자 입력값 처리
		String name = req.getParameter("name");
		String color = req.getParameter("color");
		String animal = req.getParameter("animal");
		String[] foods = req.getParameterValues("food");
		
		System.out.println(name);
		System.out.println(color);
		System.out.println(animal);
		System.out.println(Arrays.toString(foods));
		
		
		// 업무로직 : 사용자의 취향을 고려해 추천 키워드를 제공
		// switch statement : JDK 17 이상
		String recommendation = switch(color) {
		case "빨강" -> "매운 떡볶이";
		case "노랑" -> "노란 동화책";
		case "초록" -> "초록색 상추쌈";
		case "파랑" -> "시원한 사이다";
		default -> "저도 모르겠습니다.";
		};
		System.out.println(recommendation);
		// jsp전달하기 - request객체에 속성으로 저장
		req.setAttribute("recommendation", recommendation);
		
		// jsp 포워딩 (RequestDispatcher)
		// 파일 경로(절대경로) src/main/webapp(웹 루트) 이하부터 작성
		RequestDispatcher reqDispatcher = 
				req.getRequestDispatcher("/WEB-INF/views/testPersonResult.jsp");
		reqDispatcher.forward(req, resp);
		
		// 응답 html 작성
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter(); // 출력대상이 응답메시지인 문자기반 출력스트림
		String body = """
		<!doctype html>
		<html>
				<head>
						<meta charset="utf-8"/>
						<title>개인취향 검사 결과 POST</title>
				</head>
				<body>
						<h1>개인취향 검사 결과 POST - (insert, update, delete 전용)</h1>
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
