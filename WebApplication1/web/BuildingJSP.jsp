<%@page import="helperClasses.Building"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bygning</title>
        <link rel="stylesheet" type="text/css" href="General.css">
        <link rel="stylesheet" type="text/css" href="ErrorCSS.css">
    </head>
    <body>
        <h1>Opret en ny bygning her</h1>

        <form action="ControllerServlet" method="GET">
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
                            || clear ? "" : request.getParameter("buildAddress"))%>"/>*
                </tr>
                <tr>
                    <td>Postnummer</td>
                               <td><input type="text" name="buildZip" value="<%= (request.getParameter("buildZip") == null
                            || clear ? "" : request.getParameter("buildZip"))%>" pattern="[0-9]{4}" />* 
                        <span title="Postnummer skal indeholde 4 cifre."> </span></td>
                </tr>
                <tr>
                    <td>Firma ID</td>
                               <td><input type="text" name="buildFirmID" value="<%= (request.getParameter("buildFirmID") == null
                            || clear ? "" : request.getParameter("buildFirmID"))%>" pattern="[0-9].{0,}">*
                        <span title="Firma ID kan kun bestå af tal"> </span></td>
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
                                       || clear ? "" : request.getParameter("buildSize"))%>" pattern="[0-9].{0,}">*
                                   <span title="Størrelsen angives i m2"> </span></td>
                </tr>
                <tr>
                    <td>Brug</td>
                               <td><input type="text" name="buildUsage" value="<%= (request.getParameter("buildUsage") == null
                            || clear ? "" : request.getParameter("buildUsage"))%>" pattern="[A-Za-z].{0,30}">*
                                   <span title="Dette felt skal udfyldes"> </span></td>
                </tr>

            </table>

            <input type="hidden" name="do_this" value="createBuild" />
            <input type="submit" value="opret" name="createBuild" />
        </form>
        <form action="ControllerServlet" method="GET">
            <p>Vis bygninger <input type="submit" value="Vis bygninger" name="showBuild" ></p>

            <input type="hidden" name="do_this" value="showBuild"/>

        </form>

        <% if (request.getAttribute("printBuild") != null)
            {
        ArrayList<Building> build = (ArrayList<Building>)request.getAttribute("printBuild");%>
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
            </tr>
        
        <%}%>
        </table>
    <%}%>   

    </body>
</html>