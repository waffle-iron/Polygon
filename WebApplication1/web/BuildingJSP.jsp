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

        <form action="" method="GET" onsubmit="myFunction()">

            <table>
                <tr>
                    <%// når boolean clearALL bliver brugt, får vi en nullpointer exception, når man submitter uden at have udfyldt alle felter. %> 
                    <% boolean clear = false; 
                        try
                        {
                            if((Boolean)request.getAttribute("clearAll"))
                            {
                                clear = true; 
                            }
                        } catch(Exception ex)
                        {
                            clear = false;
                        }
                    %>
                    <td>Adresse</td>
                    <td><input type="text" name="buildAddress" value="<%= (request.getParameter("buildAddress") == null 
                            || clear ? "" : request.getParameter("buildAddress"))%>" /></td>
                </tr>
                <tr>
                    <td>Postnummer</td>
                    <td><input type="text" name="buildZip" value="<%= (request.getParameter("buildZip") == null 
                            || clear ? "" : request.getParameter("buildZip"))%>" /></td>
                </tr>
                <tr>
                    <td>Firma ID</td>
                    <td><input type="text" name="buildFirmID" value="<%= (request.getParameter("buildFirmID") == null 
                            || clear ? "" : request.getParameter("buildFirmID"))%>"></td>
                </tr>
                <tr>
                    <td>Bygningens navn</td>
                    <td><input type="text" name="buildName" value="<%= (request.getParameter("buildName") == null 
                            || clear ? "" : request.getParameter("buildName"))%>"></td>
                </tr>
                <tr>
                    <td>Bygningsår</td>
                    <td><input type="text" name="buildYear" value="<%= (request.getParameter("buildYear") == null 
                            || clear ? "" : request.getParameter("buildYear"))%>"></td>
                </tr>
                <tr>
                    <td>Størrelse</td>
                    <td><input type="text" name="buildSize" value="<%= (request.getParameter("buildSize") == null 
                            || clear ? "" : request.getParameter("buildSize"))%>"></td>
                </tr>
                <tr>
                    <td>Brug</td>
                    <td><input type="text" name="buildUsage" value="<%= (request.getParameter("buildUsage") == null 
                            || clear ? "" : request.getParameter("buildUsage"))%>"></td>
                </tr>

            </table>

            <input type="hidden" name="do_this" value="createBuild" />
            <input type="submit" value="opret" name="createBuild" />
        </form>
        <form action="ControllerServlet" method="GET">
            <p>Vis bygninger <input type="submit" value="Vis bygninger" name="showBuild" ></p>

            <input type="hidden" name="do_this" value="showBuild"/>

        </form>
        
<p id="demo">This is a demonstration.</p>

        <% if (request.getAttribute("printBuild") != null)
            {%>
        <%=request.getAttribute("printBuild")%>    
        <%}%>   
        
         <script>
            function myFunction() {
                document.getElementById("demo").innerHTML = "Hello JavaScript!";
            }
        </script>
    </body>
</html>