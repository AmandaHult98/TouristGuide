create database if not exists touristguide
    character set utf8mb4;
USE touristguide;

DROP TABLE IF EXISTS tag;

CREATE TABLE IF NOT EXISTS tag
(
    tag_id   int PRIMARY KEY,
    tag_name VARCHAR(100)
);

DROP TABLE IF EXISTS tourist_attraction;

CREATE TABLE IF NOT EXISTS tourist_attraction
(
    attraction_id int PRIMARY KEY,
    name          VARCHAR(50),
    description   VARCHAR(300)
);

DROP TABLE IF EXISTS attraction_tags;

CREATE TABLE IF NOT EXISTS attraction_tags
(
    attraction_id INT NOT NULL,
    tag_id        INT NOT NULL,
    PRIMARY KEY (attraction_id, tag_id),
    FOREIGN KEY (tag_id)
        REFERENCES tag (tag_id),
    FOREIGN KEY (attraction_id)
        REFERENCES tourist_attraction (attraction_id)
);

DROP TABLE IF EXISTS city;

CREATE TABLE IF NOT EXISTS city
(
    postcode      INT PRIMARY KEY,
    attraction_id INT,
    city_name     VARCHAR(50),
    FOREIGN KEY (attraction_id)
        REFERENCES tourist_attraction (attraction_id)
);