<%-- 
    Document   : ViewFirms
    Created on : 14-04-2016, 10:23:25
    Author     : LouiseB
--%>

<%@page import="Domain.Login"%>
<%@page import="Domain.Firm"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">
        <link rel="stylesheet" type="text/css" href="General.css">
        <title>Vis firmaer</title>
    </head>
    <body>
        <form>
            <input type ="hidden" value="useButton" name="do_this">
            <ul>
                <%
                    Login login = (Login) session.getAttribute("login");
                    System.out.println(login.getAuthorization());
                %>

                <%if (login.getAuthorization().equals("user"))
                    { %>
                <li> <input class="submit1" type="submit" name ="button" value="Tilføj bygning"></li>

                <li> <input class="submit1" type="submit" name ="button" value="Opret nyt login"></li>

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
            <h1>Firmaer</h1>
            <form action="ControllerServlet" method="GET">
                <% if (request.getAttribute("listOfFirms") != null)
                    {
                        ArrayList<Firm> firm;
                        firm = (ArrayList<Firm>) request.getAttribute("listOfFirms");
                %>
                <table>
                    <tr>
                        <td>
                            Kontakt nummer
                        </td>
                        <td>
                            Kontakt mail
                        </td>

                    </tr>
                    <% for (int i = 0; i < firm.size(); i++)
                        {%>
                    <tr>
                        <td>
                            <%=(firm.get(i).getContactNumber())%>   
                        </td>
                        <td>
                            <%=(firm.get(i).getContactMail())%>   
                        </td>
                    </tr>
                    <%}%>
                    <%}%>
                </table>
                <br>
            </form>

            <form action="ControllerServlet" method="GET">
                <input type="hidden" name="do_this" value="useButton" />
                <input type="submit" value="Tilbage til start siden" name="button" class="submit2" />
                <br>
            </form>
        </div>
    </body>
</html>
