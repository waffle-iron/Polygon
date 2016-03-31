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
        <form action="ControllerServlet" method="GET">

            <h2> Rapport forside </h2>
            <p>Rapport nummer: <input type="number" name="reportNRtext"></p>
            <p>Bygnings ID: <input type="number" name="buildingIDtext"></p>
            <p>Dato: <input type="date" name="date"></p>
            <p>Stand: <input type="text" name="state"></p>

            <input type="text" name="state">
            <h2> Rapport side </h2><input type="submit" value="Opret" name="submitPageNR" />
            <p> Rapport side nummer (hent automatisk?)</p>
            <p>Rapport nummer: <input type="text" name="reportNR"></p>
            <p>Har der været skade i lokalet?: </p> 
            <p> Ja <input type="checkbox" name="Ja" value="Yes" /></p>
            <p> Nej <input type="checkbox" name="Nej" value="No" /></p>
            <p>Hvornår: <input type="text" name="damagedate"></p>
            <p>Hvor: <input type="text" name="damagedPlace"></p>
            <p>Hvad er der sket: <input type="text" name="cause"></p>
            <p><b>Skade:</b> </p>
            <p><input type="checkbox" name="Ja" value="Yes" />Fugt</p>
            <p><input type="checkbox" name="Ja" value="Yes" />Råd og Svamp</p>
            <p><input type="checkbox" name="Ja" value="Yes" />Skimmel</p>
            <p><input type="checkbox" name="Ja" value="Yes" />Brand</p>
            <p><input type="checkbox" name="Ja" value="Yes" />Anden skade:</p>  <input type="text" name="damagedPlace">
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
                        <td><input type="checkbox" name="comment" value="comm1" /></td>
                        <td><input type="checkbox" name="comment" value="comm1" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="text" name="wallText" size="80"> </td>
                    </tr>
                    <tr>
                        <td>Loft</td>
                        <td><input type="checkbox" name="comment" value="comm1" /></td>
                        <td><input type="checkbox" name="comment" value="comm1" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="text" name="ceilingText" size="80"> </td>
                    </tr>
                    <tr>
                        <td>Gulv</td>
                        <td><input type="checkbox" name="comment" value="comm1" /></td>
                        <td><input type="checkbox" name="comment" value="comm1" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="text" name="floorText" size="80"> </td>
                    </tr>
                    <tr>
                        <td>Vinduer/døre</td>
                        <td><input type="checkbox" name="comment" value="comm1" /></td>
                        <td><input type="checkbox" name="comment" value="comm1" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="text" name="doorText" size="80"> </td>
                    </tr>
                </tbody>
            </table>

            
            <p><b>Fugtscanning</b></p>
            <table border="1">
                <thead>
                    <tr>
                        <td>Er der foretaget fugtscanning?</td>
                        <td><input type="checkbox" name="scanYesCheck" value="Yes"/></td>
                        <td colspan="2"><input type="checkbox" name="scanNoCheck" value="No"/></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Fugtscanning:</td>
                        <td><input type="text" name="moist"/></td>
                        <td>Målepunkt:</td>
                        <td><input type="text" name="measure"/></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="text" name="measure" size="90"/></td>
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
                        <td><input type="text" name="room"/></td>
                        <td><input type="text" name="recommandation"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="room"/></td>
                        <td><input type="text" name="recommandation"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="room"/></td>
                        <td><input type="text" name="recommandation"/></td>
                    </tr>
                </tbody>
            </table>
            <p>Bygningsgennemgangen er foretaget af<input type="text" name=""/>, <br>Polygon
                i samarbejde med <input type="text" name=""/>(bygningsansvarlig).
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
                        <td><input type="checkbox" name=""/></td>
                    </tr>
                    <tr>
                        <td><b>Tilstandsgrad 1</b></td>
                        <td>Bygningsdelen er intakt, men med<br>
                            begyndende slid og synlige skader<br>
                            (kun kosmetiske skader)</td>
                        <td>Funktionen er som beskrevet</td>
                        <td><input type="checkbox" name=""/></td>
                    </tr>
                    <tr>
                        <td><b>Tilstandsgrad 2</b></td>
                        <td>Bygningsdelen er begyndt at forfalde<br>
                            med enkelte defekte komponenter</td>
                        <td>Funktionen er nedsat-<br>
                            fare for følgeskader</td>
                        <td><input type="checkbox" name=""/></td>
                    </tr>
                    <tr>
                        <td><b>Tilstandsgrad 3</b></td>
                        <td>Bygningsdelen er nedbrugt og skal<br>
                            udskiftes</td>
                        <td>Funktionen er ophørt-<br>
                            fare for følgeskader</td>
                        <td><input type="checkbox" name=""/></td>
                    </tr>
                </tbody>
            </table>

            <input type="hidden" name="do_this" value="createBuild"/>
            <input type="submit" value="opret" name="createBuild" />

        </form>
    </body>
</html>