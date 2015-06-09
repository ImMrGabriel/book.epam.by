<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Session Attribute</title>
    </head>
    <body>
        Role: ${role}
        <br/><hr/>
        Counter: ${counter}
        <br/><hr/>
        MaxInactiveInterval: ${pageContext.session.maxInactiveInterval}<br/>
        ID session: ${lifecycle}<br/>
        <p><a href="${pageContext.request.contextPath}/index.jsp">Back to index</a></p>
    </body>
</html>