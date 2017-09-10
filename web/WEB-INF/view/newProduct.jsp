<%-- 
    Document   : newProduct
    Created on : Sep 10, 2017, 12:11:17 PM
    Author     : ozaytunctan13
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="f" uri="http://www.springframework.org/tags/form" %>
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
                            <td> <f:label path="brandId" >Marka Seciniz:</f:label></td> 
                            <td> <f:select items="${brandList}"  path="brandId" id="brandId" />
                            </td>
                            <td> <f:errors id="brandId" /></td>
                        </tr>
                        <tr>
                            <td> <f:label path="categoryId" >Kategori Seciniz:</f:label></td> 
                            <td> <f:select items="${categoryList}"  path="categoryId" id="categoryId" />
                            </td>
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
    </body>
</html>
