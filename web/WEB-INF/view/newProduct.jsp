<%-- 
    Document   : newProduct
    Created on : Sep 10, 2017, 12:11:17 PM
    Author     : ozaytunctan13
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/style.css"/>
    </head>
    <body>
        <div>
            <div id="content">

                <f:form action="newProduct" commandName="product" method="POST"  >    
                    <table>
                        <tr>
                            <td> <f:hidden path="id"/></td> 
                        </tr>
                        <tr>
                            <td> <f:label path="productName" >Ürün Adı:</f:label></td> 
                            <td> <f:input path="productName" id="productName" /></td>
                            <td> <f:errors path="productName" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td> <f:label path="categoryId" >Kategori Seciniz:</f:label></td> 
                            <td> <f:select items="${categoryList}"  path="categoryId" id="categoryId" />
                            </td>
                            <td> <f:errors path="categoryId"  cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td> <f:label path="brandId" >Marka Seciniz:</f:label></td> 
                            <td> <f:select items="${brandList}"  path="brandId" id="brandId" />
                            </td>
                            <td> <f:errors path="brandId"  cssClass="error"/></td>
                        </tr>


                        <tr>
                            <td> <f:label path="creationDate" >Oluşturma Tarihi:</f:label></td> 
                            <td> <f:input path="creationDate" value="01/01/2000" id="creationDate" /></td>
                            <td> <f:errors path="creationDate" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td></td>
                        </tr>
                        <tr>                              
                            <td></td>
                            <td colspan="2">
                                <f:input type="submit" path="" name="action" value="Kaydet" />
                                <f:input type="submit" path=""  name="action" value="Vazgec" />
                            </td>
                        </tr>

                    </table>  

                </f:form>
            </div>
        </div>
        <div>
            <div>
                <table border="1">
                    <c:forEach items="${productList}" var="p">
                        <tr>
                        <tr>
                            <th>Urun Ad</th>
                            <th>Kategori Id</th>
                            <th>Marka</th>
                            <th>Oluşturma Tarih</th>
                            <th>Değiştirme Tarih</th>
                        </tr>
                        <td><c:out value="${p.productName}"/></td>
                        <td><c:out value="${p.categoryId}"/></td>
                        <td><c:out value="${p.brandId}"/></td>
                        <td><c:out value="${p.creationDate}"/></td>
                        <td><c:out value="${p.modifiedDate}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
