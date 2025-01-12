<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="icon" type="image/x-icon" href="<c:url value='/resource/images/favicon1.png'/>" />
    <link rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
    <script src="<c:url value='/js/jquery-3.1.0.min.js'/>"></script>
    <script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css'/>">
    <style type="text/css">
        @media (min-width: 1200px) {
            .container {
                width: 1300px;
            }
        }

        @media (min-width: 992px) {
            .col-md-4 {
                margin-left: 330px;
            }
        }
    </style>
</head>
<body>
    <%@ include file="navbar.jsp"%>
    <div class="container" style="margin-top: 30px; margin-bottom: 180px;">
        <div class="col-md-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" align="center">Sign In</h3>
                </div>
                <div class="panel-body">
                    <!-- Success or error messages -->
                    <c:if test="${!empty querySuccess}">
                        <div class="alert alert-danger">${querySuccess}</div>
                    </c:if>

                    <c:if test="${not empty registrationSuccess}">
                        <div class="alert alert-danger">${registrationSuccess}</div>
                    </c:if>

                    <c:if test="${not empty logout}">
                        <div class="alert alert-danger">${logout}</div>
                    </c:if>

                    <form name="login" action="<c:url value='/login'/>" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="E-mail" name="username" type="text" required>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" type="password" required>
                            </div>
                            <div class="checkbox">
                                <c:if test="${not empty error}">
                                    <div class="alert alert-danger">${error}</div>
                                </c:if>
                            </div>
                            <div id="button">
                                <button type="submit" class="btn btn-sm btn-success" style="margin-right: 79px; margin-left: 60px">
                                    Login
                                </button>
                                <a href="<c:url value='/customer/registration'/>" class="btn btn-sm btn-success">
                                    Register
                                </a>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp"%>
</body>
</html>
