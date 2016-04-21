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
        <form>
            <input type ="hidden"  name="do_this" value="useButton">

            <ul>
                <li><input  class="submit1" type="submit" id="goBack" name="goToFrontPage" value="Forside" /></li>
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
        <img src="sundeByg.png" alt="Polygon" style="width:255px;height:80px;" style="float:left">
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
                <input style="text-align: center" type="password" id="password" name="password" value="" pattern=".{6,}"/>
                <span title="Kodeordet skal være mindst 6 tegn langt"> </span>
                <br>
                <br>


                <% if (session.getAttribute("loginAs") != null && ((String) session.getAttribute("loginAs")).equals("admin"))
                {%>
                <label for="userType">Type:</label>

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
                <input class="submit2" type="submit"  name="CreateLogin" value="Opret" />
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

        </div>
       <div class="footer">
            <table id="t01">
                <tr>
                    <th>Kontakt Polygon på tlf: 4814 0555</th>
                    <th>E-mail: info@polygon.dk</th>
                    <th>Akut hjælp: 7011 0044</th>
                </tr>
            </table>
        </div>
    </body>
</html>
