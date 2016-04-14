<%-- 
    Document   : ViewRapport
    Created on : 06-04-2016, 09:24:52
    Author     : Emil
--%>

<%@page import="Domain.ReportPage"%>
<%@page import="Domain.Comment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rapport</title>
    </head>
    <body>
            <h2> Rapport forside </h2>
            <p>Rapport nummer:  "<%=(request.getAttribute("ReportNR"))%>"</p>
            <p>Navn på bygning: "<%=(request.getAttribute("BuildingID"))%>"</p>
            <p>Dato:            "<%=(request.getAttribute("ReportDate"))%>"</p>
            <p>Adresse:         "<%=(request.getAttribute("ReportDate"))%>"</p>
            <p><b>Gennemgang af bygningen udvendig</b></p>
            "<%Comment com = (Comment)request.getAttribute("OuterWalls");%>"
            "<%=(com.toString())%>"
            <br>
            "<%Comment comRoof = (Comment)request.getAttribute("Roof");%>"
            "<%=(comRoof.toString())%>"
            "<%ReportPage[] reportpages = (ReportPage[])request.getAttribute("ReportPages");%>"
            <%
                int i = 0;
            for(ReportPage reportPage:reportpages)
            {
            %>
            <h2> Rapport side<%=i%> </h2>
            <p>Rapport nummer:<%=(reportPage.getReportNr())%></p>
            Har der været<br>skade i lokalet?
            <%=(reportPage.isPreviousDamaged())%>
            Hvornår?
            <%=(reportPage.getDamagedDate().toString())%>
            Hvor?
            <%=(reportPage.getDamagedPlace())%>
            Hvad er der sket?
            <%=(reportPage.getCause())%>
            Hvad er repereret?
            <%=(reportPage.getRepairs())%>
            Skade
            Fugt<%=(reportPage.isMoist())%>
            råd og svamp<%=(reportPage.isRot())%>
            skimmel<%=(reportPage.isMold())%>
            brændt<%=(reportPage.isFire())%>
            andenskade<%=(reportPage.getOther())%>
            <p><b>Fugtscanning</b></p>
            Er der foretaget fugtscanning?
            <%=(reportPage.isMoistScan())%>
            <%
                    Comment[] comments = reportPage.getComments();
                    for(Comment comment: comments){%>
                    <%=comment.toString()%>
            <%}
            %>
            <%i++;}%>
            <table border="1">
                <thead>
                    <tr>
                        <th>Tilstand</th>
                        <th>Beskrivelse af bygningen</th>
                        <th>Funktion af bygningen</th>
                        <th>Tilstandsgrad</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><b>Tilstandsgrad 0</b></td>
                        <td>Bygningsdelen er ny og som bygget</td>
                        <td>Funktionen er som beskrevet</td>
                    </tr>
                    <tr>
                        <td><b>Tilstandsgrad 1</b></td>
                        <td>Bygningsdelen er intakt, men med<br>
                            begyndende slid og synlige skader<br>
                            (kun kosmetiske skader)</td>
                        <td>Funktionen er som beskrevet</td>
                    </tr>
                    <tr>
                        <td><b>Tilstandsgrad 2</b></td>
                        <td>Bygningsdelen er begyndt at forfalde<br>
                            med enkelte defekte komponenter</td>
                        <td>Funktionen er nedsat-<br>
                            fare for følgeskader</td>
                    </tr>
                    <tr>
                        <td><b>Tilstandsgrad 3</b></td>
                        <td>Bygningsdelen er nedbrugt og skal<br>
                            udskiftes</td>
                        <td>Funktionen er ophørt-<br>
                            fare for følgeskader</td>
                    </tr>
                </tbody>
            </table>
            <%=(request.getAttribute("State"))%>
    </body>
</html>
