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
            <div id="content">
                <f:form action="newProduct" commandName="product" method="POST">    
                    <table>
                        <tr>
                            <td> <f:hidden path="id"/></td> 
                        </tr>
                        <tr>
                            <td> <f:label path="productName" >Ürün Adı:</f:label></td> 
                            <td> <f:input path="productName" id="productName" /></td>
                            <td> <f:errors id="productName"  /></td>
                        </tr>
                        <tr>
                            <td> <f:label path="productMarka" >Marka:</f:label></td> 
                            <td> <f:input path="productMarka" id="productMarka" /></td>
                            <td> <f:errors id="productMarka"  /></td>
                        </tr>
                        <tr>
                            <td> <f:label path="categoryId" >Kategori:</f:label></td> 
                            <td> <f:input path="categoryId" id="categoryId" /></td>
                            <td> <f:errors id="categoryId"  /></td>
                        </tr>
                        <tr>
                            <td> <f:label path="creationDate" >Tarih:</f:label></td> 
                            <td> <f:input type="date" path="creationDate" id="creationDate" /></td>
                            <td> <f:errors id="creationDate" /></td>
                        </tr>
                        <tr>
                            <td></td>
                        </tr>
                        <tr>                              
                            <td></td>
                            <td colspan="2">
                                <f:button value="ekle" >Ürün Ekle</f:button>
                                <f:button value="vazgec" >Vazgec</f:button>
                            </td>
                            </tr>

                        </table>  

                </f:form>
            </div>
        </div>


        <div>
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
        </div>

    </body>
</html>
