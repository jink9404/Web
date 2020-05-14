<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 </title>
</head>

<body>

	<form action="saveMessage.jsp" name="frm" method="post">
		이름 : <input type="text" name="guestName" pattern="[0-9a-zA-Z가-힣]{2,5}" title="2자이상 5자 이하"  required /><br/><br/>
		암호 : <input type="password" name="password" pattern="^[0-9a-zA-Z]([0-9a-zA-Z])*" title="특수문자 사용금지" required /><br/><br/>
		메세지 : <textarea name="message" rows="3" cols="30" required></textarea><br/><br/>
		<input type="submit" value="메세지 남기기">
	</form>
</body>
</html>