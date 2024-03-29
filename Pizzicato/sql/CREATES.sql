DROP TABLE extratayte;
DROP TABLE tilausrivi;
DROP TABLE tilaus;
DROP TABLE pizzantayte;
DROP TABLE pizza;
DROP TABLE tayte;

CREATE TABLE tayte(
tayte_id int NOT NULL AUTO_INCREMENT,
tayte_hinta decimal(4,2) NOT NULL,
tayte varchar(100),
piilotettutayte boolean NOT NULL default 0,
PRIMARY KEY (tayte_id)
)Engine="InnoDB";

CREATE TABLE pizza(
pizza_id int NOT NULL AUTO_INCREMENT,
nimi varchar(100) NOT NULL,
hinta decimal(4,2) NOT NULL,
piilotettu boolean NOT NULL default 0,
PRIMARY KEY (pizza_id)
)Engine="InnoDB";

CREATE TABLE pizzantayte(
pizza_id int NOT NULL,
tayte_id int NOT NULL,
PRIMARY KEY (pizza_id, tayte_id),
FOREIGN KEY (tayte_id) REFERENCES tayte (tayte_id),
FOREIGN KEY (pizza_id) REFERENCES pizza (pizza_id)
)Engine="InnoDB";

CREATE TABLE tilaus(
tilaus_id int NOT NULL AUTO_INCREMENT,
pvm TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
toimitus boolean NOT NULL default 0,
maksu boolean NOT NULL default 0,
nimi varchar(30) NOT NULL,
osoite varchar(30) NOT NULL,
puh int(10) NOT NULL,
sposti varchar(30) NOT NULL,
PRIMARY KEY (tilaus_id)
)Engine="InnoDB";

CREATE TABLE tilausrivi(
tilausrivi_id int NOT NULL AUTO_INCREMENT,
pizza_id int NOT NULL,
tilaus_id int NOT NULL,
maara int NOT NULL,
extramauste int,
rivihinta double,
PRIMARY KEY (tilausrivi_id, tilaus_id),
FOREIGN KEY (tilaus_id) REFERENCES tilaus (tilaus_id),
FOREIGN KEY (pizza_id) REFERENCES pizza (pizza_id)
)Engine="InnoDB";

CREATE TABLE extratayte(
extratayte_id int NOT NULL AUTO_INCREMENT,
tilausrivi_id int NOT NULL,
tayte_id int NOT NULL,
PRIMARY KEY (extratayte_id),
FOREIGN KEY (tilausrivi_id) REFERENCES tilausrivi (tilausrivi_id),
FOREIGN KEY (tayte_id) REFERENCES tayte (tayte_id)
)Engine="InnoDB";




Login Logout juttuja a la Jamppa

CREATE TABLE kayttaja
(
   id integer primary key,
   username varchar(255) unique,
   password varchar(255),
   logtype varchar(30)
);

