<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bygning</title>
    </head>
    <body>
        <h1>Hello Mennesker! Opret her en ny bygning</h1>
        <form action="ControllerServlet" method="GET">

            <p>Address: <input type="text" name="buildAddress"></p>

            <p>Zip: <input type="text" name="buildZip"></p>

            <p>Firm ID: <input type="text" name="buildFirmID"></p>

            <p>Name: <input type="text" name="buildName"></p>

            <p>Building year: <input type="text" name="buildYear"></p>

            <p>Building size: <input type="text" name="buildSize"></p>

            <p>Usage: <input type="text" name="buildUsage"></p>

            <input type="hidden" name="do_this" value="createBuilding"/>
            <input type="submit" value="opret" name="createBuild" />

        </form>
    </body>
</html>
