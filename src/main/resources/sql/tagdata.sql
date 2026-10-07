USE touristguide;

CREATE TABLE IF NOT EXISTS tag
(
    tag_id   INT AUTO_INCREMENT PRIMARY KEY,
    tag_name VARCHAR(50)
);

INSERT INTO tag (tag_name)
VALUES ('ARCHITECTURE'),
       ('ART'),
       ('AMUSEMENT_PARK'),
       ('CASTLE'),
       ('HISTORY'),
       ('KID_FRIENDLY'),
       ('MUSEUM'),
       ('NATURE'),
       ('ZOO');