<%@page import="guest.model.MessageDao"%>
<%@page import="guest.model.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guest.service.WriteMessageService"%>    
 
<!-- 
	0. 넘겨받는 데이타의 한글처리
	1. 화면의 입력값을 Message 클래스로 전달
	2. Service 클래스의 함수 호출
 -->      
 <% request.setCharacterEncoding("UTF-8"); %>
 <jsp:useBean id="message" class="guest.model.Message">
	<jsp:setProperty property="*" name="message"/>
 </jsp:useBean>
<%
	WriteMessageService service = WriteMessageService.getInstance();
	service.write(message);
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 남김 </title>
</head>
<body>
	<font size="3" color="#bb44cc">
		방명록에 메세지를 남겼습니다. <hr/>
		<%=message.getMessage() %>
	</font><br/><br/><br/>
	 <a href="listMessage.jsp">[ 목록보기 ]</a> 
</body>
</html>