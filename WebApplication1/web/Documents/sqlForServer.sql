drop database if exists grp01;
CREATE DATABASE grp01;
use grp01;
DROP TABLE IF EXISTS pictures;
DROP TABLE IF EXISTS conlusion;
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
CREATE TABLE `picturelink`
(
     `PictureID` int auto_increment,
     `Picture` blob,
     primary key (`pictureID`)

);
CREATE TABLE `pictures`
(
	`CommentID` int,
    `ReportNR` int,
    `BuildingID` int,
    `PictureID` int ,
    primary key (`CommentID`),
	foreign key (`CommentID`)
		references `Comments`(`CommentID`),
	foreign key (`ReportNR`)
		references `Report`(`ReportNR`),
	foreign key (`BuildingID`)
		references `Building` (`BuildingID`),
	foreign key (`PictureID`)
		references `picturelink` (`PictureID`)
);


insert into `firm` (`ContactNumber`,`ContactMail`) values(1001,"admin@firmsareus.com"); 
insert into `firm` (`ContactNumber`,`ContactMail`) values(1001,"support@firming.com"); 
insert into `firm` (`ContactNumber`,`ContactMail`) values(1001,"polygoncontact@thebestfirm.com");

insert into `login` (`Username`,`Password`,`FirmID`,`Authorization`) values("anders","132",1,'tech');
insert into `login` (`Username`,`Password`,`FirmID`,`Authorization`) values("admin","password",1,'admin');
insert into `login` (`Username`,`Password`,`FirmID`,`Authorization`) values("xxxsniper360xxx","snips",1,'user');
insert into `login` (`Username`,`Password`,`FirmID`,`Authorization`) values("t","1",1,'tech');
insert into `login` (`Username`,`Password`,`FirmID`,`Authorization`) values("a","1",1,'admin');
insert into `login` (`Username`,`Password`,`FirmID`,`Authorization`) values("u","1",1,'user');
insert into `login` (`Username`,`Password`,`FirmID`,`Authorization`) values("test","test",1,'user');

insert into `zip` (`Zip`,`City`) values(3600,"Fredrikssund"); 
insert into `zip` (`Zip`,`City`) values(2800,"Kongens Lyngby");  

insert into `building` (`Address`,`Zip`,`FirmID`,`Name`,`BuildingYear`,`Size`,`Usage`) values("Hovedgade 1",2800,1,"storkevænget",420,10,"recidence");  
insert into `building` (`Address`,`Zip`,`FirmID`,`Name`,`BuildingYear`,`Size`,`Usage`) values("Hovedgade 2",2800,1,"home",420,10,"service");  

insert into `report` (`BuildingID`,`Date`,`StateNR`) values(1,10/1990/10,0);  
insert into `report` (`BuildingID`,`Date`,`StateNR`) values(2,10/420/10,0);  

insert into `reportPage` (`ReportNR`,`PreviousDamaged`,`Damagedate`,`DamagedPlace`,`Cause`,`Repairs`,`Moist`,`Rot`,`Mold`,`Fire`,`Other`,`MoistScan`)
 values(1,false,10/10/10,"thought the roof","slagehammers brakes stuff","it a bit leaky so installed bucket",true,false,false,false,"",true);  
insert into `reportPage` (`ReportNR`,`PreviousDamaged`,`Damagedate`,`DamagedPlace`,`Cause`,`Repairs`,`Moist`,`Rot`,`Mold`,`Fire`,`Other`,`MoistScan`)
 values(2,false,10/10/2020,"right there","unknown","it fine i swear",false,false,false,false,"❤❤❤❤❤",true);
 insert into `reportPage` (`ReportNR`,`PreviousDamaged`,`Damagedate`,`DamagedPlace`,`Cause`,`Repairs`,`Moist`,`Rot`,`Mold`,`Fire`,`Other`,`MoistScan`)
 values(2,false,10/10/2020,"in reactor","mealt down","just keep away",false,false,false,false,"☢☢☢☢☢☢",true);

insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values(1,1,"report comment","don't spin to win in a building");
insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values(2,1,"report comment","don't spin meat objects in buildings, it not safe");

insert into `conclusion`(`ReportNR`,`Room`,`Recomandation`) values(1,"kitchen", "there are a alot spiders would recommend installing a cat");
insert into `conclusion`(`ReportNR`,`Room`,`Recomandation`) values(2,"main room", "giant hole spoted in floor");

#insert into `pictures`(`CommentID`,`ReportNR`,`BuildingID`,`PictureLink`) values(1,1,1,"http://imgur.com/gallery/rKaUjEX");
#insert into `pictures`(`CommentID`,`ReportNR`,`BuildingID`,`PictureLink`) values(2,2,2,"error not sfw");
#insert into `pictures`(`CommentID`,`ReportNR`,`BuildingID`,`PictureLink`) values(1,1,1,"http://imgur.com/gallery/rKaUjEX")
