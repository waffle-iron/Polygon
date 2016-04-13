<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="General.css">
        <link rel="stylesheet" type="text/css" href="ErrorCSS.css">
        <title>Firm</title>
    </head>
    <body>
        <div class="content">
        <h1>Opret her et nyt firma</h1>
        <% boolean clear = false;
            try
            {
                if ((Boolean) request.getAttribute("clearAll"))
                {
                    clear = true;
                }
            } catch (Exception ex)
            {
                clear = false;
            }
        %>
        <div class='formular'>
            <form action="ControllerServlet" method="GET">

                <p>Kontakt nummer <input type="text" name="contactNumber">


                <p>Kontakt mail: <input type="text" name="contactMail"></p>

                <input type="hidden" name="do_this" value="createFirm"/>
                <input type="submit" value="Opret" name="createFirm" />
            </form>
        </div>
        <% if (request.getAttribute("saveFirmInfo") != null && request.getAttribute("saveFirmInfo").equals(true))
            {%>
        Du har nu oprettet et nyt firma.
        
        <%} else if(request.getAttribute("saveFirmInfo") != null && request.getAttribute("saveFirmInfo").equals(false))
            {%>
        Firma blev ikke oprettet.
        <%}%>
        <form action="ControllerServlet" method="GET">
            <br>
            <input type="hidden" name="do_this" value="goToFrontPage"/>
            <input type="submit" value="Gå tilbage start siden" name="goToFrontPage" />
        </form>
    </body>
</html>
