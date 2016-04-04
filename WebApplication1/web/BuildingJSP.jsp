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
        
            <h1>Opret en ny bygning her</h1>

            <form action="" method="GET">

                <table>

                    <tr>
                        <td>Adresse</td>
                        <td><input type="text" name="buildAddress"></td>
                    </tr>
                    <tr>
                        <td>Postnummer</td>
                        <td><input type="text" name="buildZip"></td>
                    </tr>
                    <tr>
                        <td>Firma ID</td>
                        <td><input type="text" name="buildFirmID"></td>
                    </tr>
                    <tr>
                        <td>Bygningens navn</td>
                        <td><input type="text" name="buildName"></td>
                    </tr>
                    <tr>
                        <td>Bygningsår</td>
                        <td><input type="text" name="buildYear"></td>
                    </tr>
                    <tr>
                        <td>Størrelse</td>
                        <td><input type="text" name="buildSize"></td>
                    </tr>
                    <tr>
                        <td>Brug</td>
                        <td><input type="text" name="buildUsage"></td>
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
