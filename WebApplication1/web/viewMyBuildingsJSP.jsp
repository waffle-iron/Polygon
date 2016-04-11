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
            
            <p>hej</p>
            
            
        <% if (request.getAttribute("listOfBuildings") != null)
            {
                ArrayList<Building> listOfBuildings = (ArrayList<Building>) session.getAttribute("listOfBuildings");
            
        
            for (int i = 0; i < listOfBuildings.size(); i++)
            {%>
            <table>
    <tr>
        <td>
            <%=(listOfBuildings.get(i).getAddress())%>   
        </td>
        <td>
            <%=(listOfBuildings.get(i).getZip())%>   
        </td>
        <td>
            <%=(listOfBuildings.get(i).getFirmID())%>   
        </td>
        <td>
            <%=(listOfBuildings.get(i).getName())%>   
        </td>
        <td>
            <%=(listOfBuildings.get(i).getBuildYear())%>   
        </td>
        <td>
            <%=(listOfBuildings.get(i).getSize())%> 
        </td>
        <td>
            <%=(listOfBuildings.get(i).getUsage())%>   
        </td>
    </tr>
</table>

    <%}%>
<%}%>
</form>
</body>
</html>
