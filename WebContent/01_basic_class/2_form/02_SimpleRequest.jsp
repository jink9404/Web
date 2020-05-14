<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String name = request.getParameter("name");
   String gender = request.getParameter("gender");
   String occupation = request.getParameter("occupation");
   String hobby[] = request.getParameterValues("hobby");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=name %>
<%=gender %>
<%=occupation %>

	<%for(int i = 0; hobby != null && i<hobby.length; i++){ %>
	<%=hobby[i]%>
	<%}%>


</body>
</html>