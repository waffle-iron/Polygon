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
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Login login = (Login) session.getAttribute("login");
            System.out.println(login.getAuthorization());
        %>

        <%if (login.getAuthorization().equals("user"))
            { %>
        <form action="ControllerServlet" method="get">
            <input type ="hidden" value="goToAddBuilding" name="do_this">
            <input type="submit" name ="button" value="tilføj bygning">
        </form>

        <form action="ControllerServlet" method="get">
            <input type ="hidden" value="goToCreateLogin" name="do_this">
            <input type="submit" name ="button" value="Opret nyt login">
        </form>
        <%}%>

        <%if (login.getAuthorization().equals("admin"))
            { %>
        <form action="ControllerServlet" method="get">
            <input type ="hidden" value="goToFirm" name="do_this">
            <input type="submit" name ="button" value="Opret nyt firma">
        </form>

        <form action="ControllerServlet" method="get">
            <input type ="hidden" value="goToCreateLogin" name="do_this">
            <input type="submit" name ="button" value="Opret nyt login">
        </form>

        <form action="ControllerServlet" method="get">
            <input type ="hidden" value="goToViewFirms" name="do_this">
            <input type="submit" name ="button" value="Vis alle firmaer">
        </form>

        <%}%>


        <form action="ControllerServlet" method="get">
            <input type ="hidden" value="goToViewMyBuildings" name="do_this">
            <input type="submit" name ="button" value="mine bygninger NYI">
        </form>

        <form action="ControllerServlet" method="GET">

            <input type="submit" value="repport (DENNE ER KUN TEMPEARY)" name="createReport" />
            <input type="hidden" name="do_this" value="Report">
        </form>
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
    </body>
</html>
