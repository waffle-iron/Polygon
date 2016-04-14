<%-- 
    Document   : ViewFirms
    Created on : 14-04-2016, 10:23:25
    Author     : LouiseB
--%>

<%@page import="Domain.Firm"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vis firmaer</title>
    </head>
    <body>
        <h1>Firmaer</h1>
        <form action="ControllerServlet" method="GET">
            <% if (request.getAttribute("listOfFirms") != null)
                {
                    ArrayList<Firm> firm;
                    firm = (ArrayList<Firm>) request.getAttribute("listOfFirms");
            %>
            <table>
                <tr>
                    <td>
                        Kontakt nummer
                    </td>
                    <td>
                        Kontakt mail
                    </td>

                </tr>
                <% for (int i = 0; i < firm.size(); i++)
                    {%>
                <tr>
                    <td>
                        <%=(firm.get(i).getContactNumber())%>   
                    </td>
                    <td>
                        <%=(firm.get(i).getContactMail())%>   
                    </td>
                </tr>
                    <%}%>
                <%}%>
        </form>
    </body>
</html>
