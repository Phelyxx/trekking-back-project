INSERT INTO USER_ENTITY(ID, MAIL, PASSWORD, USER) VALUES (100, 'peperez@gmail.com', 'asdfTER12', 'peperez.hola');

INSERT INTO CALENDAR_ENTITY(ID) VALUES (100);

INSERT INTO CLIENT_ENTITY (ID, CALENDAR_ID) VALUES (100,100);

INSERT INTO ITINERARY_ENTITY(ID, LODGING, TRANSPORTATION) VALUES (100, 'Equipaje, estadia con desayuno', 'Viaje por autobus');

INSERT INTO OUTING_ENTITY (ID,DATE, NAME,PARTICIPATION_COST,PLACE,ITINERARY_ID) VALUES (100,'2011-09-10', 'Conoce la magia del Parque Tayrona', 500000, 'Parque Natural Tayrona', 100);

INSERT INTO QUOTATION_ENTITY (ID, PARTICIPANTS,STATUS,TOTAL_COST, OUTING_ID) VALUES (100, 1, 1, 500000, 100);

INSERT INTO INSURANCE_ENTITY (ID,CONDITIONS,FEATURES,NAME,PRICE) VALUES (100, 'Solo para personas naturales', 'Seguro para COVID-19 y viajes mayores a una semana', 'COVID seguro', 40000);

INSERT INTO MULTIMEDIA_ENTITY(ID, FILE_NAME, MEDIA_TYPE, EXTENSION) VALUES (100, 'grabacion_salida', 0, 'mp4');

INSERT INTO PERSON_ENTITY(ID, NAME, ID_TYPE, ID_NUMBER, ADDRESS) VALUES (100, 'pepe', 'CC', '10022', 'Calle 13');

INSERT INTO NATURAL_PERSON_ENTITY (ID, PERSON_ID) VALUES (100, 100);

COMMIT;