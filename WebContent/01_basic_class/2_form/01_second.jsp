<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- client -> server : request
	 server -> client : response -->
<%@ page import="temp.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	String user = request.getParameter("User");
	String pass = request.getParameter("Pass");
	TempVO tempVo = TempVO.getInstance();
	tempVo.setId(user);
	tempVo.setPass(pass);
	TempDAO tempDao = TempDAO.getInstance();
	boolean islogin = tempDao.login(tempVo);
%>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 폼의 입력값 처리 </title>
</head>
<body>
	<h2>폼의 입력값 넘겨받아 처리</h2>
	<% if(islogin){ %>
	<%="로그인성공" %>
	입력한 아이디 : <%=user%> <br/>
	입력한 패스워드 : <%=pass %>
	
	
	<%}else{ %>
	<%="로그인실패" %>
	<%
	response.sendRedirect("01_first.jsp");
	} %>
</body>
</html>