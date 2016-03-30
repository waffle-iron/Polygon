<%-- 
    Document   : FirmJSP
    Created on : 30-03-2016, 10:23:07
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
        <h1>Hello Mennesker! Opret her et nyt firma</h1>
        <form action="ControllerServlet" method="GET">

            <p>ContactNumber: <input type="text" name="contactNumber"></p>

            <p>ContactMail: <input type="text" name="contactMail"></p>

            <input type="hidden" name="do_this" value="createFirm"/>
            <input type="submit" value="opret" name="createFirm" />

        </form>
    </body>
</html>
