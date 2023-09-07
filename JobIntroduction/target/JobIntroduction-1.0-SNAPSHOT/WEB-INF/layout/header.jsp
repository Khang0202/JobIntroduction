<%-- 
    Document   : header
    Created on : Sep 7, 2023, 10:14:23 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${action}">Job Introduction</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${action}">Home</a>
                </li>
                <c:forEach items="${em}" var="e">
                    <c:url value="/" var="searchUrl">
                        <c:param name="emTypeId" value="${e.id}"></c:param>
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${searchUrl}">${e.employment}</a>
                    </li>
                </c:forEach>
            </ul>
            <form class="d-flex mt-2" action="${action}" >
                <input class="form-control me-2" type="text" name="key" placeholder="Nhập từ khóa...">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </form>
        </div>
    </div>
</nav>
