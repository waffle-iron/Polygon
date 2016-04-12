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
        
            <ul>

                <li> <input type="submit" class="submit1" value="Tilføj bygning" />
                    <input type='hidden' name='do_this' value='createBuild'/></li>
                <li> <input type="submit" class="submit1" value="Vis rapport" />  </li>
                <li><input type="submit" class="submit1" value="Vis rapport" /></li>
                <li><input type="submit" class="submit1" value="Vis rapport" /></li>
                <li style="float:right"><a href="#about">About</a></li>
            </ul>
        



        <h1>Velkommen til Polygon</h1>
        <h2>Login</h2>
        <form action="ControllerServlet" method="get">
            Brugernavn<br> <input style="text-align: center" type="text" name="username" value="test" size="20" />
            <br><br>
            Kodeord<br> <input style="text-align: center" type="password" name="password" value="test" size="20" />
            <input type="hidden" name="do_this" value="CheckLogin" />
            <br>
            <input type="submit" value="Login" name="CheckLogin" />
        </form>
        <% if (request.getAttribute("doExists") != null && request.getAttribute("doExists").equals(false))
            {%>
        Dette login eksisterer ikke. Tjek eventuelt også for manglende indtastning af oplysninger.
        <%
                request.setAttribute("doExists", true);
            }%>
        <br>
        <br>
    </body>
</html>
