<%@page import="java.sql.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="Domain.Building"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="ReportCSS.css">
        <link rel="stylesheet" type="text/css" href="NavigationCSS.css">

        <title>Rapport</title>

        <style>
            label{
                width:180px;
                clear:left;
                text-align:right;
                padding-right:10px;
            }

            input, label {
                float:left;
                margin-bottom: 5px;
            }
        </style>
    </head>
    <body>
        <form action="ControllerServlet" method="POST">
            <input type="hidden" name="do_this" value="useButton" />
            <input class="submit2" type="submit"  name="button"  value="Forside"/>
            <br>
        </form>
        <div class="report">
            <form id="myForm" action="ControllerServlet" method="POST" enctype="multipart/form-data">
                <% if (request.getAttribute("saveReport") != null && request.getAttribute("saveReport").equals(true))
                                 {%>
                <h3>Du har nu oprettet en rapport.</h3>

                <%}%> 
                <div class="frontPage">

                    <% Building building = null;
                        if (session.getAttribute("building") != null)
                        {
                            building = (Building) session.getAttribute("building");
                        }%>
                    <h1>Udfyld rapport</h1> 
                    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Alle * skal udfyldes, for at kunne oprette en rapport.</p>
                    <label for="reportNR">Rapport nummer: *</label>
                    <input type="number" id="reportNR" name="reportNRtext" value="<%=request.getAttribute("nextReportNr")%>" readonly>
                    <label for="buildingName">Navn på bygning: *</label>
                    <input id="buildingName" type="text" name="buildingNameText"
                           value ="<%= (building != null ? building.getName()
                                   : (request.getParameter("buildingNameText") == null ? "" : request.getParameter("buildingNameText")))%>" pattern="{0,30}" />
                    <span title="bygnings navn skal være mindre end 30."> </span>

                    <label for="date">Dato: *</label>
                    <input id="date" type="date" name="dateDate" > 
                    <label for="adresse">Adresse: *</label>
                    <input id="adresse" type="text" name="adressText"
                           value ="<%= (building != null ? building.getAddress() : (request.getParameter("adressText") == null ? "" : request.getParameter("adressText")))%>">
                    <label for="zip">Postnr./by: *</label>
                    <input id="zip" type="text" name="zipText"
                           value ="<%= (building != null ? "" + building.getZip() : (request.getParameter("zipText") == null ? "" : request.getParameter("zipText")))%>">

                    <label><b>Generel information om bygningen</b></label>

                    <label for="buildYear"> Byggeår:</label>
                    <input id="buildYear" type="number" name="buildYearNum" value ="<%=(building != null ? building.getBuildYear() : request.getParameter("buildYearNum"))%>">

                    <label for="buildArea">Bygningsareal i m<sup>2</sup> <br>
                        (hver etage tælles seperat)</label>
                    <input id="buildArea" type="number" name="buildingAreaNum" value ="<%=(building != null ? building.getSize() : "")%>">
                    <label for="usage">Hvad bruges bygningen til/<br>
                        hvad har bygningen været brugt til? </label>
                    <input id="usage" type="text" name="usageText" size="50" value ="<%= (building != null ? building.getName() : (request.getParameter("usageText") == null ? "" : request.getParameter("usageText")))%>">
                    <label><b>Gennemgang af bygningen udvendig</b></label>
                    <label><b>Note</b>: For at kunne uploade et billede til rapporten, skal 'Bemærkninger' afmærkes. </label>
                    <table border="1">
                        <thead>
                            <tr> 
                                <th></th>
                                <th>Bemærkninger</th>
                                <th>Ingen bemærkninger</th>
                                <th>Billede</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Tag</td>
                                <td><input type="radio" value="on" name="roofCommentCheck"></td>
                                <td><input type="radio" value="off" name="roofCommentCheck" checked="checked"></td>
                                <td><input type = "file" name="roofImage" accept="image/x-png, image/gif, image/jpeg"/></td>
                            </tr>
                            <tr>
                                <td colspan="4"><input type="text" name="roofText" size="90" value ="<%= (request.getParameter("roofText") == null ? "" : request.getParameter("roofText"))%>"></td>
                            </tr>
                        </tbody>
                    </table>
                    <br>
                    <table border="1">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Bemærkninger</th>
                                <th>Ingen bemærkninger</th>
                                <th>Billede</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Ydervægge</td>

                                <td><input type="radio" value="on" name="outerWallCommentCheck"></td>
                                <td><input type="radio" value="off" name="outerWallCommentCheck" checked="checked"></td>
                                <td><input type = "file" name="image" accept="image/x-png, image/gif, image/jpeg"/></td>

                            </tr>
                            <tr>
                                <td colspan="4"><input type="text" name="outerWallText" size="90" 
                                                       value ="<%= (request.getParameter("outerWallText") == null ? "" : request.getParameter("outerWallText"))%>"></td>
                            </tr>

                        </tbody>
                    </table>
                </div>
                <div class="reportPage">
                    <label for="reportP">Rapport side</label>
                    <input type="number" name="numberOfReportPages" id="reportP" value = "<%=request.getAttribute("numberOfPages")%>">
                    <input type="submit"  value="Opdater side antal" name="button" id="reportP" />
                    <input type="hidden" name ="do_this" value="useButton">

                    <label for="reportNr"> Rapport nummer</label>

                    <input type="number" name="reportNRNum" id="reportNr">
                    <label><b>Note</b>: For at kunne uploade et billede til rapporten, skal 'Bemærkninger' afmærkes.</label>

                    <% int pages = 0;
                        pages += Integer.parseInt((String) request.getAttribute("numberOfPages"));
                        for (int i = 1; i < pages + 1; i++)
                        {
                            if (i != 1)
                            {
                    %>
                    <div class="reportPage">
                        <%}%>
                        <table border="1">
                            <thead>
                                <tr>
                                    <td>Har der været<br>
                                        skade i lokalet?</td>
                                    <td colspan="3"><p> Ja <input type="radio" name="<%="damageCheck" + i%>" value="on" /></p>
                                        <p> Nej <input type="radio" name="<%="damageCheck" + i%>" value="off" checked="checked"/></p></td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Hvornår?</td>
                                    <td><input type="date" name="<%="damagedDate" + i%>"></td>
                                    <td>Hvor?</td>
                                    <td><input type="text" name="<%="damagePlaceText" + i%>" value ="<%= (request.getParameter("damagePlaceText" + i) == null ? "" : request.getParameter("damagePlaceText" + i))%>"
                                               ></td>
                                </tr>
                                <tr>
                                    <td>Hvad er der sket?</td>
                                    <td><input type="text" name="<%="damageCauseText" + i%>" value ="<%= (request.getParameter("damageCauseText" + i) == null ? "" : request.getParameter("damageCauseText" + i))%>"
                                               ></td>
                                    <td>Hvad er repereret?</td>
                                    <td><input type="text" name="<%="reperationText" + i%>" value ="<%= (request.getParameter("reperationText" + 1) == null ? "" : request.getParameter("reperationText" + 1))%>"
                                               ></td>
                                </tr>
                                <tr>
                                    <td>Skade</td>
                                    <td colspan="3"><p><input type="checkbox" name="<%="moistCheck" + i%>" />Fugt</p>
                                        <p><input type="checkbox" name="<%="rotCheck" + i%>" />Råd og Svamp</p>
                                        <p><input type="checkbox" name="<%="moldCheck" + i%>" />Skimmel</p>
                                        <p><input type="checkbox" name="<%="fireCheck" + i%>" />Brand</p>
                                        <p><input type="checkbox" name="<%="otherDamageCheck" + i%>" />Anden skade:</p>
                                        <input type="text" name="<%="otherDamageCheck" + i%>" size="64" value ="<%= (request.getParameter("otherDamageText" + 1) == null ? "" : request.getParameter("otherDamageText" + 1))%>"> </td>

                                </tr>
                            </tbody>
                        </table>                                                                                        
                        <p><b>Gennemgang af...</b></p>
                        <p><b>Note</b>: For at kunne uploade et billede til rapporten, skal 'Bemærkninger' afmærkes. </p>

                        <table border="1">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>Bemærkninger</th>
                                    <th>Ingen bemærkninger</th>

                                    <th>Billede</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Vægge</td>
                                    <td><input type="radio" value="on" name="<%="wallCommentCheck" + i%>" /></td>
                                    <td><input type="radio" value="off" name="<%="wallCommentCheck" + i%>" checked="checked"/></td>
                                    <td><input type = "file" name="wallImage" accept="image/x-png, image/gif, image/jpeg"/></td>
                                </tr>
                                <tr>
                                    <td colspan="4"><input type="text" name="<%="wallCommentText" + i%>" size="80" value ="<%= (request.getParameter("wallCommentText" + i) == null ? "" : request.getParameter("wallCommentText" + i))%>"
                                                           > </td>
                                </tr>
                                <tr>
                                    <td>Loft</td>
                                    <td><input type="radio" value="on" name="<%="ceilingCommentCheck" + i%>"/></td>
                                    <td><input type="radio" value="off" name="<%="ceilingCommentCheck" + i%>" checked="checked"/></td>
                                    <td><input type = "file" name="Ceilingimage" accept="image/x-png, image/gif, image/jpeg"/></td>
                                </tr>
                                <tr>
                                    <td colspan="4"><input type="text" name="<%="ceilingCommentText" + i%>" size="80" value ="<%= (request.getParameter("ceilingCommentText" + i) == null ? "" : request.getParameter("ceilingCommentText" + i))%>"
                                                           > </td>
                                </tr>
                                <tr>
                                    <td>Gulv</td>
                                    <td><input type="radio" value="on" name="<%="floorCommentCheck" + i%>"/></td>
                                    <td><input type="radio" value="off" name="<%="floorCommentCheck" + i%>" checked="checked"/></td>
                                    <td><input type = "file" name="floorimage" accept="image/x-png, image/gif, image/jpeg"/></td>
                                </tr>
                                <tr>
                                    <td colspan="4"><input type="text" name="<%="floorCommentText" + i%>" size="80" value ="<%= (request.getParameter("floorCommentText" + i) == null ? "" : request.getParameter("floorCommentText" + i))%>"
                                                           > </td>
                                </tr>
                                <tr>
                                    <td>Vinduer/døre</td>
                                    <td><input type="radio" value="on" name="<%="doorCommentCheck" + i%>"/></td>
                                    <td><input type="radio" value="off" name="<%="doorCommentCheck" + i%>" checked="checked"/></td>
                                    <td><input type = "file" name="doorimage" accept="image/x-png, image/gif, image/jpeg"/></td>
                                </tr>
                                <tr>
                                    <td colspan="4"><input type="text" name="<%="doorCommentText" + i%>" size="80" value ="<%= (request.getParameter("doorCommentText" + i) == null ? "" : request.getParameter("doorCommentText" + i))%>"
                                                           > </td>
                                </tr>
                            </tbody>
                        </table>


                        <p><b>Fugtscanning</b></p>
                        <table border="1">
                            <thead>
                                <tr>
                                    <td>Er der foretaget fugtscanning?</td>
                                    <td>Ja<input type="radio" name="<%="scanCheck" + i%>" value="on"/></td>
                                    <td colspan="2">Nej<input type="radio" name="<%="scanCheck" + i%>" value="off" checked="checked"/></td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Fugtscanning:</td>
                                    <td><input type="text" name="<%="moistText" + i%>" value ="<%= (request.getParameter("moistText" + i) == null ? "" : request.getParameter("moistText" + i))%>"
                                               /></td>
                                    <td>Målepunkt:</td>
                                    <td><input type="text" name="<%="measureText" + i%>" value ="<%= (request.getParameter("measureText" + i) == null ? "" : request.getParameter("measureText" + i))%>"
                                               /></td>
                                </tr>
                                <tr>
                                    <td colspan="4"><input type="text" name="<%="moistScanText" + i%>" size="90" value ="<%= (request.getParameter("moistScanText" + i) == null ? "" : request.getParameter("moistScanText" + i))%>"
                                                           /></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <%}%>

                    <div class="conclusion">
                        <p><b>Konklusion</b></p>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th><b>Lokale</b></th>
                                    <th><b>Anbefalinger</b></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="text" name="conlusionRoomText1" value ="<%= (request.getParameter("conlusionRoomText1") == null ? "" : request.getParameter("conlusionRoomText1"))%>"
                                               /></td>
                                    <td><input type="text" name="conlusionRecomText1" value ="<%= (request.getParameter("conlusionRecomText1") == null ? "" : request.getParameter("conlusionRecomText1"))%>"
                                               /></td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="conlusionRoomText2" value ="<%= (request.getParameter("conlusionRoomText2") == null ? "" : request.getParameter("conlusionRoomText2"))%>"
                                               /></td>
                                    <td><input type="text" name="conlusionRecomText2" value ="<%= (request.getParameter("conlusionRecomText2") == null ? "" : request.getParameter("conlusionRecomText2"))%>"
                                               /></td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="conlusionRoomText3" value ="<%= (request.getParameter("conlusionRoomText3") == null ? "" : request.getParameter("conlusionRoomText3"))%>"
                                               /></td>
                                    <td><input type="text" name="conlusionRecomText3" value ="<%= (request.getParameter("conlusionRecomText3") == null ? "" : request.getParameter("conlusionRecomText3"))%>"
                                               /></td>
                                </tr>
                            </tbody>
                        </table>
                        <p>Bygningsgennemgangen er foretaget af </p><input type="text" name="technicianText" value ="<%= (request.getParameter("technicianText") == null ? "" : request.getParameter("technicianText"))%>"/>, Polygon
                        i samarbejde med </p><input type="text" name="responsibleText" value ="<%= (request.getParameter("responsibleText") == null ? "" : request.getParameter("responsibleText"))%>"/> <p>(bygningsansvarlig).
                        </p>
                        <p><b>Bygningen er kategoriseret som</b></p>
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
                                    <td><input type="radio" value="0" name="stateCheck" checked="checked"/></td>
                                </tr>
                                <tr>
                                    <td><b>Tilstandsgrad 1</b></td>
                                    <td>Bygningsdelen er intakt, men med<br>
                                        begyndende slid og synlige skader<br>
                                        (kun kosmetiske skader)</td>
                                    <td>Funktionen er som beskrevet</td>
                                    <td><input type="radio" value="1" name="stateCheck"/></td>
                                </tr>
                                <tr>
                                    <td><b>Tilstandsgrad 2</b></td>
                                    <td>Bygningsdelen er begyndt at forfalde<br>
                                        med enkelte defekte komponenter</td>
                                    <td>Funktionen er nedsat-<br>
                                        fare for følgeskader</td>
                                    <td><input type="radio" value="2" name="stateCheck"/></td>
                                </tr>
                                <tr>
                                    <td><b>Tilstandsgrad 3</b></td>
                                    <td>Bygningsdelen er nedbrugt og skal<br>
                                        udskiftes</td>
                                    <td>Funktionen er ophørt-<br>
                                        fare for følgeskader</td>
                                    <td><input type="radio" value="3" name="stateCheck"/></td>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                        <input type="hidden" name="do_this" value="useButton" />
                        <input type="submit" value="Opret rapport" name="button" />
                        <br>
                        <br>
                        <br>
                    </div>
            </form>
        </div>
    </body>
</html>