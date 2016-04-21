<%-- 
    Document   : UploadFloorPlanJSP
    Created on : 14-04-2016, 14:49:39
    Author     : LouiseB
--%>

<%@page import="Domain.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="General.css">
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">
        <title>Floor plan</title>
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
            <input type ="hidden" name="do_this" value="useButton" >
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
                <li style="float:right"><input class="submit1" type="submit" name ="button" value="Kontakt"></li>           </ul>
        </form>
        <img src="sundeByg.png" alt="Polygon" style="width:255px;height:80px;" style="float:left">
        <div class="content">
            <h1>Upload floor plans her</h1>
            <tbody>
                <tr>
                    <td><input type = "file" name="uploadFloorImage" accept="image/x-png, image/gif, image/jpeg"/></td>
                </tr>
            </tbody>
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
