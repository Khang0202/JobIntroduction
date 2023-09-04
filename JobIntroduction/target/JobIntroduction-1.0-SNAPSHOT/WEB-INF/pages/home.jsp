<%-- 
    Document   : index
    Created on : Aug 26, 2023, 9:10:09 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello</h1>
        <ul>
            <c:forEach items="${faculty}" var="f">
                <li>${f.id} - ${f.role}</li>
            </c:forEach>
        </ul>
    </body>
</html>
