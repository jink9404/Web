<%@page import="mvc.board.model.BoardException"%>
<%@page import="mvc.board.model.BoardRec"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
	request.setCharacterEncoding("UTF-8");
%>


<%
	
	BoardRec reRec = null;

	reRec = (BoardRec)request.getAttribute("rec");
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 답변 글 저장하기 </title>
</head>
<body>
<% if(reRec != null){%>
답변글을 등록하였습니다. <br/><br/>

<a href="BoardControl?cmd=list-page"> 목록보기 </a> &nbsp;
<a href="BoardControl?cmd=view-page&articleId=<%=reRec.getArticleId()%>"> 게시글 읽기 </a>
<%}else{%>
마지막 3단계 답글은 달 수 없습니다.닝겐
<%} %>
</body>
</html>