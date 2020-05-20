<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--     directive tag
		page / inclue / taglib -->
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1_basic.jsp</title>
</head>
<body>
<c:set var='gender' value='male'/>

<c:if test="${gender eq 'male' }"> 남자</c:if>
<c:if test="${gender eq 'female' }"> 여자</c:if>
<c:set var='age'>1</c:set>
<c:if test="${age ge 20 }">성인</c:if>

<c:choose>
	<c:when test="${ age lt 10 }">어린이</c:when>
	<c:when test="${ age lt 20 and age ge 10 }">청소년</c:when>
	<c:otherwise>어른</c:otherwise>
</c:choose>

<c:forEach var='i' begin='1' end='100'>
	<c:set var='sum' value='${ sum+i}'/>
</c:forEach>
1~100 까지 합 : ${sum}<br/>

<c:forEach var='i' begin='1' end='100'>
	<c:if test="${i mod 2 eq 0 }">
		<c:set var='even_sum' value='${ even_sum+i}'/>
	</c:if>
</c:forEach>
1~100 까지 짝수 합 : ${even_sum}<br/>

<c:forEach var='i' begin='1' end='100'> <%-- JSP 주석입니다. --%>
	<c:if test="${i mod 2 eq 1 }">
		<c:set var='odd_sum' value='${ odd_sum+i}'/>
	</c:if>
</c:forEach>
1~100 까지 짝수 합 : ${odd_sum}<br/>

</body>
</html>