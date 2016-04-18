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
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">
        <title>Login</title>

    </head>
    <body>
        <form action="ControllerServlet" method="get">
            <ul>

                <input type ="hidden" value="goToAddBuilding" name="do_this">
                <li style="float:right"><input class="submit1" type="submit" name ="button" value="Kontakt"></li>
            </ul>
        </form>
        <img src="Poly-logo.png" alt="Polygon" style="width:200px;height:35px;" style="float:left">

        <div class="content">
            <h1>Velkommen til Polygon</h1>
            <h2>Login</h2>
            <form action="ControllerServlet" method="get">
                Brugernavn<br> <input style="text-align: center" type="text" name="username" size="20" />
                <br><br>
                Kodeord<br> <input style="text-align: center" type="password" name="password" size="20" />
                <input type="hidden" name="do_this" value="CheckLogin" />
                <br>
                <br>
                <input type="submit" value="Login" name="CheckLogin" class="submit2"/>
            </form>
            <% if (request.getAttribute("doExists") != null && request.getAttribute("doExists").equals(false))
                {%>
            Dette login eksisterer ikke. Tjek eventuelt også for manglende indtastning af oplysninger.
            <%
                    request.setAttribute("doExists", true);
                }%>
            <br>
            <br>
        </div>
    </body>
</html> 
