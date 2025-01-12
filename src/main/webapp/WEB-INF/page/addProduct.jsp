<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Product</title>
    <link rel="stylesheet" href="<c:url value='/resource/bootstrap/css/bootstrap.min.css' />">
    <script src="<c:url value='/resource/js/jquery.js' />"></script>
    <script src="<c:url value='/resource/bootstrap/js/bootstrap.min.js' />"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/register.css' />">
    <link rel="icon" type="image/x-icon" href="<c:url value='/resource/images/favicon1.png' />">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <div class="container" style="margin-bottom:19px">
        <h1 class="well">Add Product</h1>
        <div class="col-lg-12 well">
            <div class="row">

                <!-- Add Product Form -->
                <c:url value="/admin/product/addProduct" var="url"></c:url>
                <form:form method="post" action="${url}" commandName="productFormObj" enctype="multipart/form-data">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-6 form-group">
                                <form:label path="productId">Product Id</form:label>
                                <form:input type="text" placeholder="Enter Product Id.." class="form-control" path="productId" disabled="true"/>
                            </div>
                            <div class="col-sm-6 form-group">
                                <form:label path="productName">Product Name</form:label>
                                <form:input type="text" placeholder="Enter Product Name.." class="form-control" path="productName"/>
                                <form:errors path="productName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="productDescription">Product Description</form:label>
                            <form:textarea placeholder="Enter Product Description.." class="form-control" path="productDescription"/>
                        </div>
                        <div class="form-group">
                            <form:label path="productCategory">Product Category</form:label>
                            <form:radiobutton path="productCategory" value="Android"/> Android
                            <form:radiobutton path="productCategory" value="Windows"/> Windows
                            <form:radiobutton path="productCategory" value="Linux"/> Linux
                            <form:radiobutton path="productCategory" value="Mac"/> Mac
                        </div>
                        <div class="row">
                            <div class="col-sm-4 form-group">
                                <form:label path="productManufacturer">Product Manufacturer</form:label>
                                <form:input type="text" placeholder="Enter Product Manufacturer.." class="form-control" path="productManufacturer"/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <form:label path="productPrice">Product Price</form:label>
                                <form:input type="text" placeholder="Enter Product Price.." class="form-control" path="productPrice"/>
                                <form:errors path="productPrice"/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <form:label path="unitStock">Number of Products</form:label>
                                <form:input type="text" placeholder="Enter Number of Products.." class="form-control" path="unitStock"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="productImage">Product Image</form:label>
                            <form:input type="file" path="productImage"/>
                        </div>
                        <div class="form-actions">
                            <button type="submit" class="btn btn-lg btn-info">Submit</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>
