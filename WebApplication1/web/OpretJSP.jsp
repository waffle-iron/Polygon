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
        <link rel="stylesheet" type="text/css" href="General.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="content">
        <h1>Opret bruger</h1>
        <form action="ControllerServlet" method="POST">
            <div>
            <p>Brugernavn</p>
            <input style="text-align: center" type="text" name="username" pattern="(?=.*[A-Z]).{1,15}"/><br>
            <span title="Brug mindst ét stort bogstav."> </span> 
            <span title="Dit brugernavn skal være mindre end 15 tegn"> </span>
            </div>
            <div>
            <p>Kodeord</p> <input style="text-align: center" type="password" name="password" pattern=".{6,}"/><br>
            <span title="Kodeordet skal være mindst 6 tegn langt"> </span>
            </div>
            <br>
            <select name="enum">
                <option>Bruger</option>
                <option>Tekniker</option>
                <option>Admin</option>
            </select>
            <p> Indtast firma ID:</p>
            <input type="text" name="firmID" />
            <br>
            <br>
            <input type="hidden" name="do_this" value="CreateLogin2" />
            <input type="submit" value="Opret" name="CreateLogin2" />
        </form>
        <br>
        <br>
                    <form action="ControllerServlet" method="GET">
                <input type="hidden" name="do_this" value="goBackToLogin" />
                <input type="submit" value="Gå tilbage til login" name="goBackToLogin" />
                <br>
            </form>
        </div>
    </body>
</html>
