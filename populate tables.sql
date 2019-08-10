INSERT INTO travel_agency.client VALUES(1, 'Nazar', 'Vladyka', '0975899856');
INSERT INTO travel_agency.client VALUES(2, 'Zakhar', 'Skaletskyy', '0989885631');
INSERT INTO travel_agency.client VALUES(3, 'Alexandr', 'Agarkov', '0962538746');

INSERT INTO travel_agency.visa VALUES(1, 'J Q');
INSERT INTO travel_agency.visa VALUES(2, 'British tourist');

INSERT INTO travel_agency.country VALUES(1, 'USA', 1);
INSERT INTO travel_agency.country VALUES(2, 'England', 2);

INSERT INTO travel_agency.city VALUES(1, 'Tennessee', 1);
INSERT INTO travel_agency.city VALUES(2, 'Las Vegas', 1);
INSERT INTO travel_agency.city VALUES(3, 'London', 2);
INSERT INTO travel_agency.city VALUES(4, 'Cambridge', 2);

INSERT INTO travel_agency.hotel VALUES(1, 'Sheraton Music City', 1);
INSERT INTO travel_agency.hotel VALUES(2, 'Wild Bear Inn', 1);
INSERT INTO travel_agency.hotel VALUES(3, 'Hotel Galaxy', 2);
INSERT INTO travel_agency.hotel VALUES(4, 'The D', 2);
INSERT INTO travel_agency.hotel VALUES(5, 'Restup London', 3);
INSERT INTO travel_agency.hotel VALUES(6, 'Via Lewisham Hostel', 3);
INSERT INTO travel_agency.hotel VALUES(7, 'Hotel Felix', 4);
INSERT INTO travel_agency.hotel VALUES(8, 'Gonville Hotel', 4);

INSERT INTO travel_agency.room VALUES(1, 1, 1);
INSERT INTO travel_agency.room VALUES(2, 2, 1);
INSERT INTO travel_agency.room VALUES(3, 1, 2);
INSERT INTO travel_agency.room VALUES(4, 2, 2);
INSERT INTO travel_agency.room VALUES(5, 1, 3);
INSERT INTO travel_agency.room VALUES(6, 2, 3);
INSERT INTO travel_agency.room VALUES(7, 1, 4);
INSERT INTO travel_agency.room VALUES(8, 2, 4);
INSERT INTO travel_agency.room VALUES(9, 1, 5);
INSERT INTO travel_agency.room VALUES(10, 2, 5);
INSERT INTO travel_agency.room VALUES(11, 1, 6);
INSERT INTO travel_agency.room VALUES(12, 2, 6);
INSERT INTO travel_agency.room VALUES(13, 1, 7);
INSERT INTO travel_agency.room VALUES(14, 2, 7);
INSERT INTO travel_agency.room VALUES(15, 1, 8);
INSERT INTO travel_agency.room VALUES(16, 2, 8);

INSERT INTO travel_agency.room_book VALUES(1, '2019-07-31', '2019-01-06', 1, 2);
INSERT INTO travel_agency.room_book VALUES(2, '2019-08-01', '2019-07-03', 2, 1);
INSERT INTO travel_agency.room_book VALUES(3, '2019-09-15', '2019-06-24', 3, 4);

INSERT INTO travel_agency.room_book_archive VALUES(1, '2019-03-25', '2019-01-23', 2, 1);
INSERT INTO travel_agency.room_book_archive VALUES(2, '2019-02-15', '2019-01-10', 3, 2);

INSERT INTO travel_agency.client_country VALUES(1, 1);
INSERT INTO travel_agency.client_country VALUES(2, 1);
INSERT INTO travel_agency.client_country VALUES(2, 2);
INSERT INTO travel_agency.client_country VALUES(3, 1);
INSERT INTO travel_agency.client_country VALUES(3, 2);

INSERT INTO travel_agency.client_visa VALUES(1, 1);
INSERT INTO travel_agency.client_visa VALUES(2, 1);
INSERT INTO travel_agency.client_visa VALUES(2, 2);
INSERT INTO travel_agency.client_visa VALUES(3, 1);
INSERT INTO travel_agency.client_visa VALUES(3, 2);