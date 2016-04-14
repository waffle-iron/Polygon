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
        <title>Mine bygninger</title>
    </head>
    <body>
        <h1>Mine bygninger</h1>
        <%
            Login login = (Login)session.getAttribute("login");
            %>
                     
        <% if (request.getAttribute("listOfBuildings") != null)
            {
                
                ArrayList<Building> build;
        Object buildingList = request.getAttribute("listOfBuildings");
        build = (ArrayList<Building>)buildingList;
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
        for(int i = 0; i<build.size();i++){%>
        
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
                <%if (login.getAuthorization().equals("user")){%>
                <td>
                    <form action="ControllerServlet" method="GET">  
                        
                    <input type="submit"  size="6" value="delete" name="button" />
                <input type="hidden" name="do_this"value="useComment">
                <input type="hidden" name="Comment"value="Delete,<%=build.get(i).getBuildingID()%>">
                </form>
                </td>
                <%
                    }
                    %>
                <td>
                    <form action="ControllerServlet" method="GET">  
                    <input type="submit"  size="6" value="se rapporter" name="button" />
                    <input type="hidden" name="do_this"value="useComment">
                    <input type="hidden" name="Comment"value="viewReports,<%=build.get(i).getBuildingID()%>">
                    </form>
                </td>
                <td>
                    <form action="ControllerServlet" method="GET">  
                    <input type="submit"  size="6" value="skriv report" name="button" />
                    <input type="hidden" name="do_this"value="useComment">
                    <input type="hidden" name="Comment"value="writeReport,<%=build.get(i).getBuildingID()%>">
                    </form>
                </td>
            </tr>
        
        <%}%>
        </table>
    <%}%>  
    

        
        
</body>
</html>
