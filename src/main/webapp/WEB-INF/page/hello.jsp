<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <!-- Bootstrap CSS link -->
    <link rel="stylesheet" href="<c:url value='../../resource/bootstrap/css/bootstrap.min.css'/>">
</head>
<body>
    <!-- Display hello variable (ensure it's set in the controller or request scope) -->
    ${hello}
</body>
</html>
