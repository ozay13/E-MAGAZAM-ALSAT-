<%-- 
    Document   : home
    Created on : Sep 9, 2017, 1:29:10 PM
    Author     : ozaytunctan13
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="f" uri="http://www.springframework.org/tags/form" %> 
<%@taglib  prefix="ftmt" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <table border="1">
                <h1><c:out value="${message}"/></h1>
                <a href="product">Urun ekle</a>
               
        </div>

    </body>
</html>
