<%-- 
    Document   : FrontPageJSP
    Created on : Apr 12, 2016, 9:18:43 AM
    Author     : peter L Lange
--%>

<%@page import="Domain.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="General.css">
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">
        <title>Forside</title>

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
                <li><input type="submit" id="goBack" value="Forside" name="goToFrontPage" class="submit1"/></li>
                    <%
                        Login login = (Login) session.getAttribute("login");
                        System.out.println(login.getAuthorization());
                    %>

                <%if (login.getAuthorization().equals("user"))
                    { %>


                <li> <input class="submit1" type="submit" name ="button" value="Opret bygning"></li>

                <li> <input class="submit1" type="submit" name="button" value="Opret nyt login"></li>

                <%}%>

                <%if (login.getAuthorization().equals("admin"))
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
        <img src="Poly-logo.png" alt="Polygon" style="width:200px;height:35px;" style="float:left">
        <div class="content">


            NYI - NewsFeed
            <%if (login.getAuthorization().equals("user"))
                { %>
            der fortæller om: husk at gemme en floorplan, en rapport er skrevet om en af dine bygninger, en af dine bygninger har fået ændret sin status, en af dine bygningers rapport er blevet opdateret og kommende inspektioner af dine bygninger
            <%}%>
            <%if (login.getAuthorization().equals("tech"))
                { %>
            der fortæller om fremtidige tjek ups du skal være med til, og om der er sket opdateringer på dine rapports
            <%}%>
            <%if (login.getAuthorization().equals("admin"))
                { %>
            der fortæller folk har ansøgt efter tjek up, fremtidige tjek up dage, user uploaded 
            <%}%>
            <%if (login.getAuthorization().equals("admin"))
                { %>
            der fortæller folk har ansøgt efter tjek up, fremtidige tjek up dage, user uploaded 
            <%}%>
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
