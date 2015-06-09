<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Index</title>
    </head>
    <body>
        <p><a href="sessionServlet">Session Attribute</a></p>
        <p><a href="timeoutservlet">Time out Servlet</a></p>
        <p><a href="jsp/maincookie.jsp">Main cookie (PageRedirectSecurityFilter does not allow to go)</a></p>
        Кодировка запроса(filter): ${pageContext.request.characterEncoding}
    </body>
</html>