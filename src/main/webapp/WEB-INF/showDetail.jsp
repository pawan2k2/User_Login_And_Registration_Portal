<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hii  ${user.getName()}</h1>
<h4>Age : ${user.getAge()}</h4>
<h4>City : ${user.getCity()}</h4>
<h4>Father Name : ${user.getFname()}</h4>
<h4>Mother Name : ${user.getMname()}</h4>
</body>
</html>