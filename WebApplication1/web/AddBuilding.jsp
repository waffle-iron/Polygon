<%@page import="Domain.Login"%>
<%@page import="Domain.Building"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bygning</title>
        <link rel="stylesheet" type="text/css" href="General.css">
        <link rel="stylesheet" type="text/css" href="ErrorCSS.css">
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">
        
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
                background: -webkit-linear-gradient(top,#25A6E1 0%,#188BC0 100%);
                color: white;
            }
        </style>
    </head>
    <body>
        <form action="ControllerServlet"  method="POST">
            <input type ="hidden"  name="do_this" value="useButton">
            <ul>
                <li><input class="submit1" type="submit" id="goBack" name="button" value="Forside" /></li>
                    <%
                        Login login = (Login) session.getAttribute("login");
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
                <li><input class="submit1" type="submit" name ="button" value="Vis bygninger"></li>
                <li style="float:right"><input class="submit1" type="submit" name="button" value="Logud"  /></li>
                <li style="float:right"><input class="submit1" type="submit" name ="button" value="Kontakt"></li>
            </ul>
        </form>
        <img src="sundeByg.png" alt="Polygon" style="width:255px;height:80px;">
        <div class="content">
            <h1>Opret en ny bygning her</h1>
            <form action="ControllerServlet" method="POST">
                <table>
                    <tr>

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
                        <td>Adresse</td>
                        <td><input type="text" name="buildAddress" id="buildAddress" value="<%= (request.getParameter("buildAddress") == null
                                           || clear ? "" : request.getParameter("buildAddress"))%>"/>&nbsp;*
                    </tr>
                    <tr>
                        <td>Postnummer</td>
                        <td><input type="text" name="buildZip" value="<%= (request.getParameter("buildZip") == null
                                           || clear ? "" : request.getParameter("buildZip"))%>" pattern="[0-9]{4}" />&nbsp;* 
                            <span title="Postnummer skal indeholde 4 cifre."> </span>
                        <% if (session.getAttribute("loginAs") != null && ((String) session.getAttribute("loginAs")).equals("user"))
                            {%>
                            <input type ="hidden" id="userFirm" name ="buildFirmID" value="<%= ((Login) session.getAttribute("login")).getFirmID()%>">
                        <%}%>
                        
                        </td>
                        
                    </tr>
                    
                    <tr>
                        <td>Bygningens navn</td>
                        <td><input type="text" name="buildName" value="<%= (request.getParameter("buildName") == null
                                           || clear ? "" : request.getParameter("buildName"))%>" pattern="[A-Za-z].{0,30}"></td>
                    <span title="Dette felt skal udfyldes"> </span>
                    </tr>
                    <tr>
                        <td>Bygningsår</td>
                        <td><input type="text" name="buildYear" value="<%= (request.getParameter("buildYear") == null
                                           || clear ? "" : request.getParameter("buildYear"))%>" pattern="[0-9]{0,4}">
                            <span title="Bygningsår skal bestå af 4 cifre."</td>
                    </tr>
                    <tr>
                        <td>Størrelse</td>
                                   <td><input type="text" name="buildSize" value="<%= (request.getParameter("buildSize") == null
                                || clear ? "" : request.getParameter("buildSize"))%>" pattern="[0-9].{0,8}">&nbsp;*
                            <span title="Størrelsen angives i m2"> </span></td>
                    </tr>
                    <tr>
                        <td>Brug</td>
                        <td><input type="text" name="buildUsage" value="<%= (request.getParameter("buildUsage") == null
                                           || clear ? "" : request.getParameter("buildUsage"))%>" pattern="[A-Za-z].{0,30}">&nbsp;*
                            <span title="Dette felt skal udfyldes"> </span></td>
                    </tr>
                    <% if (request.getAttribute("saveBuilding") != null && request.getAttribute("saveBuilding").equals(true))
                        {%>
                    <label for="opretFirma">Du har nu oprettet en ny bygning.</label>
                    <%}%> 
                </table>
                <br>
                <p>Alle * skal udfyldes, før en bygning kan oprettes.</p>
                <input type="hidden" name="do_this" value="createBuild" />
                <input type="submit" value="Opret bygning" name="createBuild" class="submit2"/>
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