<%-- 
    Document   : shoppingList
    Created on : Oct 23, 2021, 8:50:10 PM
    Author     : 792268
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>

        <div>
            Hello, ${username} <a href="ShoppingList?action=logout">Logout</a>
        </div>

        <div>
            <h2>List</h2>
            <form action="" method="post">
                Add item: <input type="text" name="items" value="${item}">
                <input type="submit" name="addItem" value="Add">
                <input type="hidden" name="action" value="add">
            </form>
        </div>

        <div>
            <form action="shoppingList" method="post">
                <ul>
                    <c:forEach var="item" items="${items}">
                        <li><input type="radio" name="newItem" value="${item}">${item}</li>
                    </c:forEach>

                </ul>
                <input type="submit" value="Delete">
                <input type="hidden" name="action" value="delete">
            </form>
        </div>
    </body>
</html>
