<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
헬로헬로
<c:url var="insertUrl" value="/memberinsert"/>
<form:form commandName="memberVO" action="${insertUrl}" name="MemberVO" method="post">
	아이디 <form:input path="member_id" id="member_id" autocomplete="off" style="width:100"/><br>
	벼열명 <form:input path="member_nickname" id="member_nickname" autocomplete="off" style="width:100"/><br>
	비이번 <form:input path="member_password" id="member_password" autocomplete="off" style="width:100"/><br>
	<input type="submit" value="저언송"/>
</form:form>
</body>
</html>