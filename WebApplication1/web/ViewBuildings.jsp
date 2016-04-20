<%-- 
    Document   : viewMyBuildingsJSP
    Created on : 11-04-2016, 11:27:48
    Author     : LouiseB
--%>

<%@page import="Domain.Login"%>
<%@page import="Domain.Building"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">
        <title>Mine bygninger</title>
        
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
        <form action="ControllerServlet"  method="POST">
            <input type ="hidden" name="do_this" value="useButton" >
            <ul>
                <li><input  class="submit1" type="submit" id="goBack"  name="goToFrontPage" value="Forside"/></li>
                    <%
                        Login login1 = (Login) session.getAttribute("login");
                    %>

                <%if (login1.getAuthorization().equals("user"))
                    { %>


                <li> <input class="submit1" type="submit" name ="button" value="Opret bygning"></li>

                <li> <input class="submit1" type="submit" name="button" value="Opret nyt login"></li>

                <%}%>

                <%if (login1.getAuthorization().equals("admin"))
                    { %>

                <li><input class="submit1" type="submit" name ="button" value="Opret nyt firma"></li>

                <li><input class="submit1" type="submit" name ="button" value="Vis alle firmaer"></li>

                <li><input class="submit1" type="submit" name ="button" value="Opret nyt login"></li>
                    <%}%>
                <li><input class="submit1" type="submit" name ="button" value="Mine bygninger"></li>
                <li style="float:right"><input class="submit1" type="submit" name="button" value="Logud"  /></li>
                <li style="float:right"><input class="submit1" type="submit" name ="button" value="Kontakt"></li>            </ul>
        </form>
        <img src="sundeByg.png" alt="Polygon" style="width:255px;height:80px;" style="float:left">
        <h1>Mine bygninger</h1>
        <%
            Login login = (Login) session.getAttribute("login");
        %>

        <% if (request.getAttribute("listOfBuildings") != null)
            {

                ArrayList<Building> build;
                Object buildingList = request.getAttribute("listOfBuildings");
                build = (ArrayList<Building>) buildingList;
        %>
        <table>
            <tr>
                <td>
                    Address
                </td>
                <td>
                    Postkode
                </td>
                <td>
                    FirmaID
                </td>
                <td>
                    Bygningsnavn
                </td>
                <td>
                    Byggeår
                </td>
                <td>
                    Byggningsstørelse
                </td>
                <td>
                    Bruges til
                </td>
            </tr>
            <%
                for (int i = 0; i < build.size(); i++)
                {%>

            <tr>
                <td>
                    <%=(build.get(i).getAddress())%>   
                </td>
                <td>
                    <%=(build.get(i).getZip())%>   
                </td>
                <td>
                    <%=(build.get(i).getFirmID())%>   
                </td>
                <td>
                    <%=(build.get(i).getName())%>   
                </td>
                <td>
                    <%=(build.get(i).getBuildYear())%>   
                </td>
                <td>
                    <%=(build.get(i).getSize())%>   m&#178;
                </td>
                <td>
                    <%=(build.get(i).getUsage())%>   
                </td>
                <%if (login.getAuthorization().equals("user"))
                    {%>
                <td>
                    <form action="ControllerServlet" method="POST">  

                        <input class="submit2" type="submit" name="button" value="Slet rapport"  size="6"  />
                        <input type="hidden" value="useHidden" name="do_this">
                        <input type="hidden" name="Comment" value="Delete,<%=build.get(i).getBuildingID()%>">
                    </form>
                </td>
                <%}%>
                <td>
                    <form action="ControllerServlet" method="POST">  
                        <input class="submit2" type="submit"  name="button"  value="Se rapporter" size="6" />
                        <input type="hidden" name="do_this" value="useHidden">
                        <input type="hidden" name="Comment" value="viewReports,<%=build.get(i).getBuildingID()%>">
                    </form>
                </td>
                <td>
                    <form action="ControllerServlet" method="POST">  
                        <input class="submit2" type="submit" name="button" value="Skriv rapport" />
                        <input type="hidden" name="do_this" value="useHidden">
                        <input type="hidden" name="Comment" value="writeReport,<%=build.get(i).getBuildingID()%>">
                    </form>
                </td>
                <td>
                    <form action="ControllerServlet" method="POST">  
                        <input  class="submit2" type="submit"  name="button"  value="Upload floor plans" size="6"/>
                        <input type="hidden" name="do_this" value="useHidden">
                        <input type="hidden" name="Comment" value="uploadFloorPlan,<%=build.get(i).getBuildingID()%>">
                    </form>
                </td>
            </tr>

            <%}%>
        </table>
        <%}%>  
    </body>
    <div class="footer">
        <table id="t01">
            <tr>
                <th>Kontakt Polygon på tlf: 11111111</th>
                <th>E-mail: Polygon@mail.dk</th>
                <th>Akut hjælp: 112</th>
            </tr>

        </table>
    </div>
</html>
