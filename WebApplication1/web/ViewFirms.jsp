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
        <form>
            <input type ="hidden"  name="do_this" value="useButton">
            <ul>
                <li><input class="submit1" type="submit" id="goBack"  name="goToFrontPage" value="Forside" /></li>
                    <%
                        Login login = (Login) session.getAttribute("login");
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
                <li><input class="submit1" type="submit" name ="button" value="Vis bygninger"></li>
                <li style="float:right"><input class="submit1" type="submit" name="button" value="Logud"  /></li>
                <li style="float:right"><input class="submit1" type="submit" name ="button" value="Kontakt"></li>            </ul>
        </form>
        <img src="sundeByg.png" alt="Polygon" style="width:255px;height:80px;" style="float:left">
        <div class="content">
            <h1>Firmaer</h1>
            <form action="ControllerServlet" method="POST">
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
        </div>
       <div class="footer">
            <table id="t01">
                <tr>
                    <th>Kontakt Polygon på tlf: 4814 0555</th>
                    <th>E-mail: info@polygon.dk</th>
                    <th>Akut hjælp: 7011 0044</th>
                </tr>
            </table>
        </div>
    </body>
</html>
