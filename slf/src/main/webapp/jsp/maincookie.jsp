<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>from cookie</title>
    </head>
    <body>
    <p><a href="${pageContext.request.contextPath}/index.jsp">Back to index</a></p>
        ${messages}
        <p><a href="cookiecontroller">Messages from cookie</a></p>
    </body>
</html>