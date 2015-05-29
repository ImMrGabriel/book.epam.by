<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>EL for parameters</title>
    </head>
    <body>
        <p><a href="index.jsp">main page</a></p>
        <p><a href="el_param.jsp">again</a></p>
        The firstName: ${param.firstName}<br/>
        e-mail 1  : ${param.mail}<br/>
        e-mail 1  : ${paramValues.mail[0]}<br/>
        e-mail 2  : ${paramValues.mail[1]}
    </body>
</html>