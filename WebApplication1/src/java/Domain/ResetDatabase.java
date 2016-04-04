/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author peter L Lange
 */
public class ResetDatabase
{
    public static void Reset()
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            statement.executeLargeUpdate(
"DROP TABLE IF EXISTS pictures;\n" +
"DROP TABLE IF EXISTS conclusion;\n" +
"DROP TABLE IF EXISTS comments;\n" +
"DROP TABLE IF EXISTS reportPage;\n" +
"DROP TABLE IF EXISTS report; \n" +
"DROP TABLE IF EXISTS building;\n" +
"DROP TABLE IF EXISTS zip;\n" +
"DROP TABLE IF EXISTS login;\n" +
"DROP TABLE IF EXISTS firm;\n" +
"\n" +
"\n" +
"CREATE TABLE `firm`\n" +
"(\n" +
"	`FirmID` int not null AUTO_INCREMENT,\n" +
"    `ContactNumber` int,\n" +
"    `ContactMail` varchar(60) unique,\n" +
"    primary key(`FirmID`)\n" +
"        \n" +
"    \n" +
"    \n" +
");\n" +
"\n" +
"CREATE TABLE `login`\n" +
"(\n" +
"	`Username` 	varchar(30) not null,\n" +
"    `Password` 	varchar(30) not null,\n" +
"    `FirmID`	int,\n" +
"	`Authorization` ENUM('tech', 'admin', 'user'),\n" +
"    primary key (`Username`),\n" +
"    foreign key (`FirmID`)\n" +
"		references `Firm` (`FirmID`)\n" +
");\n" +
"CREATE TABLE `zip`\n" +
"(\n" +
"	`Zip` int,\n" +
"    `City` varchar(50),\n" +
"    primary key (`Zip`)\n" +
");\n" +
"CREATE TABLE `building`\n" +
"(\n" +
"	`BuildingID` int not null AUTO_INCREMENT,\n" +
"    `Address` varchar(50) not null,\n" +
"    `Zip` int not null,\n" +
"    `FirmID` int not null,\n" +
"    `Name` varchar(25),\n" +
"    `BuildingYear` int,\n" +
"    `Size` int,\n" +
"    `Usage` varchar(100),\n" +
"    primary key(`BuildingID`),\n" +
"    foreign key (`FirmID`)\n" +
"		references `Firm` (`FirmID`)\n" +
");\n" +
"CREATE TABLE `report`\n" +
"(\n" +
"	`ReportNR` int not null AUTO_INCREMENT,\n" +
"    `BuildingID` int,\n" +
"    `Date` date,\n" +
"    `StateNR` int,\n" +
"    primary key (`ReportNR`)\n" +
");\n" +
"\n" +
"CREATE TABLE `reportPage`\n" +
"(\n" +
"	`ReportPageNr` int not null AUTO_INCREMENT,\n" +
"    `ReportNR` int not null,\n" +
"    `PreviousDamaged` boolean,\n" +
"    `Damagedate` date,\n" +
"    `DamagedPlace` varchar(50),\n" +
"    `Cause` varchar(100),\n" +
"    `Repairs` varchar(100),\n" +
"    `Moist` boolean,\n" +
"    `Rot` boolean,\n" +
"    `Mold` boolean,\n" +
"    `Fire` boolean,\n" +
"    `Other` varchar(100),\n" +
"    `MoistScan` boolean,\n" +
"    primary key (`ReportPageNr`),\n" +
"	foreign key(`ReportNR`)\n" +
"		references `Report` (`ReportNR`)\n" +
"    \n" +
");\n" +
"CREATE TABLE `comments`\n" +
"(	\n" +
"	`CommentID`	int not null AUTO_INCREMENT,\n" +
"	`ReportNR` 	int not null,\n" +
"    `ReportPageNr` int,\n" +
"    `CommentType` varchar(15),\n" +
"    `Text` varchar(500),\n" +
"    primary key (`CommentID`),\n" +
"    foreign key (`ReportNR`)\n" +
"		references `Report` (`ReportNR`),\n" +
"    foreign key (`ReportPageNr`)\n" +
"		references `ReportPage` (`ReportPageNr`)\n" +
");\n" +
"CREATE TABLE `conclusion`\n" +
"(\n" +
"     `ReportNR` int not null,\n" +
"     `Room`	varchar(10),\n" +
"     `Recomandation` varchar(200),\n" +
"     foreign key (`ReportNR`)\n" +
"		references `Report` (`ReportNR`)\n" +
");\n" +
"CREATE TABLE `picturelink`\n" +
"(\n" +
"     `PictureID` int auto_increment,\n" +
"     `Picture` blob,\n" +
"     primary key (`pictureID`)\n" +
"\n" +
");\n" +
"CREATE TABLE `pictures`\n" +
"(\n" +
"	`CommentID` int,\n" +
"    `ReportNR` int,\n" +
"    `BuildingID` int,\n" +
"    `PictureID` int ,\n" +
"    primary key (`CommentID`),\n" +
"	foreign key (`CommentID`)\n" +
"		references `Comments`(`CommentID`),\n" +
"	foreign key (`ReportNR`)\n" +
"		references `Report`(`ReportNR`),\n" +
"	foreign key (`BuildingID`)\n" +
"		references `Building` (`BuildingID`),\n" +
"	foreign key (`PictureID`)\n" +
"		references `picturelink` (`PictureID`)\n" +
");\n" +
"\n" +
"\n" +
"insert into `firm` (`ContactNumber`,`ContactMail`) values(1001,\"admin@firmsareus.com\"); \n" +
"insert into `firm` (`ContactNumber`,`ContactMail`) values(1001,\"support@firming.com\"); \n" +
"insert into `firm` (`ContactNumber`,`ContactMail`) values(1001,\"polygoncontact@thebestfirm.com\");\n" +
"\n" +
"insert into `login` (`Username`,`Password`,`FirmID`,`Authorization`) values(\"anders\",\"132\",1,'tech');\n" +
"insert into `login` (`Username`,`Password`,`FirmID`,`Authorization`) values(\"admin\",\"password\",1,'admin');\n" +
"insert into `login` (`Username`,`Password`,`FirmID`,`Authorization`) values(\"xxxsniper360xxx\",\"snips\",1,'user');\n" +
"\n" +
"insert into `zip` (`Zip`,`City`) values(3600,\"Fredrikssund\"); \n" +
"insert into `zip` (`Zip`,`City`) values(2800,\"Kongens Lyngby\");  \n" +
"\n" +
"insert into `building` (`Address`,`Zip`,`FirmID`,`Name`,`BuildingYear`,`Size`,`Usage`) values(\"Hovedgade 1\",2800,1,\"\",420,10,\"recidence\");  \n" +
"insert into `building` (`Address`,`Zip`,`FirmID`,`Name`,`BuildingYear`,`Size`,`Usage`) values(\"Hovedgade 2\",2800,1,\"\",420,10,\"service\");  \n" +
"\n" +
"insert into `report` (`BuildingID`,`Date`,`StateNR`) values(1,10/10/1990,0);  \n" +
"insert into `report` (`BuildingID`,`Date`,`StateNR`) values(2,10/10/420,0);  \n" +
"\n" +
"insert into `reportPage` (`ReportNR`,`PreviousDamaged`,`Damagedate`,`DamagedPlace`,`Cause`,`Repairs`,`Moist`,`Rot`,`Mold`,`Fire`,`Other`,`MoistScan`)\n" +
" values(1,false,10/10/10,\"thought the roof\",\"slagehammers brake stuff\",\"it a bit leaky so installed bucket\",true,false,false,false,\"\",true);  \n" +
"insert into `reportPage` (`ReportNR`,`PreviousDamaged`,`Damagedate`,`DamagedPlace`,`Cause`,`Repairs`,`Moist`,`Rot`,`Mold`,`Fire`,`Other`,`MoistScan`)\n" +
" values(2,false,10/10/2020,\"right there\",\"unknown\",\"it fine i swear\",false,false,false,false,\"❤❤❤❤❤\",true);\n" +
" insert into `reportPage` (`ReportNR`,`PreviousDamaged`,`Damagedate`,`DamagedPlace`,`Cause`,`Repairs`,`Moist`,`Rot`,`Mold`,`Fire`,`Other`,`MoistScan`)\n" +
" values(2,false,10/10/2020,\"in reactor\",\"mealt down\",\"just keep away\",false,false,false,false,\"☢☢☢☢☢☢\",true);\n" +
"\n" +
"insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values(1,1,\"report comment\",\"don't spin to win in a building\");\n" +
"insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values(2,1,\"report comment\",\"don't spin meat objects in buildings, it not safe\");\n" +
"\n" +
"insert into `conclusion`(`ReportNR`,`Room`,`Recomandation`) values(1,\"kitchen\", \"there are a alot spiders would recommend installing a cat\");\n" +
"insert into `conclusion`(`ReportNR`,`Room`,`Recomandation`) values(2,\"main room\", \"giant hole spoted in floor\");\n" +
"\n" +
"#insert into `pictures`(`CommentID`,`ReportNR`,`BuildingID`,`PictureLink`) values(1,1,1,\"http://imgur.com/gallery/rKaUjEX\");\n" +
"#insert into `pictures`(`CommentID`,`ReportNR`,`BuildingID`,`PictureLink`) values(2,2,2,\"error not sfw\");\n" +
"#insert into `pictures`(`CommentID`,`ReportNR`,`BuildingID`,`PictureLink`) values(1,1,1,\"http://imgur.com/gallery/rKaUjEX\")"
            );
            System.out.println("should be done now");
        }
        catch( Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}