<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Time</title>
    </head>
    <body>
        <p><a href="index.jsp">main page</a></p>
        <jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>
        Directive
        <%@ include file="fragment_time.jsp" %>
        <br/>
        Action-tag
        <jsp:include page="fragment_time.jsp"/>
    </body>
</html>