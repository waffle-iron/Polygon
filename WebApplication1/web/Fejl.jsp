<%-- 
    Document   : Fejl
    Created on : 04-04-2016, 10:29:45
    Author     : LouiseB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fejl</title>
    </head>
    <body>
        <h1>der er en fejl <3 bed venligst gruppe 5 om at fixe den :D</h1>
        <br>
        <br>
        <h2><%=request.getAttribute("fejlMeddelse")%></h2>
        <%if(request.getAttribute("goBackTo") != null && request.getAttribute("goBackTo").equals("writeReport") ){ %>
        <form>
            <input type="submit" value="tilbage til skriv report" name="button" />
            <input type="hidden" name="do_this" value ="Report">
        </form>
        <% }%>
        <%if(request.getAttribute("goBackTo") != null && request.getAttribute("goBackTo").equals("viewBuildings") ){ %>
        <form>
            <input type="submit" value="tilbage til skriv report" name="button" />
            <input type="hidden" name="do_this" value ="goToViewMyBuildings">
        </form>
        <% }%>

        <h2><%=request.getAttribute("noReport")%></h2>
        <%if(request.getAttribute("goBackToMyBuildings") != null && request.getAttribute("goBackToMyBuildings").equals("viewMyBuildings") ){ %>
        <form>
            <input type="submit" value="Tilbage til mine bygninger" name="button" />
            <input type="hidden" name="do_this" value ="goToViewMyBuildings">
        </form>
        <% }%>
        <%if(request.getAttribute("goBackTo") != null && request.getAttribute("goBackTo").equals("viewBuildings") ){ %>
        <form>
            <input type="submit" value="Tilbage til mine bygninger" name="button" />
            <input type="hidden" name="do_this" value ="goToViewMyBuildings">
        </form>
        <% }%>        
        
    </body>
</html>
