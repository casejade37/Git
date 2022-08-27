CREATE TABLE Player(
player_name VARCHAR(64), 
mvp_ranking DECIMAL NOT NULL,
shooting_percentage DECIMAL(4, 2) NOT NULL
);

INSERT INTO Player (player_name, mvp_ranking, shooting_percentage)
VALUES ('Steph Curry', 10, 55.20);

INSERT INTO Player (player_name, mvp_ranking, shooting_percentage)
VALUES ('Steph Curry', 1, 40.50);

INSERT INTO Player (player_name, mvp_ranking, shooting_percentage)
VALUES ('Steph Curry', 5, 80.35);

SELECT *
FROM Player

DELETE FROM Player
WHERE player_name = 'Steph Curry';

SELECT *
FROM Player