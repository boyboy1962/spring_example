<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>${student.id}</th>
		</tr>
		<tr>
			<th>이름</th>
			<th>${student.name}</th>
		</tr>
		<tr>
			<th>휴대폰 번호</th>
			<th>${student.phoneNumber}</th>
		</tr>
		<tr>
			<th>이메일</th>
			<th>${student.email}</th>
		</tr>
		<tr>
			<th>장래희망</th>
			<th>${student.dreamJob}</th>
		</tr>
		<tr>
			<th>생성일</th>
			<th>${student.createdAt}</th>
		</tr>
	</table>
</body>
</html>