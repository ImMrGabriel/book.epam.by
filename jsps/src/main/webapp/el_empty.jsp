<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>Operator empty</title>
    </head>
    <body>
        <p><a href="index.jsp">main page</a></p>
        <jsp:useBean id="mess" scope="page" class="bean.Message"/>
        Message is not valid: ${not empty mess and empty mess.text}
    </body>
</html>