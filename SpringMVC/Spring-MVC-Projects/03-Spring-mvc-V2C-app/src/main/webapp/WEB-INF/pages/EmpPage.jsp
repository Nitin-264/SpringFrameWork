<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>
      <!-- toString() called -->
      <h1>Employee Details ::${obj }</h1>
      
      <hr>

	<!-- Getter methods will be called -->
	<p>ID     is :: ${obj.empId}</p>
	<p>NAME   is :: ${obj.empName}</p>
	<p>SALARY is :: ${obj.empSal}</p>
</body>
</html>