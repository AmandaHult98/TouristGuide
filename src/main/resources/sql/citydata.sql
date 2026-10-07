USE touristguide;

CREATE TABLE IF NOT EXISTS city
(
    city_id       INT AUTO_INCREMENT PRIMARY KEY,
    city_name     VARCHAR(50)
);

INSERT INTO city (city_name)
VALUES ('Aalborg'),
       ('Aarhus'),
       ('Billund'),
       ('Esbjerg'),
       ('Helsingør'),
       ('Herning'),
       ('Horsens'),
       ('Jelling'),
       ('Kolding'),
       ('København'),
       ('Marstal'),
       ('Odense'),
       ('Randers'),
       ('Roskilde'),
       ('Rønne'),
       ('Rørvig'),
       ('Silkeborg'),
       ('Skagen'),
       ('Varde'),
       ('Vejle');