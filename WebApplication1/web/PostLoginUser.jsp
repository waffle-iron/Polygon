<%-- 
    Document   : PostLoginUser
    Created on : 08-04-2016, 11:50:27
    Author     : LouiseB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
          <style>
            ul{
                list-style-type: none;
                margin: 0;
                padding: 0;
            }
            li, form{
                float: left;
               
            }
        </style>
    </head>
    <body>
        <h1>Nu er nu logget ind som bruger</h1>
                <form action="ControllerServlet" method="GET">

                    <input type="submit" value="Opret bygning" name="CreateBuilding"/></>
                    <input type="hidden" name="do_this" value="Building">

                </form>
                <form action="ControllerServlet" method="GET">
                    <input type="submit" value="Opret ny rapport" name="createReport" />
                    <input type="hidden" name="do_this" value="Report">
                </form>

                <form action="ControllerServlet" method="GET">
                    <input type="submit" value="Login" name="Login" />
                    <input type="hidden" name="do_this" value="Login">
                </form>

            <form action="ControllerServlet" method="GET">
                <input type="hidden" name="do_this" value="goBackToLogin" />
                <input type="submit" value="Gå tilbage til login" name="goBackToLogin" />
                <br>
            </form>

    </body>
</html>
