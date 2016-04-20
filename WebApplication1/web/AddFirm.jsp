<%@page import="Domain.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="General.css">
        <link rel="stylesheet" type="text/css" href="ErrorCSS.css">
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">
        <title>Firm</title>

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

            span, label {
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
        <form action="ControllerServlet"  method="POST">
            <input type ="hidden" name="do_this" value="useButton">
            <ul>
                <li><input class="submit1" type="submit" id="goBack" name="goToFrontPage" value="Forside" /></li>
                    <%
                        Login login = (Login) session.getAttribute("login");
                    %>

                <%if (login.getAuthorization().equals("user"))
                    { %>


                <li> <input class="submit1" type="submit" name ="button" value="Opret bygning"></li>

                <li> <input class="submit1" type="submit" name="button" value="Opret nyt login"></li>

                <%}%>

                <%if (login.getAuthorization().equals("admin"))
                    { %>

                <li><input class="submit1" type="submit" name ="button" value="Opret nyt firma"></li>

                <li><input class="submit1" type="submit" name ="button" value="Vis alle firmaer"></li>

                <li><input class="submit1" type="submit" name ="button" value="Opret nyt login"></li>
                    <%}%>
                <li><input class="submit1" type="submit" name ="button" value="Mine bygninger"></li>
                <li style="float:right"><input class="submit1" type="submit" name="button" value="Logud"  /></li>
                <li style="float:right"><input class="submit1" type="submit" name ="button" value="Kontakt"></li>
            </ul>
        </form>
        <img src="sundeByg.png" alt="Polygon" style="width:255px;height:80px;" style="float:left">
        <div class="content">
            <h1>Opret nyt firma her</h1>
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
            <div class='content'>
                <form action="ControllerServlet" method="POST">

                    <label for="contactN">Kontakt nummer</label>
                    <input type="text" id="contactN" name="contactNumber" pattern="[0-9].{7}"><br>
                    <span title="Kontakt nummer skal bestå af 8 cifre." id="contactN"> </span>

                    <label for="contactM">Kontakt mail </label>
                    <input type="email" id="contactM" name="contactMail" required>

                    <label for='opret'></label>
                    <input type="hidden" name="do_this" value="createFirm"/>
                    <input type="submit" id="opretFirma" value="Opret" id="opret" name="createFirm" class="submit2"/>
                </form>
            </div>
            <% if (request.getAttribute("saveFirmInfo") != null && request.getAttribute("saveFirmInfo").equals(true))
                {%>
            <label for="opretFirma">Du har nu oprettet et nyt firma.</label>

            <%}%> 
            <div class="footer">
                <table id="t01">
                    <tr>
                        <th>Kontakt Polygon på tlf: 11111111</th>
                        <th>E-mail: Polygon@mail.dk</th>
                        <th>Akut hjælp: 112</th>
                    </tr>

                </table>
            </div>
    </body>
</html>
