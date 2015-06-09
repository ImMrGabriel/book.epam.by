<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Session Attribute</title>
    </head>
    <body>

        <p><a href="${pageContext.request.contextPath}/index.jsp">Back to index</a></p>
        ${messages}
        <br/>
        <a href="timeoutservlet">Back to Servlet</a>
    </body>
</html>