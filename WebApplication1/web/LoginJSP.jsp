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
        <link rel="stylesheet" type="text/css" href="General.css">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="ControllerServlet" method="POST">
            Brugernavn<br> <input style="text-align: center" type="text" name="username" value="" size="20" />
            <br><br>
            Kodeord<br> <input style="text-align: center" type="password" name="password" value="" size="20" />
            <br><br>
            <select name="enum">
                <option>Bruger</option>
                <option>Tekniker</option>
                <option>Admin</option>
            </select>

            <p> Indtast firma ID:<input type="text" name="firmID" /></p>

            <input type="hidden" name="do_this" value="CheckLogin" />
            <input type="submit" value="Login" name="CheckLogin" />
            <br>
        </form>
        <form action="ControllerServlet" method="POST">
            <input type="hidden" name="do_this" value="CreateLogin" />
            <input type="submit" value="Opret ny bruger" name="CreateLogin" />
        </form>

    </body>
</html>
