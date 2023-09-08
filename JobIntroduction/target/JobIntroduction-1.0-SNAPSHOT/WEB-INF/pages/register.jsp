<%-- 
    Document   : register
    Created on : Sep 8, 2023, 1:53:52 PM
    Author     : nguye
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center mt-1">ĐĂNG KÝ</h1>

<c:url value="/register" var="action" />
<form:form method="post" action="${action}" 
           modelAttribute="user" acceptCharset="UTF-8"
           enctype="multipart/form-data">
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="firstName" id="firstName"/>
        <label for="firstName">Tên</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="lastName" id="lastName"/>
        <label for="lastName">Họ</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="email" id="email"/>
        <label for="email">Email</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="sex" id="sex"/>
        <label for="sex">Giới tính</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="phone" id="phone"/>
        <label for="phone">Số điện thoại liên hệ</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="username" id="username"/>
        <label for="username">username</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="date" class="form-control" path="birthform" id="birthform"/>
        <label for="birthform">Ngày sinh</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="password" id="password"/>
        <label for="password">Mật khẩu</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control" path="file" id="file"/>
        <label for="file">Email</label>
    </div>
    <div class="form-floating mb-3 mt-3 text-center">
        <button class="btn btn-info" type="submit">Đăng ký
        </button>
    </div>
</form:form>
