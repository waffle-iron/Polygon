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

            <p>Kontakt nummer <input type="text" name="contactNumber" pattern="[0-9].{7}"><br>
                <span title="Kontakt nummer skal bestå af 8 cifre."> </span>
                
            <p>Kontakt mail: <input type="email" name="contactMail" required></p>

            <input type="hidden" name="do_this" value="createFirm"/>
            <input type="submit" value="opret" name="createFirm" />
        </form>
        </div>
        </div>
    </body>
</html>
