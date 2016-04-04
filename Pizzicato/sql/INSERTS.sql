INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'tomaattikastike');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'juusto');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'herkkusieni');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'sipuli');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'oliivi');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'pinaatti');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'tonnikala');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'katkarapu');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'simpukka');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'kinkku');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'salami');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'pepperoni');
INSERT INTO tayte (tayte_hinta, tayte) values ('2.2', 'jalopeno');

INSERT INTO pizza (nimi, hinta) values ('Margharita', '7.90');
INSERT INTO pizza (nimi, hinta) values ('Vegetara', '8.90');
INSERT INTO pizza (nimi, hinta) values ('Frutti di Mare', '9.90');
INSERT INTO pizza (nimi, hinta) values ('Cappricciosa', '9.90');
INSERT INTO pizza (nimi, hinta) values ('Vesuvio', '9.90');
INSERT INTO pizza (nimi, hinta) values ('Quatro Stagioni', '10.90');
INSERT INTO pizza (nimi, hinta) values ('Della Casa', '10.90');
INSERT INTO pizza (nimi, hinta) values ('Fantasia 2', '8.90');
INSERT INTO pizza (nimi, hinta) values ('Fantasia 3', '9.90');
INSERT INTO pizza (nimi, hinta) values ('Fantasia 4', '10.90');

INSERT INTO pizzantayte (pizza_id, tayte_id) values ('1', '1');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('1', '2');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('2', '1');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('2', '2');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('2', '3');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('2', '4');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('2', '5');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('2', '6');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('3', '1');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('3', '2');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('3', '7');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('3', '8');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('3', '9');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('4', '1');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('4', '2');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('4', '8');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('4', '10');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('4', '3');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('5', '1');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('5', '2');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('5', '11');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('5', '12');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('5', '13');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('6', '1');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('6', '2');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('6', '3');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('6', '7');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('6', '8');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('6', '10');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('7', '1');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('7', '2');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('7', '8');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('7', '4');
INSERT INTO pizzantayte (pizza_id, tayte_id) values ('7', '11');


Login logout juttuja ala jamppa

INSERT INTO kayttaja (id, username, password) values (1, 'admin', 'admin');
