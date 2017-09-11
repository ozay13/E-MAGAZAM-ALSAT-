<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="App" lang="en">
    <head  >
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
        <script src="<c:url value='/resources/angularjs/app.js'/>"></script>
        <style>
            #container{
                width: 500px;
                margin: 100px auto;
            }
        </style>
    </head>
    <body>
       
        <div ng-controller ="DivController" id="container">
            <ul>
                <li ng-repeat="k in kullanicilar">
                    {{k}}
                </li>
            </ul>
        </div>


    </body>
</html>
