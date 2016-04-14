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
        <title>JSP Page</title>

    </head>
    <body>
        <ul>
            <%
                Login login = (Login) session.getAttribute("login");
                System.out.println(login.getAuthorization());
            %>

            <%if (login.getAuthorization().equals("user"))
                { %>

            <input type ="hidden" value="goToAddBuilding" name="do_this">
            <li> <input class="submit1" type="submit" name ="button" value="Tilføj bygning"></li>

            <li> <input class="submit1" type="submit" name ="button" value="Opret nyt login"></li>

            <%}%>

            <%if (login.getAuthorization().equals("admin"))
                { %>

            <li><input class="submit1" type="submit" name ="button" value="Opret nyt firma"></li>

            <li><input class="submit1" type="submit" name ="button" value="Vis alle firmaer"></li>


            <%}%>

            <li><input class="submit1" type="submit" name ="button" value="Opret nyt login"></li>



            <li><input class="submit1" type="submit" name ="button" value="Mine bygninger"></li>

            <li><input class="submit1" type="submit" value="Rapport" name="createReport" /></li>
            <li style="float:right"><a href="#about">Kontakt</a></li>
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
</body>
</html>
