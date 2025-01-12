<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ShopIeasy</title>
    <link rel="icon" type="image/x-icon" href="<c:url value='/resource/images/favicon1.png'/>" />
</head>
<body>
    <!-- Include navigation bar -->
    <%@ include file="/WEB-INF/page/navbar.jsp"%> 

    <!-- Include slider -->
    <%@ include file="/WEB-INF/page/slider.jsp"%>

    <!-- Include product grid -->
    <%@ include file="/WEB-INF/page/productGrid.jsp"%> 

    <!-- Include footer -->
    <%@ include file="/WEB-INF/page/footer.jsp"%> 
</body>
</html>
