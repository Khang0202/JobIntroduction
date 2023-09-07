<%-- 
    Document   : index
    Created on : Aug 26, 2023, 9:10:09 PM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/" var="action" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Job Introduction</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav">
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
                    </div>
                </div>
            </nav>
        </nav>

        <div class="container mt-4">
            <c:if test="${counter > 1}">
                <ul class="pagination mt-1">
                    <li class="page-item"><a class="page-link" href="<c:url value="/" />">Tất cả</a></li>
                        <c:forEach begin="1" end="${counter}" var="i">
                            <c:url value="/" var="pageUrl">
                                <c:param name="page" value="${i}"></c:param>
                            </c:url>
                        <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                        </c:forEach>
                </ul>
            </c:if>
            <h2>Jobs list</h2>          
            <table class="table">
                <thead>
                    <tr>
                        <th style="width: 40px">id</th>
                        <th style="width: 120px">Poster</th>
                        <th style="width: 600px">Title</th>
                        <th style="width: 420px">Company</th>
                        <th style="width: 180px"></th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${job}" var="j">
                        <tr>
                            <td>${j.id}</td>
                            <td>${j.posterName}</td>
                            <td>${j.name}</td>
                            <td>${j.company}</td>
                            <td>
                                <a href="#" class="btn btn-success">Info</a>
                                <button class="btn btn-danger">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </body>
</html>
