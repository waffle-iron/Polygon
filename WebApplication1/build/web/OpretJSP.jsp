<%-- 
    Document   : OpretJSP
    Created on : 05-04-2016, 11:26:39
    Author     : LouiseB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="ErrorCSS.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Opret bruger</h1>
        <form action="ControllerServlet" method="POST">
            Brugernavn<br> <input style="text-align: center" type="text" name="username" value="" size="20" pattern="(?=.*[A-Z]).{1,15}"/>
            <span title="Brug mindst ét stort bogstav."> </span> <br>
            &nbsp;&nbsp;&nbsp;<span title="Dit brugernavn skal være mindre end 15 tegn"> </span>
            
            <br><br>
            Kodeord<br> <input style="text-align: center" type="password" name="password" value="" size="20" pattern=".{6}"/>
            <span title="Kodeordet skal bestå af mindst 6 tegn"> </span>
            <br><br>
            <select name="enum">
                <option>Bruger</option>
                <option>Tekniker</option>
                <option>Admin</option>
            </select>

            <p> Indtast firma ID:<input type="text" name="firmID" /></p>

            <input type="hidden" name="do_this" value="CreateLogin2" />
            <input type="submit" value="Opret" name="CreateLogin2" />
        </form>
    </body>
</html>
