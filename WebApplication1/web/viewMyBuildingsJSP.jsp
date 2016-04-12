<%-- 
    Document   : viewMyBuildingsJSP
    Created on : 11-04-2016, 11:27:48
    Author     : LouiseB
--%>

<%@page import="helperClasses.Building"%>
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
        
        <form action="ControllerServlet" method="GET">               
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
                <td>
                    <input type="submit"  size="6" value="Delete  <%=build.get(i).getBuildingID() %>" tname="button" />
                </td>
            </tr>
        
        <%}%>
        </table>
    <%}%>  
    <input type="hidden" value="useButton">
</form>
        
        <form action="ControllerServlet" method="GET">
                        
            
        <% if (request.getAttribute("listOfBuildings") != null)
            {
                 
                ArrayList<Building> listOfBuildings = (ArrayList<Building>) request.getAttribute("listOfBuildings");
            System.out.println(listOfBuildings.toString() + "her printes det");
            
            for (int i = 0; i < listOfBuildings.size(); i++)
            {            System.out.println("test111");
%>
            <table>
    <tr>
       
        <td>
            <%= "" + (listOfBuildings.get(i).getAddress())%>   
        </td>
        <td>
            <%= "" + (listOfBuildings.get(i).getZip())%>   
        </td>
        <td>
            <%= "" + (listOfBuildings.get(i).getFirmID())%>   
        </td>
        <td>
            <%= ""+ (listOfBuildings.get(i).getName())%>   
        </td>
        <td>
            <%= "" + (listOfBuildings.get(i).getBuildYear())%>   
        </td>
        <td>
            <%= "" + (listOfBuildings.get(i).getSize())%> 
        </td>
        <td>
            <%= "" + (listOfBuildings.get(i).getUsage())%>   
        </td>
    </tr>
</table>

    <%}%>
<%}%>
</form>
</body>
</html>
