DELETE FROM number;
DELETE FROM entry;


INSERT INTO entry VALUES (NEXTVAL('entry_id_seq'), 'Hollande', 'François');
INSERT INTO entry VALUES (NEXTVAL('entry_id_seq'), 'Presley', 'Elvis');
INSERT INTO entry VALUES (NEXTVAL('entry_id_seq'), 'Leponge', 'Bob');
INSERT INTO entry VALUES (NEXTVAL('entry_id_seq'), 'Vador', 'Dark');
INSERT INTO entry VALUES (NEXTVAL('entry_id_seq'), 'Obama', 'Barack');
INSERT INTO entry VALUES (NEXTVAL('entry_id_seq'), 'Ibrahimovic', 'Zlatan');
INSERT INTO entry VALUES (NEXTVAL('entry_id_seq'), 'Gates', 'Bill');
INSERT INTO entry VALUES (NEXTVAL('entry_id_seq'), 'Depardieu', 'Gérard');
INSERT INTO entry VALUES (NEXTVAL('entry_id_seq'), 'Wolfgang Amadeus', 'Mozart');
INSERT INTO entry VALUES (NEXTVAL('entry_id_seq'), 'Laboeuf', 'Shia');


INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Elysée', '03 20 00 00 00', 1);
INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Parlement', '03 20 11 11 11', 1);
INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Portable', '03 20 22 22 22', 1);

INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Graceland', '01 00 00 00 00', 2);
INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Backstage', '01 01 01 01 01', 2);

INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Ananas', '02 00 00 00 00', 3);

INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Etoile noire, bureau 15', '04 00 00 00 00', 4);
INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Portable', '04 11 11 11 11', 4);

INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Maison Blanche', '05 00 00 00 00', 5);
INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Home sweet home', '05 11 11 11 11', 5);
INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Portable', '05 22 22 22 22', 5);

INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'France residence', '06 00 00 00 00', 6);

INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Portable', '07 00 00 00 00', 7);

INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Maison Russie', '08 00 00 00 00', 8);
INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Maison France', '08 11 11 11 11', 8);

INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Portable', '09 00 00 00 00', 9);

INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Maison', '01 23 45 67 89', 10);
INSERT INTO number VALUES (NEXTVAL('number_id_seq'), 'Portable', '09 87 65 43 21', 10);
