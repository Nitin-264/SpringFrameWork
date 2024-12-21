<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core"	 prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Output</title>
</head>
<body>
<!-- toString() gets called -->
<h1>User Details:: ${obj}</h1>

<!-- Getter methods will be called -->
<p>Id::${obj.userId}</p>
<p>Id::${obj.userName}</p>
<p>Id::${obj.userRole}</p>

     <hr>
	<h1>Iterating the User objects</h1>
	<table border='1'>
	
		<tr>
			<th>UserID</th>
			<th>UserName</th>
			<th>UserRole</th>
		</tr>
		
		<c:forEach items="${objlist}" var="obj">
		<tr>
		    <td>${obj.userId }</td>
		    <td>${obj.userName }</td>
		    <td>${obj.userRole}</td>
		</tr>
		</c:forEach>
		
		
		</table>
</body>
</html>