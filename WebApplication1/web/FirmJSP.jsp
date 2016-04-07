<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="General.css">
        <title>Firm</title>
    </head>
    <body>
        <h1>Opret her et nyt firma</h1>
        <div class='formular'>
        <form action="ControllerServlet" method="GET">

            <p>Kontakt nummer <input type="text" name="contactNumber"></p>

            <p>Kontakt mail: <input type="text" name="contactMail"></p>

            <input type="hidden" name="do_this" value="createFirm"/>
            <input type="submit" value="opret" name="createFirm" />
        </form>
        </div>
    </body>
</html>
