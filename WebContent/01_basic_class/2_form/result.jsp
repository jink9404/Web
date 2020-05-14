<%@page import="temp.TempDAO"%>
<%@page import="temp.TempVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	request.setCharacterEncoding("UTF-8");	

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String tel = request.getParameter("tel");
	String name = request.getParameter("name");
	String adr = request.getParameter("adr");
	TempVO vo = TempVO.getInstance();
	vo.setId(id);
	vo.setPass(password);
	vo.setName(name);
	vo.setTel(tel);
	vo.setAddr(adr);
	
	TempDAO dao = TempDAO.getInstance()	;
	dao.insert(vo);
%>
<title></title>
</head>
<body>
<%=id %>
<%=password %>
<%=tel %>
<%=name %>
<%=adr %>
</body>
</html>