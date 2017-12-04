<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${!empty errors}">
    <div class="row">
        <ul class="col-sm-offset-3">
            <c:forEach var="error" items="${errors}">
                <li class="text-danger">${error}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>
<form class="form-horizontal" action="/employee" method="post">
    <input type="hidden" name="id" value="${employee.id}">
    <div class="form-group">
        <label for="name" class="col-sm-3 control-label">Employee Name:</label>
        <div class="col-sm-9">
            <input type="text" class="form-control"
                   id="name" name="name"
                   placeholder="Employee Name" value="${employee.name}"/>
        </div>
    </div>
    <div class="form-group">
        <label for="gender" class="col-sm-3 control-label">Gender:</label>
        <div class="col-sm-9">
            <select class="form-control" id="gender" name="gender" placeholder="Employee Name">
                <option value="M" ${employee.gender=="M" ? "selected" : ""}>Male</option>
                <option value="F" ${employee.gender=="F" ? "selected" : ""}>Female</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="birthDate" class="col-sm-3 control-label">Birth Date:</label>
        <div class="col-sm-9">
            <fmt:formatDate value="${employee.birthDate}"
                            type="date"
                            pattern="yyyy-MM-dd"
                            var="birthDate" />
            <input type="text" class="form-control" id="birthDate" name="birthDate" placeholder="yyyy-mm-dd"
                   value="${birthDate}"/>
        </div>
    </div>
    <div class="form-group">
        <label for="hireDate" class="col-sm-3 control-label">Hire Date:</label>
        <div class="col-sm-9">
            <fmt:formatDate value="${employee.hireDate}"
                            type="date"
                            pattern="yyyy-MM-dd"
                            var="hireDate" />
            <input type="text" class="form-control" id="hireDate" name="hireDate" placeholder="yyyy-mm-dd"
                   value="${hireDate}"/>
        </div>
    </div>
    <div class="form-group">
        <label for="departmentId" class="col-sm-3 control-label">Department:</label>
        <div class="col-sm-9">
            <select class="form-control" id="departmentId" name="departmentId">
                <c:forEach var="department" items="${departments}">
                    <option value="${department.id}"
                            ${((department.id == employee.department.id) || (department.id == departmentId)) ? "selected": ""}>
                    ${department.name}
                    </option>
                </c:forEach>
            </select>
        </div>
    </div>
</form>
