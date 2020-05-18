<%@page import="mybatis.guest.service.CommentService"%>
<%@page import="mybatis.guest.model.Comment"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	int primaryNo = Integer.parseInt(request.getParameter("commentNo"));
	Comment comment = CommentService.getInstance().selectCommentByPrimaryKey(primaryNo);
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
<title>수정</title>
</head>
<body>

메세지를 수정해주세요.
<form name="frm" action="updateCommentSave.jsp" >
<table>
	<tr><td>글번호</td><td><input type="text" name="commentNo" size="3" value="<%=comment.getCommentNo()%>"/></td></tr>
	<tr><td>사용자</td><td><input type="text" name="userId" size="15" value="<%=comment.getUserId() %>" /></td></tr>
	<tr><td>메세지</td><td><textarea name="commentContent" rows="10" columns="40"><%=comment.getCommentContent() %></textarea></td></tr>
	<tr><td><input type="submit" value="입력"/></td></tr>
</table>
</form>
</body>
</html>