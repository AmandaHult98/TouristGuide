DROP TABLE IF EXISTS tag;

CREATE TABLE tag
(
    tag_id   INT /*AUTO_INCREMENT*/ PRIMARY KEY,
    tag_name VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS city;

CREATE TABLE city
(
    city_id      INT /*AUTO_INCREMENT*/ PRIMARY KEY,
    city_name     VARCHAR(50)
);

DROP TABLE IF EXISTS tourist_attraction;

CREATE TABLE tourist_attraction
(
    attraction_id INT /*AUTO_INCREMENT*/ PRIMARY KEY,
    name          VARCHAR(50),
    description   VARCHAR(300),
    city_id       INT/*,
    FOREIGN KEY (city_id)
        REFERENCES city (city_id)*/
);

DROP TABLE IF EXISTS attraction_tags;

CREATE TABLE attraction_tags
(
    attraction_id INT NOT NULL,
    tag_id        INT NOT NULL/*,
    PRIMARY KEY (attraction_id, tag_id),
    FOREIGN KEY (tag_id)
        REFERENCES tag (tag_id),
    FOREIGN KEY (attraction_id)
        REFERENCES tourist_attraction (attraction_id)*/
);



-- init-data
INSERT INTO city (city_id, city_name) VALUES (1, 'København');
INSERT INTO city (city_id, city_name) VALUES (8, 'Helsingør');

INSERT INTO tag (tag_id, tag_name) VALUES (1, 'ARCHITECTURE');
INSERT INTO tag (tag_id, tag_name) VALUES (2, 'ART');

INSERT INTO tourist_attraction (attraction_id, name, description, city_id) VALUES (1, 'Tivoli', 'Forlystelsespark i indre København', 1);
INSERT INTO tourist_attraction (attraction_id, name, description, city_id) VALUES (2, 'Kronborg', 'Slot i Helsingør, hvor Hamlet foregår.', 8);

INSERT INTO attraction_tags (attraction_id, tag_id) VALUES (1, 3); /* tivoli, amusement park */
INSERT INTO attraction_tags (attraction_id, tag_id) VALUES(1, 6); /* tivoli, kid */
INSERT INTO attraction_tags (attraction_id, tag_id) VALUES(2,4); /* kronborg, slot */
INSERT INTO attraction_tags (attraction_id, tag_id) VALUES(2, 5); /* kronborg, historie */
INSERT INTO attraction_tags (attraction_id, tag_id) VALUES(2, 1); /* kronborg, arkitekt */
INSERT INTO attraction_tags (attraction_id, tag_id) VALUES(2,7); /* kronborg, museum */