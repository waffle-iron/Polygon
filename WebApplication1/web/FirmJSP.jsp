<%@page import="Domain.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="General.css">
        <link rel="stylesheet" type="text/css" href="ErrorCSS.css">
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">
        <title>Firm</title>

        <style>
            label{
                width:180px;
                clear:left;
                text-align:right;
                padding-right:10px;
            }

            input, label {
                float:left;
                margin-bottom: 5px;
            }
            
            span, label {
                float:left;
                margin-bottom: 5px;
            }

        </style>

    </head>
    <body>
        <form action="ControllerServlet"  method="GET">
            <input type ="hidden" value="useButton" name="do_this">
            <ul>
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

                <li><input class="submit1" type="submit" value="Rapport-midlertidig" name="button" /></li>
                <li style="float:right"><a href="#about">Kontakt</a></li>
                <li style="float:right"><input type="submit" value="Logud" name="button" class="submit1" /></li>

            </ul>
        </form>
        <img src="Poly-logo.png" alt="Polygon" style="width:200px;height:35px;" style="float:left">
        <div class="content">
            <h1>Opret her et nyt firma</h1>
            <% boolean clear = false;
                try
                {
                    if ((Boolean) request.getAttribute("clearAll"))
                    {
                        clear = true;
                    }
                } catch (Exception ex)
                {
                    clear = false;
                }
            %>
            <div class='content'>
                <form action="ControllerServlet" method="GET">

                    <label for="contactN">Kontakt nummer</label>
                    <input type="text" id="contactN" name="contactNumber" pattern="[0-9].{7}"><br>
                    <span title="Kontakt nummer skal bestå af 8 cifre." id="contactN"> </span>

                    <label for="contactM">Kontakt mail: </label>
                    <input type="email" id="contactM" name="contactMail" required>

                    <label for='opret'></label>
                    <input type="hidden" name="do_this" value="createFirm"/>
                    <input type="submit" value="Opret" id="opret" name="createFirm" class="submit2"/>
                </form>
            </div>
            <% if (request.getAttribute("saveFirmInfo") != null && request.getAttribute("saveFirmInfo").equals(true))
                {%>
            Du har nu oprettet et nyt firma.

            <%}%> 
            <form action="ControllerServlet" method="GET">
                <br>
                <label for="goBack"></label>
                <input type="hidden" name="do_this" value="goToFrontPage"/>
                <input type="submit" value="Gå tilbage start siden" name="goToFrontPage" id="goBack" class="submit2" />
            </form>
    </body>
</html>
