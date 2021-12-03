INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (100, 'peperez@gmail.com', 'asdfTER12', 'peperez.hola');
INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (101, 'carlos@gmail.com', 'aatsattsa2', 'carlo.mag');
INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (102, 'star@gmail.com', 'aststa', 'star.hola');
INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (103, 'rodrigo@gmail.com', 'tartarstarst', 'rodrigo.c');
INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (104, 'luca@gmail.com', 'nioneionio', 'luca.rio');
INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (105, 'no@gmail.com', 'aatsattsa2', 'no.no.no');
INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (106, 'lucy@gmail.com', 'aststa', 'lucy.warrio');
INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (107, 'jose@gmail.com', 'tartarstarst', 'jose.j.j');
INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (108, 'elmaster@gmail.com', 'nioneionio', 'master3000');
INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (109, 'prt@gmail.com', 'ddd', 'prt.777');

INSERT INTO CLIENT_ENTITY (ID) VALUES (100);

INSERT INTO ITINERARY_ENTITY(ID, LODGING, TRANSPORTATION) VALUES (100, 'Equipaje, estadia con desayuno', 'Viaje por autobus');

INSERT INTO OUTING_ENTITY(ID,DATE, NAME,PARTICIPATION_COST,PLACE,ITINERARY_ID) VALUES (100,'2011-09-10', 'Conoce la magia del Parque Tayrona', 500000, 'Parque Natural Tayrona', 100);

INSERT INTO QUOTATION_ENTITY (ID, PARTICIPANTS,STATUS,TOTAL_COST) VALUES (100, 1, 1, 500000);

INSERT INTO INSURANCE_ENTITY (ID,CONDITIONS,FEATURES,NAME,PRICE) VALUES (100, 'Solo para personas naturales', 'Seguro para COVID-19 y viajes mayores a una semana', 'COVID seguro', 40000);

INSERT INTO MULTIMEDIA_ENTITY(ID, FILE_NAME, MEDIA_TYPE, EXTENSION) VALUES (100, 'grabacion_salida', 0, 'mp4');

INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (100, 'Pepe', 'CC', '100212122', 'Calle 13');
INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (101, 'Carlos', 'CC', '10033222', 'Calle 15');
INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (102, 'Felipe', 'CC', '232323', 'Carrera 13');
INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (103, 'Rodrigo', 'TI', '23331', 'Sur 3A');
INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (104, 'Rigoberto', 'CC', '1112212', 'Edificio 1');
INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (105, 'Camilo', 'CC', '10012122', 'Universidad N');
INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (106, 'Ferney', 'TI', '10122022', 'Calle 1');
INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (107, 'Nacho', 'CC', '100343422', 'Circunvalar 5');
INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (108, 'Cesár', 'CC', '100212122', 'Boyaca');

INSERT INTO NATURAL_PERSON_ENTITY (ID, PERSON_ID) VALUES (100, 100);
INSERT INTO NATURAL_PERSON_ENTITY (ID, PERSON_ID) VALUES (101, 101);
INSERT INTO NATURAL_PERSON_ENTITY (ID, PERSON_ID) VALUES (102, 102);
INSERT INTO NATURAL_PERSON_ENTITY (ID, PERSON_ID) VALUES (103, 103);
INSERT INTO NATURAL_PERSON_ENTITY (ID, PERSON_ID) VALUES (104, 104);
INSERT INTO NATURAL_PERSON_ENTITY (ID, PERSON_ID) VALUES (105, 105);
INSERT INTO NATURAL_PERSON_ENTITY (ID, PERSON_ID) VALUES (106, 106);

INSERT INTO ENTERPRISE_ENTITY(ID) VALUES (100);

INSERT INTO TRANSACTION_ENTITY(ID, CREATION_DATE, PAYMENT, VALUE, CLIENT_ID) VALUES (7, '2011-09-10',1, 250, 100);

INSERT INTO BLOG_ENTITY(ID) VALUES (2);

INSERT INTO POST_ENTITY(ID, RATINGS, BLOG_ID) VALUES (5,  9, 2);

INSERT INTO ENTERPRISE_ENTITY(ID, MAIL, USER, BLOG_ID, REPRESENTATIVE_ID) VALUES (10, 'pepe', 'pepe123', 2, 100);

INSERT INTO ADMIN_ENTITY(ID,USER,PASSWORD,MAIL) VALUES (32, 'pepe','33', 'prt@gmail.com');

INSERT INTO COMMENT_ENTITY(ID, TEXT, LIKES, DISLIKES, USERID, USER_TYPE, USERNAME, DATE) VALUES (12, 'melo', 3, 1, 32, 'ADMIN', 'pepe', '2012-04-11');

INSERT INTO COMMENT_ENTITY(ID, TEXT, LIKES, DISLIKES, COMMENT_ID, USERNAME) VALUES (13, 'deacuerdo', 3, 1, 12, 'pedrito');

INSERT INTO REVIEW_ENTITY(ID,SCORE,COMMENT_ID) VALUES (45, 5, 12);

INSERT INTO ROUTE_ENTITY(ID, DIFFICULTY, ESTIMATED_DURATION) VALUES (1,1,100);

INSERT INTO LOCATION_ENTITY(ID,  LATITUDE, LONGITUDE, MAP_ID) VALUES (1, 500, 500.0, 1);

INSERT INTO LOCATION_ENTITY(ID, LATITUDE, LONGITUDE, MAP_ID) VALUES (2, 550.0, 520.0, 1);

INSERT INTO COMPLEMENTARY_INFORMATION_ENTITY(ID,DESCRIPTION,RECOMMENDATION) VALUES (100,'Venezuela','Llevar comida');

INSERT INTO ACTIVITY_ENTITY(ID) VALUES (100);

INSERT INTO GUIDE_ENTITY(ID) VALUES (100);


COMMIT;
