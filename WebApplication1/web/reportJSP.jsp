<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="reportCSS.css">
        <title>JSP Page</title>

    </head>
    <body>
        <div class="report">
            <form id="myForm" action="ControllerServlet" method="GET">
                <div class="frontPage">
                    <h1>Udfyld rapport</h1> 
                    <label for="reportNR">Rapport nummer: </label>
                    <input type="number" id="reportNR" name="reportNRtext">
                    <label for="buildingName">Navn på bygning:</label>
                    <input id="buildingName" type="text" name="buildingNameText"
                           value ="<%= (request.getParameter("buildingNameText") == null ? "" : request.getParameter("buildingNameText"))%>">
                    <label for="date">Dato:</label>
                    <input id="date" type="date" name="dateDate">
                    <label for="adresse">Adresse: </label>
                    <input id="adresse" type="text" name="adressText"
                           value ="<%= (request.getParameter("adressText") == null ? "" : request.getParameter("adressText"))%>">
                    <label for="zip">Postnr./by: </label>
                    <input id="zip" type="text" name="zipText"
                           value ="<%= (request.getParameter("zipText") == null ? "" : request.getParameter("zipText"))%>">

                    <label><b>Generel information om bygningen</b></label>

                    <label for="buildYear"> Byggeår</label>
                    <input id="buildYear" type="number" name="buildYearNum">
                    <label for="buildArea">Bygningsareal i m<sup>2</sup> <br>
                        (hver etage tælles seperat)</label>
                    <input id="buildArea" type="number" name="buildingAreaNum">
                    <label for="usage">Hvad bruges bygningen til/<br>
                        hvad har bygningen været brugt til? </label>
                    <input id="usage" type="text" name="usageText" size="50" value ="<%= (request.getParameter("usageText") == null ? "" : request.getParameter("usageText"))%>">
                    <label><b>Gennemgang af bygningen udvendig</b></label>
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
                                <td><input type="checkbox" name="roofCommentCheck"></td>
                                <td><input type="checkbox" name="roofNoCommentCheck"></td>
                                <td><input type="checkbox" name="roofPictureCheck"></td>
                            </tr>
                            <tr>
                                <td colspan="4"><input type="text" name="roofText" size="90" value ="<%= (request.getParameter("roofText") == null ? "" : request.getParameter("roofText"))%>"
                                                       ></td>
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

                                <td><input type="checkbox" name="outerWallCommentCheck"></td>
                                <td><input type="checkbox" name="outerWallNoCommentCheck" ></td>
                                <td><input type="checkbox" name="outerWallPictureCheck" ></td>

                            </tr>
                            <tr>
                                <td colspan="4"><input type="text" name="outerWallText" size="90" 
                                    value ="<%= (request.getParameter("outerWallText") == null ? "" : request.getParameter("outerWallText"))%>"></td>
                            </tr>

                        </tbody>
                    </table>
                </div>
                <div class="reportPage">
                    <h2> Rapport side <input type="number" name="numberOfReportPages"></h2>
                    <input type="submit"  value="updatePageNr" name="button" />
                    <input type="hidden" name ="do_this" value="useButton">

                    <p>Rapport nummer: <input type="number" name="reportNRNum"></p>
                        <% int pages = 0;
                            pages += Integer.parseInt((String) request.getAttribute("numberOfPages"));
                            for (int i = 1; i < pages + 1; i++)
                            {
                                
                        %>
                    <table border="1">
                        <thead>
                            <tr>
                                <td>Har der været<br>
                                    skade i lokalet?</td>
                                <td colspan="3"><p> Ja <input type="radio" name="<%="damageCheck"+i%>" /></p>
                                    <p> Nej <input type="radio" name="<%="damageCheck"+i%>"/></p></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Hvornår?</td>
                                <td><input type="date" name="<%="damagedDate"+i%>"></td>
                                <td>Hvor?</td>
                                <td><input type="text" name="<%="damagePlaceText"+i%>" value ="<%= (request.getParameter("damagePlaceText"+i) == null ? "" : request.getParameter("damagePlaceText"+i))%>"
                                           ></td>
                            </tr>
                            <tr>
                                <td>Hvad er der sket?</td>
                                <td><input type="text" name="<%="damageCauseText"+i%>" value ="<%= (request.getParameter("damageCauseText"+i) == null ? "" : request.getParameter("damageCauseText"+i))%>"
                                           ></td>
                                <td>Hvad er repereret?</td>
                                <td><input type="text" name="<%="reperationText"+i%>" value ="<%= (request.getParameter("reperationText"+1) == null ? "" : request.getParameter("reperationText"+1))%>"
                                           ></td>
                            </tr>
                            <tr>
                                <td>Skade</td>
                                <td colspan="3"><p><input type="checkbox" name="<%="moistCheck"+i%>" />Fugt</p>
                                    <p><input type="checkbox" name="<%="rotCheck"+i%>" />Råd og Svamp</p>
                                    <p><input type="checkbox" name="<%="moldCheck"+i%>" />Skimmel</p>
                                    <p><input type="checkbox" name="<%="fireCheck"+i%>" />Brand</p>
                                    <p><input type="checkbox" name="<%="otherDamageCheck"+i%>" />Anden skade:</p>  <input type="text" name="<%="otherDamageCheck"+i%>" size="64" value ="<%= (request.getParameter("otherDamageText"+1) == null ? "" : request.getParameter("otherDamageText"+1))%>"
                                                                                                                 > </td>

                            </tr>
                        </tbody>
                    </table>                                                                                        >
                    <p><b>Gennemgang af...</b></p>
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
                                <td><input type="checkbox" name="<%="wallCommentCheck"+i%>"/></td>
                                <td><input type="checkbox" name="<%="wallNoCommentCheck"+i%>"/></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td colspan="4"><input type="text" name="<%="wallCommentCheckText"+i%>" size="80" value ="<%= (request.getParameter("wallCommentText"+i) == null ? "" : request.getParameter("wallCommentText"+i))%>"
                                                       > </td>
                            </tr>
                            <tr>
                                <td>Loft</td>
                                <td><input type="checkbox" name="<%="ceilingCommentCheck"+i%>"/></td>
                                <td><input type="checkbox" name="<%="ceilingNoCommentCheck"+i%>"/></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td colspan="4"><input type="text" name="<%="ceilingCommentText"+i%>" size="80" value ="<%= (request.getParameter("ceilingCommentText"+i) == null ? "" : request.getParameter("ceilingCommentText"+i))%>"
                                                       > </td>
                            </tr>
                            <tr>
                                <td>Gulv</td>
                                <td><input type="checkbox" name="<%="floorCommentCheck"+i%>"/></td>
                                <td><input type="checkbox" name="<%="floorNoCommentCheck"+i%>"/></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td colspan="4"><input type="text" name="<%="floorCommentText"+i%>" size="80" value ="<%= (request.getParameter("floorCommentText"+i) == null ? "" : request.getParameter("floorCommentText"+i))%>"
                                                       > </td>
                            </tr>
                            <tr>
                                <td>Vinduer/døre</td>
                                <td><input type="checkbox" name="<%="doorCommentCheck"+i%>"/></td>
                                <td><input type="checkbox" name="<%="doorNoCommentCheck"+i%>"/></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td colspan="4"><input type="text" name="<%="doorCommentText"+i%>" size="80" value ="<%= (request.getParameter("doorCommentText"+i) == null ? "" : request.getParameter("doorCommentText"+i))%>"
                                                       > </td>
                            </tr>
                        </tbody>
                    </table>


                    <p><b>Fugtscanning</b></p>
                    <table border="1">
                        <thead>
                            <tr>
                                <td>Er der foretaget fugtscanning?</td>
                                <td><input type="checkbox" name="<%="scanYesCheck"+i%>"/></td>
                                <td colspan="2"><input type="checkbox" name="<%="scanNoCheck"+i%>"/></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Fugtscanning:</td>
                                <td><input type="text" name="<%="moistText"+i%>" value ="<%= (request.getParameter("moistText"+i) == null ? "" : request.getParameter("moistText"+i))%>"
                                           /></td>
                                <td>Målepunkt:</td>
                                <td><input type="text" name="<%="measureText"+i%>" value ="<%= (request.getParameter("measureText"+i) == null ? "" : request.getParameter("measureText"+i))%>"
                                           /></td>
                            </tr>
                            <tr>
                                <td colspan="4"><input type="text" name="<%="moistScanText"+i%>" size="90" value ="<%= (request.getParameter("moistScanText"+i) == null ? "" : request.getParameter("moistScanText"+i))%>"
                                                       /></td>
                            </tr>
                        </tbody>
                    </table>
                    <%}%>
                </div>
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
                    <p>Bygningsgennemgangen er foretaget af <input type="text" name="technicianText" value ="<%= (request.getParameter("technicianText") == null ? "" : request.getParameter("technicianText"))%>"
                                                                   />, Polygon
                        i samarbejde med <input type="text" name="responsibleText" value ="<%= (request.getParameter("responsibleText") == null ? "" : request.getParameter("responsibleText"))%>"
                                                /> (bygningsansvarlig).
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
                                <td><input type="checkbox" name="state0Check"/></td>
                            </tr>
                            <tr>
                                <td><b>Tilstandsgrad 1</b></td>
                                <td>Bygningsdelen er intakt, men med<br>
                                    begyndende slid og synlige skader<br>
                                    (kun kosmetiske skader)</td>
                                <td>Funktionen er som beskrevet</td>
                                <td><input type="checkbox" name="state1Check"/></td>
                            </tr>
                            <tr>
                                <td><b>Tilstandsgrad 2</b></td>
                                <td>Bygningsdelen er begyndt at forfalde<br>
                                    med enkelte defekte komponenter</td>
                                <td>Funktionen er nedsat-<br>
                                    fare for følgeskader</td>
                                <td><input type="checkbox" name="state2Check"/></td>
                            </tr>
                            <tr>
                                <td><b>Tilstandsgrad 3</b></td>
                                <td>Bygningsdelen er nedbrugt og skal<br>
                                    udskiftes</td>
                                <td>Funktionen er ophørt-<br>
                                    fare for følgeskader</td>
                                <td><input type="checkbox" name="state3Check"/></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="submit" value="createReport" name="button" />
                </div>
            </form>
        </div>
    </body>
</html>