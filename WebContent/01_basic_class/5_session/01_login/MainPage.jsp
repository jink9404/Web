<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Object obj = session.getAttribute("id");
	String id="";
	//# 1."id"로 저장된 세션값을 얻어온다.
	//# 2. 값이 null이라면 LoginForm.jsp로 페이지 이동
	if(obj == null){
		response.sendRedirect("LoginForm.jsp");return;
	}else{
	//# 3. null이 아니라면 String 형변환하여 변수에 지정
		id = (String)obj;
	}
	
%>	
    
<!DOCTYPE html>
<html>
<head>
<title> 우리 페이지 </title>
</head>
<body>

	<h2> 이 페이지는 로그인을 하셔야만 볼 수 있는 페이지 입니다 </h2><br/><br/><br/>
	<%= id %>님, 로그인 중입니다.

</body>
</html>