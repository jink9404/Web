<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!-- 0. JSTL 설정 -->



<!DOCTYPE html>
<html>
<head>
<title> 1~100까지 중 숫자 맞추기 </title>
</head>
<body>

<!-- 1. 이전화면 값 얻어와 guess 변수에 지정 -->

<!-- 2. 그 값이 없다면 임의의 수를 만들어 세션에 지정 -->


<!-- 3. 세션의 값을 가져와 answer 변수에 지정 -->


<!-- 4. guess의 변수에 값이 있다면 -->
<!--  (1) guess와 answer값이 같다면 맞춰다고 출력 -->
<!--  (2) 다르다면 guess값이 answer값보다 크면 크다고 출력 작으면 작다고 출력 -->



	<hr><hr>
	1부터 100까지 수 중에서 하나를 잘 찍으시오~!! <br/>
	
	<form method='get'>
			어떤 수일까요?
			<input type='text' name='guess'>
			<input type='submit' value="Submit">
	</form>
</body>
</html>