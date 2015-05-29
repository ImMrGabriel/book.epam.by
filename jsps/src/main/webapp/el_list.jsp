<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>List</title>
    </head>
    <body>
        <p><a href="index.jsp">main page</a></p>
        Элемент списка: ${lst[0]} <br/>
        Значение поля элемента списка: ${lst[0].text} <br/>
        Весь список: ${lst}
    </body>
</html>