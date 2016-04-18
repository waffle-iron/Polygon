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
        <style>
            table#t01 {
                width:100%;
                position: fixed; bottom: 0;
            }

            th {
                padding: 5px;
                text-align: left;
            }
            table#t01 th	{
                background-color: rgb(0,159,227);
                color: white;
            }
        </style>
    </head>
    <body>

        <form action="ControllerServlet" method="get">
            <ul>

                <input type ="hidden" value="goToAddBuilding" name="do_this">
                <li></li>
            </ul>
        </form>
        <img src="sundeByg.png" alt="Polygon" style="width:255px;height:80px;" style="float:left">

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
        <div class="footer">
            <table id="t01">
                <tr>
                    <th>Kontakt Polygon på tlf: 11111111</th>
                    <th>E-mail: Polygon@mail.dk</th>
                    <th>Akut hjælp: 112</th>
                </tr>
            </table>
        </div>
    </body>
</html> 
