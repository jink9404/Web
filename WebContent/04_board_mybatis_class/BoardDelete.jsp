<%@page import="mybatis.board.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.*,board.service.*" %>
 
<%
	request.setCharacterEncoding("UTF-8");
	// 1. 삭제할 레코드의 게시글번호와 비밀번호를 넘겨받기
	String articleId = request.getParameter("articleId");
	String password = request.getParameter("password");
	// 2. Service에 delete() 호출
	BoardService service = BoardService.getInstance();
	int result =  service.delete(articleId, password); 
%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 게시글 삭제 </title>
</head>
<body>

	<% if( result != 0) { %>
			글을 삭제하였습니다.
	<% } else { %>
			삭제가 실패되었습니다.
	<% } %>
	<br/><br/>
	<a href="BoardList.jsp"> 목록보기 </a>
</body>
</html>