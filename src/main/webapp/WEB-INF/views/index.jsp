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

    <script src="/js/script.js"></script>
</head>
<body>
    <div class="container">
        <h1 class="page-header">
            Employees
            <span class="pull-right">
                <span class="user">${user.principal.username}</span>
                <a href="/logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a>
            </span>
        </h1>
        <div class="container-fluid controls-bar">
            <div class="row">
                <div class="text-right">
                    <a href="/employee/edit" class="btn btn-default edit">New</a>
                </div>
            </div>
        </div>
        <div id="employeeContainer"></div>
    </div>

    <div class="modal fade modal-md" role="dialog" id="employeeEditModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Employee</h4>
                </div>
                <div class="modal-body">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary">Save changes</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

</body>
</html>