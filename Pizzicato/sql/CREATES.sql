DROP TABLE yhdenpizzantilaus;
DROP TABLE tilaus;
DROP TABLE asiakas;
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

CREATE TABLE asiakas(
asiakas_id varchar(12) NOT NULL,
nimi varchar(30) NOT NULL,
osoite varchar(30) NOT NULL,
puh int(10) NOT NULL,
maksutiedot varchar(30),
sposti varchar(30) NOT NULL,
PRIMARY KEY (asiakas_id)
)Engine="InnoDB";

CREATE TABLE tilaus(
tilaus_id varchar(12) NOT NULL,
asiakas_id varchar(12),
tilauksen_sisalto varchar(50) NOT NULL,
toimitus varchar(10) NOT NULL,
PRIMARY KEY (tilaus_id),
FOREIGN KEY (asiakas_id) REFERENCES asiakas (asiakas_id)
)Engine="InnoDB";

CREATE TABLE yhdenpizzantilaus(
tilaus_id varchar(12) NOT NULL,
pizza_id int NOT NULL,
PRIMARY KEY (tilaus_id, pizza_id),
FOREIGN KEY (tilaus_id) REFERENCES tilaus (tilaus_id),
FOREIGN KEY (pizza_id) REFERENCES pizza (pizza_id)
)Engine="InnoDB";

Login Logout juttuja a la Jamppa

CREATE TABLE kayttaja
(
   id integer primary key,
   username varchar(255) unique,
   password varchar(255)
);

INSERT INTO kayttaja (id, username, password) values (1, 'admin', 'admin');