<%@page import="mybatis.guest.service.CommentService"%>
<%@page import="mybatis.guest.model.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int commentNo = Integer.parseInt(request.getParameter("commentNo")); 
	int result = CommentService.getInstance().deleteCommentByNo(commentNo);
	
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	if(result >0)
		response.sendRedirect("listComment.jsp");
	else
		out.write("삭제에 실패했습니다.");
%>
	<a href="viewComment.jsp?cId=<%=commentNo%>">뒤로가기</a>
</body>
</html>