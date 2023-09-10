<%-- 
    Document   : header
    Created on : Sep 7, 2023, 10:14:23 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="action" />
<!DOCTYPE html>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${action}?page=1">Job Introduction</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${action}?page=1">Home</a>
                </li>
                <c:forEach items="${em}" var="e">
                    <c:url value="/" var="searchUrl">
                        <c:param name="emTypeId" value="${e.id}"></c:param>
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${searchUrl}">${e.employment}</a>
                    </li>
                </c:forEach>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link" name="username" href="${action}?username=${pageContext.request.userPrincipal.name}">
                                ${pageContext.request.userPrincipal.name}
                            </a>
                            <!--                            <a class="nav-link" name="username" value="${pageContext.request.userPrincipal.name}" />${pageContext.request.userPrincipal.name}</a>-->
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login" />">Đăng xuất</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login" />">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/register" />">Đăng ký</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <form class="d-flex mt-2" action="${action}" >
                <input class="form-control me-2" type="text" name="key" placeholder="Nhập từ khóa...">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </form>
        </div>
    </div>
</nav>
