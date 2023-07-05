<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homero!</title>
</head>
<body>
<h1>アカウント登録</h1>
<form action="/HomeroTest/SignUp"method="post"> //プロジェクト名変更
<input type="text"name=userId placeholder="User ID"required><br>
<input type="password"name=pass placeholder="Password"required><br>
<input type="password"name=confirmPass placeholder="Confirm Password"required><br>
<% String errorMsg = (String)request.getAttribute("errorMsg"); %>
<% if(errorMsg != null){ %>
	<p style="color:red;">
	<%= errorMsg %></p>
<%} %>
<input type="submit"value="アカウント登録"><br>
</form>
<a href="/HomeroTest/index.jsp">キャンセル</a>　//プロジェクト名変更
</body>
</html>