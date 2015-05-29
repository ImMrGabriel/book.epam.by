<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>JSP page</title>
    </head>
    <body>
        <p><a href="index.jsp">main page</a></p>
        <jsp:useBean id="mess" class="bean.Message" scope="request" />

        <p><jsp:getProperty name="mess" property="class"/></p>
        <p>Default Message : {<jsp:getProperty name="mess" property="id"/>,
            <jsp:getProperty name="mess" property="text"/>}</p>

        <jsp:setProperty name="mess" property="id" value="2015"/>
        <jsp:setProperty name="mess" property="text" value="is a new year"/>
        <p>Current Message : {<jsp:getProperty name="mess" property="id"/>,
            <jsp:getProperty name="mess" property="text"/>}</p>
        <p>Current ${mess}</p>
        <p>Current Message : {${mess.id}, ${mess.text}}</p>
    </body>
</html>