<%-- 
    Document   : register
    Created on : Oct 23, 2021, 8:49:56 PM
    Author     : 792268
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <div>
            <form action="ShoppingList" method="post">
                Username: <input type="text" name="username" value="">                
                <input type="hidden" name="action" value="register">
                <input type="submit" value="Register">
            </form>
        </div>
    </body>
</html>
