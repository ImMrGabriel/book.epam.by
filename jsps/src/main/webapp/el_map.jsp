<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Map</title>
    </head>
    <body>
        <p><a href="index.jsp">main page</a></p>
        Доступ по прямому значению ключа: ${map.Gabriel} <br/>
        Доступ по ключу: ${map["Jukov"]} <br/>
        Доступ к полю ключа: ${map["Jukov"].id} <br/>
        Вся карта: ${map}
    </body>
</html>