<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
<html>
<head><title>쿠키</title></head>
<body>

<b>Simple Cookie Example</b><hr>

쿠키를 제어하는 방법은 

1) 기존의 쿠키에 빈 값을 지정
2) 유효한 시간을 0으로 지정
3) 클라이언트로 보낸다

<%	

			Cookie c=new Cookie("yourid", "");
			c.setMaxAge(0);
			response.addCookie(c);

%>


<br><a href="01_GetCookie.jsp"> 쿠키검색 </a>

</body></html>