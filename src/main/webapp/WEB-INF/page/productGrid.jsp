<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Catalog</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/resource/bootstrap/css/bootstrap.min.css'/>">
    
    <!-- jQuery & Bootstrap JS -->
    <script src="<c:url value='/resource/js/jquery.js'/>"></script>
    <script src="<c:url value='/resource/bootstrap/js/bootstrap.min.js'/>"></script>

    <!-- External CSS & Font -->
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

    <style>
        body, h1, h2, h3, h4, h5 {
            font-family: "Raleway", sans-serif;
        }
        .w3-sidenav a, .w3-sidenav h4 {
            font-weight: bold;
        }
        .w3-container {
            padding: 15px;
        }
        .product-card {
            margin-bottom: 30px;
        }
        .product-img {
            width: 100%;
            transition: 0.3s;
        }
        .product-img:hover {
            opacity: 0.7;
        }
    </style>
</head>
<body>

    <hr>

    <!-- Product Display Section -->
    <div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">

        <!-- Product 1 -->
        <div class="w3-third w3-container product-card">
            <img src="<c:url value='/resource/images/products/two.jpg'/>" alt="Oppo A37" class="product-img">
            <div class="w3-container w3-white">
                <h4><b>Oppo A37</b></h4>
                <ul>
                    <li>Technology: GSM/HSPA/LTE</li>
                    <li>Resolution: 720x1280 pixels</li>
                    <li>OS: Android OS, v5.1 (Lollipop)</li>
                    <li>Price: 10,000.00</li>
                </ul>
            </div>
        </div>

        <!-- Product 2 -->
        <div class="w3-third w3-container product-card">
            <img src="<c:url value='/resource/images/products/seven.jpg'/>" alt="Oppo A53" class="product-img">
            <div class="w3-container w3-white">
                <h4><b>Oppo A53</b></h4>
                <ul>
                    <li>Technology: GSM/HSPA/LTE</li>
                    <li>Resolution: 720x1280 pixels</li>
                    <li>OS: Android OS, v5.1 (Lollipop)</li>
                    <li>Price: 8,000.00</li>
                </ul>
            </div>
        </div>

        <!-- Product 3 -->
        <div class="w3-third w3-container product-card">
            <img src="<c:url value='/resource/images/products/five.jpg'/>" alt="Oppo F1s" class="product-img">
            <div class="w3-container w3-white">
                <h4><b>Oppo F1s</b></h4>
                <ul>
                    <li>Technology: GSM/HSPA/LTE</li>
                    <li>Resolution: 720x1280 pixels</li>
                    <li>OS: Android OS, v5.1 (Lollipop)</li>
                    <li>Price: 18,000.00</li>
                </ul>
            </div>
        </div>
    </div>

    <hr>

    <!-- Additional Product Section -->
    <div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
        
        <!-- Product 4 -->
        <div class="w3-third w3-container product-card">
            <img src="<c:url value='/resource/images/products/five.jpg'/>" alt="Oppo F1s" class="product-img">
            <div class="w3-container w3-white">
                <h4><b>Oppo F1s</b></h4>
                <ul>
                    <li>Technology: GSM/HSPA/LTE</li>
                    <li>Resolution: 720x1280 pixels</li>
                    <li>OS: Android OS, v5.1 (Lollipop)</li>
                    <li>Price: 18,000.00</li>
                </ul>
            </div>
        </div>

        <!-- Product 5 -->
        <div class="w3-third w3-container product-card">
            <img src="<c:url value='/resource/images/products/1.jpg'/>" alt="Oppo A53" class="product-img">
            <div class="w3-container w3-white">
                <h4><b>Oppo A53</b></h4>
                <ul>
                    <li>Technology: GSM/HSPA/LTE</li>
                    <li>Resolution: 720x1280 pixels</li>
                    <li>OS: Android OS, v5.1 (Lollipop)</li>
                    <li>Price: 8,000.00</li>
                </ul>
            </div>
        </div>

        <!-- Product 6 -->
        <div class="w3-third w3-container product-card">
            <img src="<c:url value='/resource/images/products/4.jpg'/>" alt="Oppo A37" class="product-img">
            <div class="w3-container w3-white">
                <h4><b>Oppo A37</b></h4>
                <ul>
                    <li>Technology: GSM/HSPA/LTE</li>
                    <li>Resolution: 720x1280 pixels</li>
                    <li>OS: Android OS, v5.1 (Lollipop)</li>
                    <li>Price: 10,000.00</li>
                </ul>
            </div>
        </div>
    </div>

</body>
</html>
