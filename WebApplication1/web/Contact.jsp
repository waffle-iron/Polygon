<%-- 
    Document   : ContactJSP
    Created on : 14-04-2016, 15:10:08
    Author     : LouiseB
--%>

<%@page import="Domain.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="General.css">
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">
        <title>Kontakt</title>
        
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
        <form action="ControllerServlet"  method="GET">
            <input type ="hidden" value="useButton" name="do_this">
            <ul>
                <%
                    Login login = null;
                    if (session.getAttribute("login") != null)
                    {
                        login = (Login) session.getAttribute("login");
                    }
                %>

                <%if (login != null && login.getAuthorization().equals("user"))
                    { %>


                <li> <input class="submit1" type="submit" name ="button" value="Opret bygning"></li>

                <li> <input class="submit1" type="submit" name="button" value="Opret nyt login"></li>

                <%}%>

                <%if (login != null && login.getAuthorization().equals("admin"))
                    { %>

                <li><input class="submit1" type="submit" name ="button" value="Opret nyt firma"></li>

                <li><input class="submit1" type="submit" name ="button" value="Vis alle firmaer"></li>

                <li><input class="submit1" type="submit" name ="button" value="Opret nyt login"></li>
                    <%}%>
                <li><input class="submit1" type="submit" name ="button" value="Mine bygninger"></li>
                <li style="float:right"><input type="submit" value="Logud" name="button" class="submit1" /></li>
                <li style="float:right"><input class="submit1" type="submit" name ="button" value="Kontakt"></li>

            </ul>
        </form>
        <img src="sundeByg.png" alt="Polygon" style="width:255px;height:80px;" style="float:left">
        <h1>Du kan kontakte Polygon på</h1>
        Telefon: 
        <br>
        E-mail:
        <form action="ControllerServlet" method="GET">
            <br>
            <label for="goBack"></label>
            <input type="hidden" name="do_this" value="goToFrontPage"/>
            <input type="submit" value="Gå tilbage start siden" name="goToFrontPage" id="goBack" class="submit2" />
        </form>
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
