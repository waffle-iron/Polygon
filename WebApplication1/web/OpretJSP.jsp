<%-- 
    Document   : OpretJSP
    Created on : 05-04-2016, 11:26:39
    Author     : LouiseB
--%>

<%@page import="Domain.Firm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Domain.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="ErrorCSS.css">
        <link rel="stylesheet" type="text/css" href="General.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Opret bruger</h1>
        <form action="ControllerServlet" method="POST">
            <div>
                <label for="username">Brugernavn:</label>
                <input style="text-align: center" type="text" id="username" name="username" pattern="(?=.*[A-Z]).{1,15}"/><br>
                <span title="Brug mindst ét stort bogstav."> </span> 
                <span title="Dit brugernavn skal være mindre end 15 tegn"> </span>
            </div>
            <div>
                <label for="password">Kodeord</p> <input style="text-align: center" type="password" name="password" pattern=".{6,}"/><br>
                <span title="Kodeordet skal være mindst 6 tegn langt"> </span>
            </div>
            <br>
            <% if (session.getAttribute("loginAs") != null && ((String) session.getAttribute("loginAs")).equals("admin"))
                {%>
            <select name="enum">
                <option>Bruger</option>
                <option>Tekniker</option>
                <option>Admin</option>
            </select>
            <%}%>
            <p> Firma ID:</p>

            <% if (session.getAttribute("loginAs") != null && ((String) session.getAttribute("loginAs")).equals("user"))
                {%>
            <td>
                <input type ="text" name ="firmID" value="<%= ((Login) session.getAttribute("login")).getFirmID()%>" readonly>
            </td>
            <%}%>
            
            <% if (request.getAttribute("ValidFirmID") != null && ((String) session.getAttribute("loginAs")).equals("admin"))
                {
                          ArrayList<Firm> firmIDs = (ArrayList<Firm>) request.getAttribute("ValidFirmID");%>
                          

            <td>
                <select name="firmID">
                    <option></option>
                    <%for (int i = 0; i < firmIDs.size(); i++)
                            {%>
                            
                    <option><%=firmIDs.get(i).getFirmID()%></option>
                    <%}%>
                </select>
            </td>
            <%}%>
            <br>
            <br>
            <input type="hidden" name="do_this" value="CreateLogin" />
            <input type="submit" value="Opret" name="CreateLogin" />
        </form>
        <br>
        <% if (request.getAttribute("saveLogin") != null && request.getAttribute("saveLogin").equals(true))
            {%>
        Du har nu oprettet et nyt login.
        <%} else if (request.getAttribute("saveLogin") != null && request.getAttribute("saveLogin").equals(false))
        {%>
        Login blev ikke oprettet.
        <%}%>

        <br>
        <br>
        <form action="ControllerServlet" method="GET">
            <input type="hidden" name="do_this" value="goToFrontPage" />
            <input type="submit" value="Gå tilbage til start siden" name="goToFrontPage" />
            <br>
        </form>

    </body>
</html>
