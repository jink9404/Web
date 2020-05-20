<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ page import="member.beans.*" %>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="mem" class="member.beans.Member">
	<jsp:setProperty name="mem" property="*"/>
</jsp:useBean>

<%
	MemberDao memDao = MemberDao.getInstance();
	memDao.insertMember(mem);
%>


<!DOCTYPE html>
<html>
<head>
<title> 회원가입 </title>
</head>
<body>
	아이디 : <br/>
	패스워드 : <br/>
	이름 : <br/>
	전화 : <br/>
	주소 : <br/>
</body>
</html>