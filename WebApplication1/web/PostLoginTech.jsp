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

        <ul>
            <li>
                <form action="ControllerServlet" method="GET">

                    <input type="submit" value="Opret bygning" name="createBuild"/></>
                    <input type="hidden" name="do_this" value="Building">

                </form>
            </li>
        </ul>

        <ul>

            <li><form action="ControllerServlet" method="GET">
                    <input type="submit" value="Opret nyt firma" name="createFirm" />
                    <input type="hidden" name="do_this" value="Firm">
                </form>
            </li>
        </ul>

        <ul>
            <li>
                <form action="ControllerServlet" method="GET">
                    <input type="submit" value="Opret ny rapport" name="createReport" />
                    <input type="hidden" name="do_this" value="Report">
                </form>
            </li>
        </ul>

        <ul>
            <li>
                <form action="ControllerServlet" method="GET">
                    <input type="submit" value="Login" name="Login" />
                    <input type="hidden" name="do_this" value="Login">
                </form>
            </li>
        </ul>
            <ul>
        <li>
            <form action="ControllerServlet" method="GET">
                <input type="hidden" name="do_this" value="goBackToLogin" />
                <input type="submit" value="Gå tilbage til login" name="goBackToLogin" />
                <br>
            </form>
        </li>
    </ul>
    </body>
    
</html>
