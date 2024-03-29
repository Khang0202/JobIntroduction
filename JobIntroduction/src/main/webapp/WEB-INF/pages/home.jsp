<%-- 
    Document   : index
    Created on : Aug 26, 2023, 9:10:09 PM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/" var="action" />
<section class="container">
    <div class="container mt-4">
        <h1 class="text-center mt-1">DANH SÁCH TIN TUYỂN DỤNG</h1>
        <a href="<c:url value="/job" />" class="btn btn-info mb-3">Thêm tin tuyển dụng</a>
        <c:if test="${counter > 1}">
            <ul class="pagination mt-1">
                <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
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
                    <th style="width: 280px">Company</th>
                    <th style="width: 600px">Title</th>
                    <th style="width: 120px">Poster</th>
                    <th style="width: 180px"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${job}" var="j">
                    <tr>
                        <td>${j.company}</td>
                        <td>${j.name}</td>
                        <td>${j.posterName}</td>
                        <td>
                            <c:url value="api/job/deleteJob/${j.id}" var="apiDel" />
                            <a href="${action}job/${j.id}" class="btn btn-success">Info</a>
                            <a class="btn btn-danger" onclick="delJob('${apiDel}', ${j.id})">Delete</a>
                            <script>
                                function delJob(path, id) {
                                    console.log(path);
                                    if (confirm("Bạn chắc chắn xóa không?") === true) {
                                        fetch(path, {
                                            method: "delete"
                                        }).then(res => {
                                            if (res.status === 204)
                                                location.reload();
                                            else
                                                alert("Something wrong!!!");
                                        });
                                    }
                                }
                            </script>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<script src="<c:url value="/resources/js/main.js" />"></script>