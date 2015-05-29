<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>JSP page</title>
    </head>
    <body>
        <p><a href="index.jsp">main page</a></p>
        <h5>
            Путь к контексту : ${pageContext.request.contextPath} <br/>
            Имя хоста : ${header["host"]} <br/>
            Имя хоста : ${header.get("host")} <br/>
            Тип и кодировка контента : ${pageContext.response.contentType} <br/>
            Кодировка ответа : ${pageContext.response.characterEncoding} <br/>
            ID сессии : ${pageContext.request.session.id} <br/>
            Время создания сессии : ${pageContext.request.session.creationTime} <br/>
            Время последнего доступа к сессии : ${pageContext.request.session.lastAccessedTime} <br/>
            Имя сервлета : ${pageContext.servletConfig.servletName}
        </h5>
        Все заголовки : ${header} <br/>
    </body>
</html>