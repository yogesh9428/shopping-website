<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Image Carousel</title>

    <!-- Link to Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/resource/bootstrap/css/bootstrap.min.css' />">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value='/resource/css/overall.css' />">

    <!-- jQuery and Bootstrap JS -->
    <script src="<c:url value='/resource/js/jquery.js' />"></script>
    <script src="<c:url value='/resource/bootstrap/js/bootstrap.bundle.min.js' />"></script>
</head>

<body>
    <!-- Slider -->
    <div class="jumbotron">
        <div class="container">
            <br>
            <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-bs-target="#carouselExample" data-bs-slide-to="0" class="active"></li>
                    <li data-bs-target="#carouselExample" data-bs-slide-to="1"></li>
                    <li data-bs-target="#carouselExample" data-bs-slide-to="2"></li>
                    <li data-bs-target="#carouselExample" data-bs-slide-to="3"></li>
                    <li data-bs-target="#carouselExample" data-bs-slide-to="4"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="<c:url value='/resource/images/oppo.jpg' />" alt="Image 1" class="d-block w-100" />
                    </div>

                    <div class="carousel-item">
                        <img src="<c:url value='/resource/images/oppo1.jpg' />" alt="Image 2" class="d-block w-100" />
                    </div>

                    <div class="carousel-item">
                        <img src="<c:url value='/resource/images/oppo2.jpg' />" alt="Image 3" class="d-block w-100" />
                    </div>

                    <div class="carousel-item">
                        <img src="<c:url value='/resource/images/oppo3.jpg' />" alt="Image 4" class="d-block w-100" />
                    </div>

                    <div class="carousel-item">
                        <img src="<c:url value='/resource/images/oppo4.png' />" alt="Image 5" class="d-block w-100" />
                    </div>
                </div>

                <!-- Left and right controls -->
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>

</body>

</html>
