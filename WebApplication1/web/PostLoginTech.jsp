<%-- 
    Document   : PostLoginTech
    Created on : 08-04-2016, 11:50:50
    Author     : LouiseB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tekniker</title>
    </head>
    <body>
        <h1>Du er nu logget ind somm tekniker</h1>
        <style>
            ul{
                list-style-type: none;
                margin: 0;
                padding: 0;
            }
            li, form{
                float: left;
            }

            button{
                color: #900;
                font-weight: bold;
            }
        </style>
    </head>
    <body>

                <form action="ControllerServlet" method="GET">
                    <input type="submit" value="Opret ny rapport" name="createReport" />
                    <input type="hidden" name="do_this" value="Report">
                </form>

            <form action="ControllerServlet" method="GET">
                <input type="hidden" name="do_this" value="goBackToLogin" />
                <input type="submit" value="Gå tilbage til login" name="goBackToLogin" />
                <br>
            </form>

    </body>
    
</html>
