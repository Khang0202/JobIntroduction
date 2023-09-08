<%-- 
    Document   : job
    Created on : Sep 7, 2023, 11:11:05 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center mt-1">ĐĂNG TIN TUYỂN DỤNG</h1>
<form:form method="post" modelAttribute="job">
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="name" id="name" placeholder="Tiêu đề"/>
        <label for="name">Tiêu đề</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="employmentTypeId" name="employmentTypeId" path="employmentTypeId">
            <c:forEach items="${em}" var="c">
                <c:choose>
                    <c:when test="${c.id == job.employmentTypeId.id}">
                        <option value="${c.id}" selected>${c.employment}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.employment}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="employmentTypeId" class="form-label">Vị trí tuyển dụng:</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="salary" id="salary" placeholder="Tiền lương"/>
        <label for="salary">Tiền lương</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:textarea rows="5" class="form-control" path="description" id="description" placeholder="Mô tả công việc"></form:textarea>
            <label for="description">Mô tả công việc</label>
        </div>
        <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="company" id="company" placeholder="Công ty"/>
        <label for="company">Công ty</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="address" id="address" placeholder="Địa chỉ làm việc"/>
        <label for="address">Địa chỉ làm việc</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="phone" id="phone" placeholder="Số điện thoại liên hệ"/>
        <label for="phone">Số điện thoại liên hệ</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="emailcompany" id="emailcompany" placeholder="Email liên hệ"/>
        <label for="emailcompany">Email liên hệ</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="otherinfomation" id="otherinfomation" placeholder="Thông tin khác nếu có"/>
        <label for="otherinfomation">Thông tin khác nếu có</label>
    </div>
    <div class="form-floating mb-3 mt-3 text-center">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${job.id == null}">Thêm sản phẩm</c:when>
                <c:otherwise>Cập nhật sản phẩm</c:otherwise>
            </c:choose>
        </button>
    </div>

</form:form>

