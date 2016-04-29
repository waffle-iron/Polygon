drop database if exists grp01;
create database grp01;
use grp01;
DROP TABLE IF EXISTS picturelink;
DROP TABLE IF EXISTS conclusion;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS reportPage;
DROP TABLE IF EXISTS report; 
DROP TABLE IF EXISTS building;
DROP TABLE IF EXISTS zip;
DROP TABLE IF EXISTS login;
DROP TABLE IF EXISTS firm;


CREATE TABLE `firm`
(
	`FirmID` int not null AUTO_INCREMENT,
    `ContactNumber` int,
    `ContactMail` varchar(60) unique,
    primary key(`FirmID`)
);

CREATE TABLE `login`
(
	`Username` 	varchar(30) not null,
    `Password` 	varchar(30) not null,
    `FirmID`	int,
	`Authorization` ENUM('tech', 'admin', 'user'),
    primary key (`Username`),
    foreign key (`FirmID`)
		references `Firm` (`FirmID`)
        ON DELETE CASCADE
);
CREATE TABLE `zip`
(
	`Zip` int,
    `City` varchar(50),
    primary key (`Zip`)
);
CREATE TABLE `building`
(
	`BuildingID` int not null AUTO_INCREMENT,
    `Address` varchar(50) not null,
    `Zip` int not null,
    `FirmID` int not null,
    `Name` varchar(25),
    `BuildingYear` int,
    `Size` int,
    `Usage` varchar(100),
    primary key(`BuildingID`),
    foreign key (`FirmID`)
		references `Firm` (`FirmID`)
        ON DELETE CASCADE
);
CREATE TABLE `report`
(
	`ReportNR` int not null AUTO_INCREMENT,
    `BuildingID` int,
    `Date` date,
    `StateNR` int,
    primary key (`ReportNR`)
);

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
        ON DELETE CASCADE
    
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
		references `Report` (`ReportNR`)
        ON DELETE CASCADE,
    foreign key (`ReportPageNr`)
		references `ReportPage` (`ReportPageNr`)
        ON DELETE CASCADE
);
CREATE TABLE `conclusion`
(
     `ReportNR` int not null,
     `Room`	varchar(10),
     `Recomandation` varchar(200),
     foreign key (`ReportNR`)
		references `Report` (`ReportNR`)
        ON DELETE CASCADE
);
CREATE TABLE `picturelink`
(
	 `PictureID` int auto_increment,
     `CommentID` int,
     `Picture` blob,
     primary key (`PictureID`),
     foreign key (`CommentID`)
     references `comments`(`CommentID`)
     ON DELETE CASCADE

);
insert into `firm` (`ContactNumber`,`ContactMail`) values(1001,"admin@firmsareus.com"); 
insert into `login` (`Username`,`Password`,`FirmID`,`Authorization`) values("admin","password",1,'admin');
