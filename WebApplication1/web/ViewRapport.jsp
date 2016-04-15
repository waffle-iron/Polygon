<%-- 
    Document   : ViewRapport
    Created on : 06-04-2016, 09:24:52
    Author     : Emil
--%>

<%@page import="Domain.Login"%>
<%@page import="Domain.Report"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Domain.ReportPage"%>
<%@page import="Domain.Comment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">
        <title>Rapport</title>
    </head>
    <body>
        <form action="ControllerServlet"  method="GET">
            <input type ="hidden" value="useButton" name="do_this">
            <ul>
                <%
                    Login login = (Login) session.getAttribute("login");
                    System.out.println(login.getAuthorization());
                %>

                <%if (login.getAuthorization().equals("user"))
                    { %>


                <li> <input class="submit1" type="submit" name ="button" value="Opret bygning"></li>

                <li> <input class="submit1" type="submit" name="button" value="Opret nyt login"></li>

                <%}%>

                <%if (login.getAuthorization().equals("admin"))
                    { %>

                <li><input class="submit1" type="submit" name ="button" value="Opret nyt firma"></li>

                <li><input class="submit1" type="submit" name ="button" value="Vis alle firmaer"></li>

                <li><input class="submit1" type="submit" name ="button" value="Opret nyt login"></li>
                    <%}%>
                <li><input class="submit1" type="submit" name ="button" value="Mine bygninger"></li>

                <li><input class="submit1" type="submit" value="Rapport-midlertidig" name="button" /></li>
                <li style="float:right"><a href="#about">Kontakt</a></li>
            </ul>
        </form>
                <img src="Poly-logo.png" alt="Polygon" style="width:200px;height:35px;" style = "float:left">
        <%Report res = (Report)request.getAttribute("report");%>
        
            <h2> Rapport forside </h2>
            <p>Rapport nummer:  <%=(res.getReportnr())%></p>
            <p>Navn på bygning: <%=(res.getBuildingID())%></p>
            <p>Dato:            <%=(res.getReportDate())%></p>
            <p>Adresse:         <%=("no adresse")%></p>
            <p><b>Gennemgang af bygningen udvendig</b></p>
            <br>
            ydrevæge:
            <%Comment com = null;%>
            <%if(res.getOuterWalls()!=null){%>
            <% com = res.getOuterWalls();%>
            <%=(com.toString())%>
            <%if(com.getImage()!= null)%>
            <%=(com.getImage())%>
            <%}%>
            <br>
            tag:
            <%Comment comRoof = null;%>
            <%if(res.getRoof()!=null){
                comRoof = res.getRoof();%>
            <%=(comRoof.toString())%>
            <%if(comRoof.getImage()!= null)%>
            <%=(comRoof.getImage())%>
            <%}%>
            <br>
            <%ReportPage[] reportpages = null;%>
            <%if(res.getReportPages() != null){%>
            <% reportpages = res.getReportPages();%>
            <%
                int i = 0;
            for(ReportPage reportPage:reportpages)
            {
            %>
            <h2> Rapport side: <%=i+1%> </h2>
            <p>Rapport nummer:<%=(reportPage.getReportNr())%></p>
            Har der været<br>skade i lokalet?
            <%=(reportPage.isPreviousDamaged())%>
            <br>
            Hvornår?
            <%=(reportPage.getDamagedDate().toString())%>
            <br>
            Hvor?
            <%=(reportPage.getDamagedPlace())%>
            <br>
            Hvad er der sket?
            <%=(reportPage.getCause())%>
            <br>
            Hvad er repereret?
            <%=(reportPage.getRepairs())%>
            <br>
            Skade
            <br>
            Fugt: <%=(reportPage.isMoist())%>
            <br>
            råd og svamp: <%=(reportPage.isRot())%>
            <br>
            skimmel: <%=(reportPage.isMold())%>
            <br>
            brændt: <%=(reportPage.isFire())%>
            <br>
            andenskade: <%=(reportPage.getOther())%>
            <br>
            <p><b>Fugtscanning</b></p>
            <br>
            Er der foretaget fugtscanning?
            <br>
            <%=(reportPage.isMoistScan())%>
            <%--
            <%
                    ArrayList<Comment> comments = reportPage.getComments();%>
                    <%=(comments)%>

                    <%if(reportPage.getComments()!=null)
                    for(Comment comment: comments){%>
                    <%=comment.toString()%>
                    <%if(comment.getImage()!= null)%>
                    <%= comment.getImage()%>
            <%}
            
            %>
            --%>    
            <%i++;}}%>
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
            <br>
            tilstandsgraden er:
            <%=res.getState()%>
    </body>
</html>
