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
        <h1>Velkommen til Polygon</h1>
        <h2>Login</h2>
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
            <br><br>
            Indtast firma ID: <br> <input type="text" name="firmID" />
            <br> <br>
            <input type="hidden" name="do_this" value="CheckLogin" />
            <input type="submit" value="Login" name="CheckLogin" />
            <br>
            <br>
        </form>
        <% if (request.getAttribute("doExists") != null && request.getAttribute("doExists").equals(false))
            {%>
        Dette login eksisterer ikke. Tjek eventuelt også for manglende indtastning af oplysninger.
        <%
                request.setAttribute("doExists", true);
            }%>
        <br>
        <br>
        <form action="ControllerServlet" method="POST">
            <input type="hidden" name="do_this" value="CreateLogin" />
            <input type="submit" value="Opret ny bruger" name="CreateLogin" />
        </form>

    </body>
</html>
