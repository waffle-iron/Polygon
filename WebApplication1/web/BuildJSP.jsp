<%-- 
    Document   : BuildJSP
    Created on : 30-03-2016, 11:34:47
    Author     : LouiseB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Mennesker! Opret her en ny bygning</h1>
        <form action="ControllerServlet" method="GET">

            <p>address: <input type="text" name="buildAddress"></p>

            <p>zip: <input type="text" name="buildZip"></p>

            <p>firmID: <input type="text" name="buildFirmID"></p>

            <p>name: <input type="text" name="buildName"></p>

            <p>build year: <input type="text" name="buildYear"></p>

            <p>size: <input type="text" name="buildSize"></p>

            <p>usage: <input type="text" name="buildUsage"></p>

            <input type="hidden" name="do_this" value="createBuild"/>
            <input type="submit" value="opret" name="createBuild" />

        </form>
    </body>
</html>
