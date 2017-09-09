<%-- 
    Document   : home
    Created on : Sep 9, 2017, 1:29:10 PM
    Author     : ozaytunctan13
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
        <table border="1">
            <h1><c:out value="${message}"/></h1>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.id}&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>${p.productName}&nbsp;&nbsp;&nbsp;</td>
                <td>${p.categoryId}&nbsp;&nbsp;&nbsp;</td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
