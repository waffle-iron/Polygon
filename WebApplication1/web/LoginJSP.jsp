<%-- 
    Document   : LoginJSP
    Created on : 01-04-2016, 11:08:05
    Author     : LouiseB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
                    <form action="ControllerServlet" method="POST">
                Brugernavn<br> <input style="text-align: center" type="text" name="username" value="" size="20" />
                <br><br>
                Kodeord<br> <input style="text-align: center" type="password" name="password" value="" size="20" />
            <br><br>
            <select name="Enum">
                <option>Bruger</option>
                <option>Tekniker</option>
                <option>Admin</option>
            </select>
            <p> Indtast firma ID:<input type="text" name="FirmID" /></p>
                <input type="hidden" name="do_this" value="CheckLogin" />
                <input type="submit" value="Login" name="CheckLogin" />
            </form>
    </body>
</html>