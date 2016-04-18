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
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">
        <title>Opret login</title>

        <style>
            label{
                width:180px;
                clear:left;
                text-align:right;
                padding-right:10px;
            }

            input, label {
                float:left;
                margin-bottom: 5px;
            }

            select, label {
                float:left;
                margin-bottom: 5px;
            }
        </style>
    </head>
    <body>
        <form>
            <input type ="hidden" value="useButton" name="do_this">

            <ul>
                <%
                    Login login = (Login) session.getAttribute("login");
                %>

                <%if (login.getAuthorization().equals("user"))
                { %>
                <li> <input class="submit1" type="submit" name ="button" value="Opret bygning"></li>

                <li> <input class="submit1" type="submit" name ="button" value="Opret nyt login" ></li>

                <%}%>

                <%if (login.getAuthorization().equals("admin"))
                { %>

                <li><input class="submit1" type="submit" name ="button" value="Opret nyt firma"></li>

                <li><input class="submit1" type="submit" name ="button" value="Vis alle firmaer"></li>

                <li><input class="submit1" type="submit" name ="button" value="Opret nyt login"></li>
                    <%}%>
                <li><input class="submit1" type="submit" name ="button" value="Mine bygninger"></li>
                <li style="float:right"><input type="submit" value="Logud" name="button" class="submit1" /></li>
                <li style="float:right"><input class="submit1" type="submit" name ="button" value="Kontakt"></li>

            </ul>
        </form>
        <img src="Poly-logo.png" alt="Polygon" style="width:200px;height:35px;" style="float:left">
        <div class="content">
            <h1>Opret bruger</h1>
            <form action="ControllerServlet" method="POST">

                <label for="username">Brugernavn:</label>
                <input style="text-align: center" type="text" id="username" name="username" pattern="(?=.*[A-Z]).{1,15}"/>
                <span title="Brug mindst ét stort bogstav."></span> <br>
                <span title="Dit brugernavn skal være mindre end 15 tegn" > </span>
                <br>
                <br>
                <label for="password">Kodeord:</label>
                <input style="text-align: center" type="password" id="password" value="" name="password" pattern=".{6,}"/>
                <span title="Kodeordet skal være mindst 6 tegn langt"> </span>
                <br>
                <br>

                <label for="userType">Type:</label>
                <% if (session.getAttribute("loginAs") != null && ((String) session.getAttribute("loginAs")).equals("admin"))
                {%>

                <select name="enum" id="userType">
                    <option>Bruger</option>
                    <option>Tekniker</option>
                    <option>Admin</option>
                </select>
                <%}%>
                <label for="firmId"> Firma ID:</label>

                <% if (session.getAttribute("loginAs") != null && ((String) session.getAttribute("loginAs")).equals("user"))
                {%>
                <td>
                    <input type ="text" name ="firmID" value="<%= ((Login) session.getAttribute("login")).getFirmID()%>" id="firmId" readonly>
                </td>
                <%}%>
                <%if (request.getAttribute("ValidFirmID") != null && ((String) session.getAttribute("loginAs")).equals("admin"))
                    {
                        ArrayList<Firm> firmIDs = (ArrayList<Firm>) request.getAttribute("ValidFirmID");%>

                <td>
                    <select name="firmID" id="firmId">
                        <%for (int i = 0; i < firmIDs.size(); i++)
                        {%>
                        <option><%=firmIDs.get(i).getFirmID()%></option>
                        <%}%>
                    </select>
                </td>
                <%}%>
                <br>
                <br>
                <br>
                <br>
                <label for="opret"></label>
                <input type="hidden" id="opret" name="do_this" value="CreateLogin" />
                <input type="submit" value="Opret" name="CreateLogin" class="submit2"/>
            </form>
            <br>
            <% if (request.getAttribute("saveLogin") != null && request.getAttribute("saveLogin").equals(true))
            {%>
            Du har nu oprettet et nyt login.
            <%} else if (request.getAttribute("saveLogin") != null && request.getAttribute("saveLogin").equals(false))
        {%>
            Login blev ikke oprettet. Tjek eventuelt for manglede udfyldning af felter.
            <%}%>
            <br>
            <form action="ControllerServlet" method="GET">
                <label for="goBack"></label>
                <input type="hidden" name="do_this" value="goToFrontPage" />
                <input type="submit" id="goBack" value="Gå tilbage til start siden" name="goToFrontPage" class="submit2"/>
                <br>
            </form>
        </div>
    </body>
</html>
