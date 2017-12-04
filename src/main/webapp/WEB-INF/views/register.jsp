<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/styles.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js"></script>
</head>
<body>
<div class="container">
    <div class="float-form form-wide panel panel-default">
        <div class="panel-heading"><h3>Register</h3></div>
        <div class="panel-body">
            <c:if test="${!empty errors}">
                <div class="row">
                    <ul class="col-sm-offset-3">
                        <c:forEach var="error" items="${errors}">
                            <li class="text-danger">${error}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <form class="form-horizontal" action="/register" method="post">
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-9">
                        <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${value}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password-confirm" class="col-sm-3 control-label">Confirm Password</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="password-confirm" name="passwordConfirm"
                               placeholder="Confirm Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-primary">Save</button>
                        <a class="register" href="/login">Login</a>
                    </div>
                </div>
            </form>
        </div>
</div>

</body>
</html>