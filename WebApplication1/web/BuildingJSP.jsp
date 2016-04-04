<%@page import="helperClasses.Building"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bygning</title>
        <link rel="stylesheet" type="text/css" href="General.css">
   
    </head>
    <body>
        
            <h1>Hello Mennesker! Opret en ny bygning her</h1>

            <form action="" method="GET">

                <table>
                    <tr>
                        <td>Adresse</td>
                        <td><input type="text" name="buildAddress" value="<%= (request.getParameter("buildAddress") == null || (Boolean)request.getAttribute("clearAll") ? "" : request.getParameter("buildAddress")) %>" /></td>
                    </tr>
                    <tr>
                        <td>Postnummer</td>
                        <td><input type="text" name="buildZip" value="<%= (request.getParameter("buildZip") == null || (Boolean)request.getAttribute("clearAll") ? "" : request.getParameter("buildZip")) %>" ></td>
                    </tr>
                    <tr>
                        <td>Firma ID</td>
                        <td><input type="text" name="buildFirmID" value="<%= (request.getParameter("buildFirmID") == null || (Boolean)request.getAttribute("clearAll") ? "" : request.getParameter("buildFirmID")) %>"></td>
                    </tr>
                    <tr>
                        <td>Bygningens navn</td>
                        <td><input type="text" name="buildName" value="<%= (request.getParameter("buildName") == null || (Boolean)request.getAttribute("clearAll") ? "" : request.getParameter("buildName")) %>"></td>
                    </tr>
                    <tr>
                        <td>Bygningsår</td>
                        <td><input type="text" name="buildYear" value="<%= (request.getParameter("buildYear") == null || (Boolean)request.getAttribute("clearAll") ? "" : request.getParameter("buildYear")) %>"></td>
                    </tr>
                    <tr>
                        <td>Størrelse</td>
                        <td><input type="text" name="buildSize" value="<%= (request.getParameter("buildSize") == null || (Boolean)request.getAttribute("clearAll") ? "" : request.getParameter("buildSize")) %>"></td>
                    </tr>
                    <tr>
                        <td>Brug</td>
                        <td><input type="text" name="buildUsage" value="<%= (request.getParameter("buildUsage") == null || (Boolean)request.getAttribute("clearAll") ? "" : request.getParameter("buildUsage")) %>"></td>
                    </tr>

                </table>
                
                <input type="hidden" name="do_this" value="createBuild"/>
                <input type="submit" value="opret" name="createBuild" />
            </form>
            <form action="ControllerServlet" method="GET">
                <p>Vis bygninger <input type="submit" value="Vis bygninger" name="showBuild"></p>
                <input type="hidden" name="do_this" value="showBuild"/>
                
            </form>
            <% if (request.getAttribute("printBuild") != null)
                {%>
            <%=request.getAttribute("printBuild")%>    
            <%}%>        
            
            
    </body>
</html>
