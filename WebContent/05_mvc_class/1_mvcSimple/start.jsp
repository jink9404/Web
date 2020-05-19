<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String projectName = "/JSP"; %>
<html>
<head>
<meta charset="UTF-8">
<title>start.jsp</title>
</head>
<body>
<a href='JSP/05_mvc_class/1_mvcSimple/simpleView.jsp'>기본방식</a>
<hr/>
<a href='<%=projectName%>/05_mvc_class/1_mvcSimple/simpleView.jsp'>기본방식</a>
<a href='<%=projectName%>/SimpleControl'>MVC방식</a>
<a href='<%=projectName%>/121.kmj'>MVC방식</a>
<a href='<%=projectName%>/12221.kmj'>MVC방식</a>
<a href='<%=projectName%>/121.do'>MVC방식</a>
</body>
</html>