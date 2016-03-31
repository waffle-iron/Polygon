<%-- 
    Document   : reportJSP
    Created on : 30-03-2016, 10:23:16
    Author     : Bruger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Opret rapport</h1> 
        <form>
            <h2> Rapport forside </h2>
            <p>Rapport nummer: <input type="number" name="reportNRtext"></p>
            <p>Navn på bygning: <input type="text" name="buildingNameText"></p>
            <p>Dato: <input type="date" name="dateDate"></p>
            <p>Adresse: <input type="text" name="adressText"></p>
            <p>Postnr./by: <input type="text" name="zipText"></p>

            <p><b>Generel information om bygningen</b></p>
            <p>Byggeår <input type="number" name="buildYearNum"></p>
            <p>Bygningsareal i m<sup>2</sup> <br>
                (hver etage tælles seperat) <input type="number" name="buildingAreaNum"></p>
            <p>Hvad bruges bygningen til/<br>
                hvad har bygningen hveret brugt til <input type="text" name="usageText"></p>
            <p><b>Gennemgang af bygningen udvendig</b></p>
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
                        <td colspan="4"><input type="text" name="roofText" size="90"></td>
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
                        <td><input type="checkbox" name="outerWallNoCommentCheck"></td>
                        <td><input type="checkbox" name="outerWallPictureCheck"></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="text" name="outerWallText" size="90"></td>
                    </tr>
                </tbody>
            </table>

            <form action="ControllerServlet" method="GET">
                <h2> Rapport side <input type="number" name="numberOfReportPages"></h2><input type="submit" value="Opdater" name="updatePageNum" />
                <input type="hidden" name="do_this" value="updatePageNum"/>
            </form>
            <p> Rapport side nummer (hent automatisk?)</p>
            <p>Rapport nummer: <input type="number" name="reportNRNum"></p>
            <table border="1">
                <thead>
                    <tr>
                        <td>Har der været<br>
                            skade i lokalet?</td>
                        <td colspan="3"><p> Ja <input type="checkbox" name="damageCheckYes" /></p>
                            <p> Nej <input type="checkbox" name="damageCheckNo"/></p></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Hvornår</td>
                        <td><input type="date" name="damageDate"></td>
                        <td>Hvor</td>
                        <td><input type="text" name="damagePlaceText"></td>
                    </tr>
                    <tr>
                        <td>Hvad er der sket</td>
                        <td><input type="text" name="damageCauseText"></td>
                        <td>Hvad er repereret</td>
                        <td><input type="text" name="reperationText"></td>
                    </tr>
                    <tr>
                        <td>Skade</td>
                        <td colspan="3"><p><input type="checkbox" name="moistCheck" />Fugt</p>
                            <p><input type="checkbox" name="rotCheck" />Råd og Svamp</p>
                            <p><input type="checkbox" name="moldCheck" />Skimmel</p>
                            <p><input type="checkbox" name="fireCheck" />Brand</p>
                            <p><input type="checkbox" name="otherDamageCheck" />Anden skade:</p>  <input type="text" name="otherDamageText"> </td>

                    </tr>
                </tbody>
            </table>

            <p><b>Skade:</b> </p>
            <p><input type="checkbox" name="moistCheck" />Fugt</p>
            <p><input type="checkbox" name="rotCheck" />Råd og Svamp</p>
            <p><input type="checkbox" name="moldCheck" />Skimmel</p>
            <p><input type="checkbox" name="fireCheck" />Brand</p>
            <p><input type="checkbox" name="otherDamageCheck" />Anden skade:</p>  <input type="text" name="otherDamageText">
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
                        <td><input type="checkbox" name="wallCommentCheck"/></td>
                        <td><input type="checkbox" name="wallNoCommentCheck"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="text" name="wallCommentText" size="80"> </td>
                    </tr>
                    <tr>
                        <td>Loft</td>
                        <td><input type="checkbox" name="ceilingCommentCheck"/></td>
                        <td><input type="checkbox" name="ceilingNoCommentCheck"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="text" name="ceilingCommentText" size="80"> </td>
                    </tr>
                    <tr>
                        <td>Gulv</td>
                        <td><input type="checkbox" name="floorCommentCheck"/></td>
                        <td><input type="checkbox" name="floorNoCommentCheck"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="text" name="floorCommentText" size="80"> </td>
                    </tr>
                    <tr>
                        <td>Vinduer/døre</td>
                        <td><input type="checkbox" name="doorCommentCheck"/></td>
                        <td><input type="checkbox" name="doorNoCommentCheck"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="text" name="doorCommentText" size="80"> </td>
                    </tr>
                </tbody>
            </table>


            <p><b>Fugtscanning</b></p>
            <table border="1">
                <thead>
                    <tr>
                        <td>Er der foretaget fugtscanning?</td>
                        <td><input type="checkbox" name="scanYesCheck"/></td>
                        <td colspan="2"><input type="checkbox" name="scanNoCheck"/></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Fugtscanning:</td>
                        <td><input type="text" name="moistText"/></td>
                        <td>Målepunkt:</td>
                        <td><input type="text" name="measureText"/></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="text" name="moistScanText" size="90"/></td>
                    </tr>
                </tbody>
            </table>

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
                        <td><input type="text" name="conlusionRoomText1"/></td>
                        <td><input type="text" name="conlusionRecomText1"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="conlusionRoomText2"/></td>
                        <td><input type="text" name="conlusionRecomText2"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="conlusionRoomText3"/></td>
                        <td><input type="text" name="conlusionRecomText3"/></td>
                    </tr>
                </tbody>
            </table>
            <p>Bygningsgennemgangen er foretaget af<input type="text" name="technicianText"/>, <br>Polygon
                i samarbejde med <input type="text" name="responsibleText"/>(bygningsansvarlig).
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

            <input type="hidden" name="do_this" value="createBuild"/>
            <input type="submit" value="opret" name="createBuild" />
        </form>

    </body>
</html>