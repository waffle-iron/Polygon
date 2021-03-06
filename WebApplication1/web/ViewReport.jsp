<%-- 
    Document   : ViewRepport
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
        <style>
            .footer{
                position:fixed;
                left:0px;
  
            }
            
            table#t01 {
                width:100%;
                position: fixed; bottom: 0;
            }

            th {
                padding: 5px;
                text-align: left;
            }
            table#t01 th	{
                background-color: rgb(0,159,227);
                background: -webkit-linear-gradient(top,#25A6E1 0%,#188BC0 100%);
                color: white;
            }
        </style>
    </head>
    <body>
        <form action="ControllerServlet"  method="POST">
            <input type ="hidden" name="do_this" value="useButton" >
            <ul>
                <li><input class="submit1" type="submit" id="goBack"  name="button" value="Forside"/></li>
                <%
                    Login login = (Login) session.getAttribute("login");
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
                <li><input class="submit1" type="submit" name ="button" value="Vis bygninger"></li>
                <li style="float:right"><input class="submit1" type="submit" name="button" value="Logud"  /></li>
                <li style="float:right"><input class="submit1" type="submit" name ="button" value="Kontakt"></li>            </ul>
        </form>
                <img src="Poly-logo.png" alt="Polygon" style="float:left;width:200px;height:35px;" >
                <form action="ControllerServlet"  method="POST">
                    <%ArrayList<Integer> reportIDs = new ArrayList();
                        reportIDs = (ArrayList<Integer>) request.getAttribute("reportIDList");
                        %>
                    <select name="Option">
                        <%
                        for(int i = 0; i < reportIDs.size();i++)
                        {
                            %>
                            <option <%if(((Report)request.getAttribute("report")).getReportnr() ==reportIDs.get(i)){%>
                                selected="selected"<%}%>>
                                <%=reportIDs.get(i) %>
                            </option>
                            <%
                        }
                    %>
                    </select>
                    <input type ="hidden" name = "do_this" value ="changeReport">
                    <input type="submit"  name="button" value="skift rapport"/>
                    <input type="hidden" name ="buildingID" value ="<%=((Report)request.getAttribute("report")).getBuildingID()%>">
                    
                </form>
        <%Report res = (Report)request.getAttribute("report");%>
        
            <h2> Rapport forside </h2>
            <p>Rapport nummer:  <%=(res.getReportnr())%></p>
            <p>Navn på bygning: <%=(res.getBuildingID())%></p>
            <p>Dato:            <%=(res.getReportDate())%></p>
            <p>Adresse:         <%=(request.getAttribute("Adresse"))%></p>
            <p><b>Gennemgang af bygningen udvendig</b></p>
            <br>
            ydrevæge:
            <%Comment com = null;%>
            <%if(res.getOuterWalls()!=null){%>
            <% com = res.getOuterWalls();%>
            <%=(com.getText()+ com.getType())%>
            <%if(com.getImage()!= null)%>
            <%=(com.getImage())%>
            <%}%>
            <br>
            tag:
            <%Comment comRoof = null;%>
            <%if(res.getRoof()!=null){
                comRoof = res.getRoof();%>
            <%=(comRoof.getText() + comRoof.getType())%>
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
            
            <%ArrayList<Comment> comments = reportPage.getComments();%>
           
                    <%if(reportPage.getComments()!=null)
                    for(Comment comment: comments){%>
                    <%=comment.getText() + comment.getType()%>
                    <%if(comment.getImage()!= null){%>
                    <%= comment.getImage()%>
                    <%}%>
            <%}
            
            %>
            
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
                  <div class="footer">
            <table id="t01">
                <tr>
                    <th>Kontakt Polygon på tlf: 4814 0555</th>
                    <th>E-mail: info@polygon.dk</th>
                    <th>Akut hjælp: 7011 0044</th>
                </tr>
            </table>
        </div>
    </body>
</html>
