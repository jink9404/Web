<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8"%>

<%
	// 1. 드라이버 로딩
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2. 연결객체 얻어오기
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.11:1521:orcl","scott","tiger");
	// 3. sql 문장 만들기
	String sql = "SELECT * FROM emp";
	// 4. 전송 객체 얻어오기
	PreparedStatement st = con.prepareStatement(sql);
	// 5. 전송
	ResultSet set = st.executeQuery();
%>


<!DOCTYPE html>
<html><head><title> 디비 테스트 </title>
</head>
<body>
 
<div align=center>
<table border=2 cellSpacing=3>

  <tr class="title">
    <td>사번</td>
    <td>사원명</td>
    <td>업무</td>
    <td>관리자사번</td>
    <td>입사일</td></tr>

<% while(set.next()){ %>
	  <tr>
		<td><%=set.getInt("EMPNO")%></td>
		<td><%=set.getString("ENAME")%></td>
		<td><%=set.getString("JOB")%></td>
		<td><%=set.getInt("MGR")%></td>
		<td><%=set.getString("HIREDATE")%></td>
	  </tr>
<%} //while close %>
<%st.close();
set.close();
con.close(); %>
</table>
</div>
</body>
</html>
