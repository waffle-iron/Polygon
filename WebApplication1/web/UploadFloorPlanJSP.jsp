<%-- 
    Document   : UploadFloorPlanJSP
    Created on : 14-04-2016, 14:49:39
    Author     : LouiseB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Floor plan</title>
    </head>
    <body>
        <h1>Upload floor plans her</h1>
    <tbody>
        <tr>
            <td><input type = "file" name="uploadFloorImage" accept="image/x-png, image/gif, image/jpeg"/></td>
        </tr>
    </tbody>
    <br><br>
    <form action="ControllerServlet" method="GET">
        <input type="hidden" name="do_this" value="useButton" />
        <input type="submit" value="Tilbage til start siden" name="button" />
        <br>
    </form>
</body>
</html>
