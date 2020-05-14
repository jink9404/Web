<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ page import="info.beans.InfoBean" %>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bean" class="info.beans.InfoBean">
	<jsp:setProperty property="name" name="bean"/>
	<jsp:setProperty property="id" name="bean"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
<body>
	<h2>  당신의 신상명세서 확인 </h2>
	이   름  : <jsp:getProperty property="id" name="bean"/><br/>
	주민번호 : <jsp:getProperty property="name" name="bean"/><br/>
	성  별   : <%=bean.getGender() %><br/>  
	맞습니까????
</body>
</html> 