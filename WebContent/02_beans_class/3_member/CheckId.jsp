<%@page import="member.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <% request.setCharacterEncoding("UTF-8"); %>
  <%
  	MemberDao dao = MemberDao.getInstance();
  	String id = request.getParameter("userId");
  %>
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 아이디 중복 확인 </title>
<script type="text/javascript">
	window.onload = function(){
	   	document.getElementById("id_check").onclick = function(){
            opener.document.frm.id.value = document.getElementsByName("userId")[0].value;
            window.close();
        }
        
	}
</script>
</head>
<body>
<%
	if(dao.isDuplicatedId(id) ) {
%>
		사용중인 아이디가 있습니다. 다시 입력하여 주십시오.
<%  }else { %>
		사용할 수 있는 아이디입니다.
<%  } %>
<form action="CheckId.jsp" name="form" method="get">
	<input type="text" name="userId" value="<%=id %>" >
	<input type="submit" value="중복확인" >
	<input type="button" id="id_check" value="아이디 채택" >
</form>
</body>
</html>