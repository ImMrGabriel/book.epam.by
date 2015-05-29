<%@page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <title>JSP Timing</title>
    </head>
    <body>
        <h5>Счетчик времени от запуска страницы до нажатия кнопки</h5>
        <jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>    <%-- create a local instance --%>
        <form name="Simple" action="timeaction" method="POST">              <%-- our dir is timing, so @WebServlet("/timing/timeaction") --%>
            <input type="hidden" name="time" value="${calendar.timeInMillis}"/>
            <input type="submit" name="button" value="Посчитать время"/>
        </form>
    </body>
</html>