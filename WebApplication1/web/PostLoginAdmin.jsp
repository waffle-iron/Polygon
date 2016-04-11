<%-- 
    Document   : PostLoginAdmin
    Created on : 08-04-2016, 11:49:55
    Author     : LouiseB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <h1>Nu er nu logget ind som administrator</h1>
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

                <input type="submit" value="Opret bygning" name="createBuilding"/></>
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
</body>
</html>
