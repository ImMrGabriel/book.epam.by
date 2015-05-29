<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>JSP page</title>
    </head>
    <body>
        <p><a href="index.jsp">main page</a></p>
        <h3>Old Style</h3>

        <%!
            private int count = 0;
            String version = new String("1.2");

            private String getName() {
                return "Old Style";
            }
        %>

        <% out.println("Value of count: "); %>
        <%= count++ %>
        <br/>
        <% out.println("Value of count after increment: " + count); %>
        <br/>
        <% out.println("Old value of version: "); %>
        <%= version %>
        <br/>
        <%
            version = getName();
            out.println("New value of version: " + version);
        %>
    </body>
</html>