<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Index</title>
    </head>
    <body>
        <h2>Генерация таблиц по переданным параметрам: заголовок, колиство строк и столбцов, цвет фона</h2>
        <form action="task1" method="POST">
            <table>
                <tr>
                    <td>заголовок</td>
                    <td>кол-во строк</td>
                    <td>кол-во столбцов</td>
                    <td>цвет фона</td>
                </tr>
                <tr>
                    <td><input type="text" name="header"/></td>
                    <td><input type="text" name="rows"/></td>
                    <td><input type="text" name="cols"/></td>
                    <td><input type="text" name="color"/></td>
                </tr>
            </table>
            <hr/>
            <input type="submit" value="send">
        </form>
    </body>
</html>