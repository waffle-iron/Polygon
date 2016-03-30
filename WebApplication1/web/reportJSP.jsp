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
            <p>Rapport nummer: <input type="text" name="reportNR"></p>
            <p>Bygnings ID: <input type="text" name="buildingID"></p>
            <p>Dato: <input type="text" name="date"></p>
            <p>Stand: <input type="text" name="state"></p>
            
            <h2> Rapport side </h2>
            <p> Rapport side nummer (hent automatisk?)</p>
            <p>Rapport nummer: <input type="text" name="reportNR"></p>
            <p>Har der været skade i lokalet?: </p>
            <input type="checkbox" name="Ja" value="Yes" />
            <input type="checkbox" name="Nej" value="No" />
            <p>Stand: <input type="text" name="state"></p>
            
            
            <input type="hidden" name="do_this" value="createBuild"/>
            <input type="submit" value="opret" name="createBuild" />

        </form>
    </body>
</html>

CREATE TABLE `reportPage`
(
	`ReportPageNr` int not null AUTO_INCREMENT,
    `ReportNR` int not null,
    `PreviousDamaged` boolean,
    `Damagedate` date,
    `DamagedPlace` varchar(50),
    `Cause` varchar(100),
    `Repairs` varchar(100),
    `Moist` boolean,
    `Rot` boolean,
    `Mold` boolean,
    `Fire` boolean,
    `Other` varchar(100),
    `MoistScan` boolean,
    primary key (`ReportPageNr`),
	foreign key(`ReportNR`)
		references `Report` (`ReportNR`)
    
);
CREATE TABLE `comments`
(	
	`CommentID`	int not null AUTO_INCREMENT,
	`ReportNR` 	int not null,
    `ReportPageNr` int,
    `CommentType` varchar(15),
    `Text` varchar(500),
    primary key (`CommentID`),
    foreign key (`ReportNR`)
		references `Report` (`ReportNR`),
    foreign key (`ReportPageNr`)
		references `ReportPage` (`ReportPageNr`)
);
CREATE TABLE `conclusion`
(
     `ReportNR` int not null,
     `Room`	varchar(10),
     `Recomandation` varchar(200),
     foreign key (`ReportNR`)
		references `Report` (`ReportNR`)
);