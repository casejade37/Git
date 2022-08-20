DROP TABLE TEAM CASCADE; 
DROP TABLE PLAYER CASCADE;
DROP TABLE GAME CASCADE;
DROP TABLE SEASON_TYPE CASCADE;
DROP TABLE SEASON CASCADE;
DROP TABLE PLAYER_GAME_SEASON_LINK CASCADE;
DROP TABLE TEAM_GAME_SEASON_LINK CASCADE;
DROP TABLE INJURY CASCADE;
DROP TABLE PLAYER_INJURY_LINK CASCADE;
DROP TABLE TRADE CASCADE;
DROP TABLE PLAYER_TRADE_LINK CASCADE;
DROP TABLE TEAM_TRADE_LINK CASCADE;
DROP TABLE GUARD CASCADE;
DROP TABLE FORWARD CASCADE;
DROP TABLE CENTER CASCADE;
DROP SEQUENCE player_seq;
DROP SEQUENCE team_seq;
DROP SEQUENCE game_seq;
DROP SEQUENCE player_game_link_seq;
DROP SEQUENCE team_game_link_seq;
DROP SEQUENCE season_seq;
DROP SEQUENCE season_type_seq;
DROP SEQUENCE injury_seq;
DROP SEQUENCE player_injury_link_seq;
DROP SEQUENCE trade_seq;
DROP SEQUENCE player_trade_link_seq; 
DROP SEQUENCE team_trade_link_seq;

--TABLES
CREATE TABLE TEAM(
TEAM_ID DECIMAL(12) NOT NULL,
TEAM_NAME VARCHAR(32) NOT NULL,
TEAM_HISTORY DECIMAL(4) NOT NULL,
TEAM_LOCATION VARCHAR(64) NOT NULL,
TEAM_TOTAL_SALARY DECIMAL(12) NOT NULL,
PRIMARY KEY (TEAM_ID));

CREATE TABLE PLAYER(
PLAYER_ID DECIMAL(12) NOT NULL,
TEAM_ID DECIMAL(12) NOT NULL,
PLAYER_FIRST_NAME VARCHAR(32) NOT NULL,
PLAYER_LAST_NAME VARCHAR(32) NOT NULL,
HEIGHT DECIMAL(3) NOT NULL,
WEIGHT DECIMAL(3) NOT NULL,
COUNTRY VARCHAR(64) NOT NULL,
BIRTH_DATE DATE NOT NULL,
PLAYER_POSITION CHAR(1) NOT NULL,
PRIMARY KEY (PLAYER_ID),
FOREIGN KEY (TEAM_ID) REFERENCES TEAM);

CREATE TABLE GAME(
GAME_ID DECIMAL(12) NOT NULL,
GAME_LOCATION VARCHAR(64) NOT NULL,
GAME_DATE DATE NOT NULL,
PRIMARY KEY (GAME_ID));

CREATE TABLE SEASON_TYPE(
SEASON_TYPE_ID DECIMAL(12) NOT NULL,
SEASON_TYPE VARCHAR(32) NOT NULL,
NUMBER_GAME DECIMAL(3) NOT NULL,
PRIMARY KEY (SEASON_TYPE_ID));

CREATE TABLE SEASON(
SEASON_ID DECIMAL(12) NOT NULL,
SEASON_TYPE_ID DECIMAL(12) NOT NULL,
SEASON_YEAR VARCHAR(32) NOT NULL,
PRIMARY KEY (SEASON_ID),
FOREIGN KEY (SEASON_TYPE_ID) REFERENCES SEASON_TYPE);

CREATE TABLE PLAYER_GAME_SEASON_LINK(
PLAYER_GAME_LINK_ID DECIMAL(12) NOT NULL,
PLAYER_ID DECIMAL(12) NOT NULL,
GAME_ID DECIMAL(12) NOT NULL,
SEASON_ID DECIMAL(12) NOT NULL,
MIN_PLAYED DECIMAL(3, 1),
PTS DECIMAL(3),
REB DECIMAL(3),
AST DECIMAL(3),
STL DECIMAL(3),
BLK DECIMAL(3),
TOV DECIMAL(3),
PRIMARY KEY (PLAYER_GAME_LINK_ID),
FOREIGN KEY (PLAYER_ID) REFERENCES PLAYER,
FOREIGN KEY (GAME_ID) REFERENCES GAME,
FOREIGN KEY (SEASON_ID) REFERENCES SEASON);

CREATE TABLE TEAM_GAME_SEASON_LINK(
TEAM_GAME_LINK_ID DECIMAL(12) NOT NULL,
TEAM_ID DECIMAL(12) NOT NULL,
GAME_ID DECIMAL(12) NOT NULL,
SEASON_ID DECIMAL(12) NOT NULL,
TEAM_PTS DECIMAL(3),
TEAM_REB DECIMAL(3),
TEAM_AST DECIMAL(3),
TEAM_STL DECIMAL(3),
TEAM_BLK DECIMAL(3),
TEAM_TOV DECIMAL(3),
PRIMARY KEY (TEAM_GAME_LINK_ID),
FOREIGN KEY (TEAM_ID) REFERENCES TEAM,
FOREIGN KEY (GAME_ID) REFERENCES GAME,
FOREIGN KEY (SEASON_ID) REFERENCES SEASON);

CREATE TABLE INJURY(
INJURY_ID DECIMAL(12) NOT NULL,
INJURY_TYPE VARCHAR(32) NOT NULL,
PRIMARY KEY (INJURY_ID));

CREATE TABLE PLAYER_INJURY_LINK(
PLAYER_INJURY_LINK_ID DECIMAL(12) NOT NULL,
PLAYER_ID DECIMAL(12) NOT NULL,
INJURY_ID DECIMAL(12) NOT NULL,
INJURY_DATE DATE NOT NULL,
RECOVER_TIME DECIMAL(4),
PRIMARY KEY (PLAYER_INJURY_LINK_ID),
FOREIGN KEY (PLAYER_ID) REFERENCES PLAYER,
FOREIGN KEY (INJURY_ID) REFERENCES INJURY);

CREATE TABLE TRADE(
TRADE_ID DECIMAL(12) NOT NULL,
TRADE_TYPE VARCHAR(32) NOT NULL,
TRADE_DATE DATE NOT NULL,
PRIMARY KEY (TRADE_ID));

CREATE TABLE PLAYER_TRADE_LINK(
PLAYER_TRADE_LINK_ID DECIMAL(12) NOT NULL,
PLAYER_ID DECIMAL(12) NOT NULL,
TRADE_ID DECIMAL(12) NOT NULL,
PLAYER_SALARY DECIMAL(12) NOT NULL,
PRIMARY KEY (PLAYER_TRADE_LINK_ID),
FOREIGN KEY (PLAYER_ID) REFERENCES PLAYER,
FOREIGN KEY (TRADE_ID) REFERENCES TRADE);

CREATE TABLE TEAM_TRADE_LINK(
TEAM_TRADE_LINK_ID DECIMAL(12) NOT NULL,
TEAM_ID DECIMAL(12) NOT NULL,
TRADE_ID DECIMAL(12) NOT NULL,
PRIMARY KEY (TEAM_TRADE_LINK_ID),
FOREIGN KEY (TEAM_ID) REFERENCES TEAM,
FOREIGN KEY (TRADE_ID) REFERENCES TRADE);

CREATE TABLE GUARD(
PLAYER_ID DECIMAL(12) NOT NULL,
PASSING_SKILL DECIMAL(3) NOT NULL,
PRIMARY KEY (PLAYER_ID),
FOREIGN KEY (PLAYER_ID) REFERENCES PLAYER(PLAYER_ID));

CREATE TABLE FORWARD(
PLAYER_ID DECIMAL(12) NOT NULL,
SCORING_ABILITY DECIMAL(3) NOT NULL,
PRIMARY KEY (PLAYER_ID),
FOREIGN KEY (PLAYER_ID) REFERENCES PLAYER(PLAYER_ID));

CREATE TABLE CENTER(
PLAYER_ID DECIMAL(12) NOT NULL,
DEFENSIVE_IMPACT DECIMAL(3) NOT NULL,
PRIMARY KEY (PLAYER_ID),
FOREIGN KEY (PLAYER_ID) REFERENCES PLAYER(PLAYER_ID));

--SEQUENCES
CREATE SEQUENCE player_seq START WITH 1;
CREATE SEQUENCE team_seq START WITH 1;
CREATE SEQUENCE game_seq START WITH 1;
CREATE SEQUENCE player_game_link_seq START WITH 1;
CREATE SEQUENCE team_game_link_seq START WITH 1;
CREATE SEQUENCE season_seq START WITH 1;
CREATE SEQUENCE season_type_seq START WITH 1;
CREATE SEQUENCE injury_seq START WITH 1;
CREATE SEQUENCE player_injury_link_seq START WITH 1;
CREATE SEQUENCE trade_seq START WITH 1;
CREATE SEQUENCE player_trade_link_seq START WITH 1;
CREATE SEQUENCE team_trade_link_seq START WITH 1;

--INDEXES
--create indexes for foreign keys.
CREATE INDEX TEAM_IDX
ON PLAYER(TEAM_ID);
CREATE INDEX PLAYER_LINK_PLAYER_IDX
ON PLAYER_GAME_SEASON_LINK(PLAYER_ID);
CREATE INDEX PLAYER_LINK_GAME_IDX
ON PLAYER_GAME_SEASON_LINK(GAME_ID);
CREATE INDEX PLAYER_LINK_SEASON_IDX
ON PLAYER_GAME_SEASON_LINK(SEASON_ID);
CREATE INDEX TEAM_LINK_TEAM_IDX
ON TEAM_GAME_SEASON_LINK(TEAM_ID);
CREATE INDEX TEAM_LINK_GAME_IDX
ON TEAM_GAME_SEASON_LINK(GAME_ID);
CREATE INDEX TEAM_LINK_SEASON_IDX
ON TEAM_GAME_SEASON_LINK(SEASON_ID);
CREATE INDEX SEASON_TYPE_IDX
ON SEASON(SEASON_TYPE_ID);
CREATE INDEX PLAYER_INJURY_PLAYER_IDX
ON PLAYER_INJURY_LINK(PLAYER_ID);
CREATE INDEX PLAYER_INJURY_TYPE_IDX
ON PLAYER_INJURY_LINK(INJURY_ID);
CREATE INDEX PLAYER_TRADE_PLAYER_IDX
ON PLAYER_TRADE_LINK(PLAYER_ID);
CREATE INDEX PLAYER_TRADE_IDX
ON PLAYER_TRADE_LINK(TRADE_ID);
CREATE INDEX TEAM_TRADE_TEAM_IDX
ON TEAM_TRADE_LINK(TEAM_ID);
CREATE INDEX TEAM_TRADE_IDX
ON TEAM_TRADE_LINK(TRADE_ID);

--create query driven indexes.
CREATE INDEX BIRTH_DATE_IDX
ON PLAYER(BIRTH_DATE);
CREATE INDEX WEIGHT_IDX
ON PLAYER(WEIGHT);
CREATE INDEX SCORING_IDX
ON FORWARD(SCORING_ABILITY);

--STORED PROCEDURES
--1. Adding Teams
CREATE OR REPLACE PROCEDURE ADD_TEAM(TEAM_ID IN DECIMAL, TEAM_NAME IN VARCHAR, TEAM_HISTORY IN DECIMAL, TEAM_LOCATION IN VARCHAR, TEAM_TOTAL_SALARY IN DECIMAL)
AS
$proc$
BEGIN
  INSERT INTO TEAM(TEAM_ID, TEAM_NAME, TEAM_HISTORY, TEAM_LOCATION, TEAM_TOTAL_SALARY)
  VALUES(TEAM_ID, TEAM_NAME, TEAM_HISTORY, TEAM_LOCATION, TEAM_TOTAL_SALARY);
END;
$proc$ LANGUAGE plpgsql;
--Execution example
START TRANSACTION;
DO
 $$BEGIN
   CALL ADD_TEAM(nextval('team_seq'), 'Golden State Warriors', 1946, 'San Francisco', 176302940);
 END$$;
COMMIT TRANSACTION;

--2. Adding Players
CREATE OR REPLACE PROCEDURE ADD_PLAYER(PLAYER_ID IN DECIMAL, TEAM_ID IN DECIMAL, PLAYER_FIRST_NAME IN VARCHAR, PLAYER_LAST_NAME IN VARCHAR, 
                                       HEIGHT IN DECIMAL, WEIGHT IN DECIMAL, COUNTRY IN VARCHAR, BIRTH_DATE IN DATE, PLAYER_POSITION IN CHAR)
AS
$proc$
BEGIN
  INSERT INTO PLAYER(PLAYER_ID, TEAM_ID, PLAYER_FIRST_NAME, PLAYER_LAST_NAME, HEIGHT, WEIGHT, COUNTRY, BIRTH_DATE, PLAYER_POSITION)
  VALUES(PLAYER_ID, TEAM_ID, PLAYER_FIRST_NAME, PLAYER_LAST_NAME, HEIGHT, WEIGHT, COUNTRY, BIRTH_DATE, PLAYER_POSITION);
END;
$proc$ LANGUAGE plpgsql;
--Execution example
START TRANSACTION;
DO
 $$BEGIN
   CALL ADD_PLAYER(nextval('player_seq'), currval('team_seq'), 'Steph', 'Curry', 74, 185, 'United States', 'MAR-14-1988', 'G');
 END$$;
COMMIT TRANSACTION;

--3. Adding Injuries
CREATE OR REPLACE PROCEDURE ADD_INJURY(INJURY_ID IN DECIMAL, INJURY_TYPE IN VARCHAR, PLAYER_INJURY_LINK_ID IN DECIMAL, PLAYER_ID IN DECIMAL, 
                                       INJURY_DATE IN DATE, RECOVER_TIME IN DECIMAL)
AS
$proc$
BEGIN
  INSERT INTO INJURY(INJURY_ID, INJURY_TYPE)
  VALUES(INJURY_ID, INJURY_TYPE);
  INSERT INTO PLAYER_INJURY_LINK(PLAYER_INJURY_LINK_ID, PLAYER_ID, INJURY_ID, INJURY_DATE, RECOVER_TIME)
  VALUES(PLAYER_INJURY_LINK_ID, PLAYER_ID, INJURY_ID, INJURY_DATE, RECOVER_TIME);
END;
$proc$ LANGUAGE plpgsql;
--Execution example
START TRANSACTION;
DO
 $$BEGIN
   CALL ADD_INJURY(nextval('injury_seq'), 'Ankle Sprain', nextval('player_injury_link_seq'), currval('player_seq'), 'MAR-14-2015', 30);
 END$$;
COMMIT TRANSACTION;


--INSERTS
--Populate tables that will be accessed by queries later.

--table SEASON_TYPE: only 3 records because this is a domain/lookup table. 
--table SEASON: 6 records in total
--table GAME: 10 records in total
--table TEAM: 7 records in total
--table PLAYER: 5 records in total
--table PLAYER_GAME_SEASON_LINK: 10 records in total
--table TEAM_GAME_SEASON_LINK: 20 records in total
START TRANSACTION;
DO
 $$BEGIN
--player 1
INSERT INTO GUARD(PLAYER_ID, PASSING_SKILL)
VALUES(currval('player_seq'), 85);
--season 1
INSERT INTO SEASON_TYPE(SEASON_TYPE_ID, SEASON_TYPE, NUMBER_GAME)
VALUES(nextval('season_type_seq'), 'Preseason', 6);
INSERT INTO SEASON(SEASON_ID, SEASON_TYPE_ID, SEASON_YEAR)
VALUES(nextval('season_seq'), currval('season_type_seq'), '2020-2021');
--game 1
INSERT INTO GAME(GAME_ID, GAME_LOCATION, GAME_DATE)
VALUES(nextval('game_seq'), 'San Francisco', 'OCT-05-2020');
INSERT INTO PLAYER_GAME_SEASON_LINK(PLAYER_GAME_LINK_ID, PLAYER_ID, GAME_ID, SEASON_ID, MIN_PLAYED, PTS, REB, AST, STL, BLK, TOV)
VALUES(nextval('player_game_link_seq'), currval('player_seq'), currval('game_seq'), currval('season_seq'), 32.8, 35, 5, 10, 2, 3, 5);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), currval('team_seq'), currval('game_seq'), currval('season_seq'), 135, 45, 50, 22, 18, 25);

   CALL ADD_TEAM(nextval('team_seq'), 'Atlanta Hawks', 1946, 'Atlanta', 150000000);
   
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), currval('team_seq'), currval('game_seq'), currval('season_seq'), 100, 45, 50, 22, 18, 25);
--game 2
INSERT INTO GAME(GAME_ID, GAME_LOCATION, GAME_DATE)
VALUES(nextval('game_seq'), 'Boston', 'OCT-12-2020');
INSERT INTO PLAYER_GAME_SEASON_LINK(PLAYER_GAME_LINK_ID, PLAYER_ID, GAME_ID, SEASON_ID, MIN_PLAYED, PTS, REB, AST, STL, BLK, TOV)
VALUES(nextval('player_game_link_seq'), currval('player_seq'), currval('game_seq'), currval('season_seq'), 35.2, 45, 5, 12, 1, 2, 6);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), (SELECT TEAM_ID FROM TEAM WHERE TEAM_NAME = 'Golden State Warriors'), currval('game_seq'), currval('season_seq'), 100, 45, 50, 22, 18, 25);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), (SELECT TEAM_ID FROM TEAM WHERE TEAM_NAME = 'Atlanta Hawks'), currval('game_seq'), currval('season_seq'), 91, 45, 50, 20, 15, 25);

   CALL ADD_TEAM(nextval('team_seq'), 'Boston Celtics', 1946, 'Boston', 170026077);
   CALL ADD_PLAYER(nextval('player_seq'), currval('team_seq'), 'Jayson', 'Tatum', 80, 210, 'United States', 'MAR-3-1998', 'F');
--player 2
INSERT INTO FORWARD(PLAYER_ID, SCORING_ABILITY)
VALUES(currval('player_seq'), 90);
--game 3
INSERT INTO GAME(GAME_ID, GAME_LOCATION, GAME_DATE)
VALUES(nextval('game_seq'), 'Boston', 'NOV-3-2020');
INSERT INTO PLAYER_GAME_SEASON_LINK(PLAYER_GAME_LINK_ID, PLAYER_ID, GAME_ID, SEASON_ID, MIN_PLAYED, PTS, REB, AST, STL, BLK, TOV)
VALUES(nextval('player_game_link_seq'), currval('player_seq'), currval('game_seq'), currval('season_seq'), 32.2, 14, 2, 3, 3, 2, 6);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), currval('team_seq'), currval('game_seq'), currval('season_seq'), 112, 45, 50, 22, 18, 25);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), (SELECT TEAM_ID FROM TEAM WHERE TEAM_NAME = 'Atlanta Hawks'), currval('game_seq'), currval('season_seq'), 89, 35, 45, 20, 11, 22);
--season 2
INSERT INTO SEASON(SEASON_ID, SEASON_TYPE_ID, SEASON_YEAR)
VALUES(nextval('season_seq'), currval('season_type_seq'), '2021-2022');
--game 4
INSERT INTO GAME(GAME_ID, GAME_LOCATION, GAME_DATE)
VALUES(nextval('game_seq'), 'Brooklyn', 'SEP-2-2021');
INSERT INTO PLAYER_GAME_SEASON_LINK(PLAYER_GAME_LINK_ID, PLAYER_ID, GAME_ID, SEASON_ID, MIN_PLAYED, PTS, REB, AST, STL, BLK, TOV)
VALUES(nextval('player_game_link_seq'), currval('player_seq'), currval('game_seq'), currval('season_seq'), 39.0, 41, 2, 3, 3, 2, 6);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), currval('team_seq'), currval('game_seq'), currval('season_seq'), 101, 45, 50, 22, 18, 25);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), (SELECT TEAM_ID FROM TEAM WHERE TEAM_NAME = 'Golden State Warriors'), currval('game_seq'), currval('season_seq'), 88, 44, 51, 23, 17, 25);

   CALL ADD_TEAM(nextval('team_seq'), 'Brooklyn Nets', 1967, 'Brooklyn', 182228955);
   CALL ADD_PLAYER(nextval('player_seq'), currval('team_seq'), 'Kevin', 'Durant', 82, 240, 'United States', 'SEP-29-1988', 'F');
--player 3
INSERT INTO FORWARD(PLAYER_ID, SCORING_ABILITY)
VALUES(currval('player_seq'), 99);
--season 3
INSERT INTO SEASON_TYPE(SEASON_TYPE_ID, SEASON_TYPE, NUMBER_GAME)
VALUES(nextval('season_type_seq'), 'Regular Season', 82);
INSERT INTO SEASON(SEASON_ID, SEASON_TYPE_ID, SEASON_YEAR)
VALUES(nextval('season_seq'), currval('season_type_seq'), '2020-2021');
--game 5
INSERT INTO GAME(GAME_ID, GAME_LOCATION, GAME_DATE)
VALUES(nextval('game_seq'), 'Brooklyn', 'MAR-5-2021');
INSERT INTO PLAYER_GAME_SEASON_LINK(PLAYER_GAME_LINK_ID, PLAYER_ID, GAME_ID, SEASON_ID, MIN_PLAYED, PTS, REB, AST, STL, BLK, TOV)
VALUES(nextval('player_game_link_seq'), currval('player_seq'), currval('game_seq'), currval('season_seq'), 39.0, 60, 1, 2, 3, 2, 6);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), currval('team_seq'), currval('game_seq'), currval('season_seq'), 100, 45, 50, 22, 18, 25);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), (SELECT TEAM_ID FROM TEAM WHERE TEAM_NAME = 'Golden State Warriors'), currval('game_seq'), currval('season_seq'), 99, 46, 50, 22, 18, 25);
--game 6
INSERT INTO GAME(GAME_ID, GAME_LOCATION, GAME_DATE)
VALUES(nextval('game_seq'), 'Boston', 'MAR-6-2021');
INSERT INTO PLAYER_GAME_SEASON_LINK(PLAYER_GAME_LINK_ID, PLAYER_ID, GAME_ID, SEASON_ID, MIN_PLAYED, PTS, REB, AST, STL, BLK, TOV)
VALUES(nextval('player_game_link_seq'), currval('player_seq'), currval('game_seq'), currval('season_seq'), 41.0, 32, 1, 2, 3, 2, 6);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), currval('team_seq'), currval('game_seq'), currval('season_seq'), 100, 55, 65, 32, 25, 10);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), (SELECT TEAM_ID FROM TEAM WHERE TEAM_NAME = 'Boston Celtics'), currval('game_seq'), currval('season_seq'), 92, 45, 50, 26, 18, 25);

   CALL ADD_TEAM(nextval('team_seq'), 'Los Angeles Lakers', 1947, 'Los Angeles', 147504083);
   CALL ADD_PLAYER(nextval('player_seq'), currval('team_seq'), 'LeBron', 'James', 81, 250, 'United States', 'DEC-30-1984', 'F');
--player 4
INSERT INTO FORWARD(PLAYER_ID, SCORING_ABILITY)
VALUES(currval('player_seq'), 95);
--season 4
INSERT INTO SEASON(SEASON_ID, SEASON_TYPE_ID, SEASON_YEAR)
VALUES(nextval('season_seq'), currval('season_type_seq'), '2021-2022');
--game 7
INSERT INTO GAME(GAME_ID, GAME_LOCATION, GAME_DATE)
VALUES(nextval('game_seq'), 'Los Angeles', 'MAR-7-2022');
INSERT INTO PLAYER_GAME_SEASON_LINK(PLAYER_GAME_LINK_ID, PLAYER_ID, GAME_ID, SEASON_ID, MIN_PLAYED, PTS, REB, AST, STL, BLK, TOV)
VALUES(nextval('player_game_link_seq'), currval('player_seq'), currval('game_seq'), currval('season_seq'), 42.0, 31, 10, 12, 3, 5, 2);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), currval('team_seq'), currval('game_seq'), currval('season_seq'), 100, 45, 50, 22, 18, 25);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), (SELECT TEAM_ID FROM TEAM WHERE TEAM_NAME = 'Boston Celtics'), currval('game_seq'), currval('season_seq'), 135, 45, 60, 22, 18, 25);
--game 8
INSERT INTO GAME(GAME_ID, GAME_LOCATION, GAME_DATE)
VALUES(nextval('game_seq'), 'Milwaukee', 'MAR-8-2022');
INSERT INTO PLAYER_GAME_SEASON_LINK(PLAYER_GAME_LINK_ID, PLAYER_ID, GAME_ID, SEASON_ID, MIN_PLAYED, PTS, REB, AST, STL, BLK, TOV)
VALUES(nextval('player_game_link_seq'), currval('player_seq'), currval('game_seq'), currval('season_seq'), 42.0, 35, 20, 22, 3, 5, 2);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), currval('team_seq'), currval('game_seq'), currval('season_seq'), 100, 45, 50, 22, 18, 25);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), (SELECT TEAM_ID FROM TEAM WHERE TEAM_NAME = 'Golden State Warriors'), currval('game_seq'), currval('season_seq'), 155, 25, 50, 22, 18, 25);

   CALL ADD_TEAM(nextval('team_seq'), 'Milwaukee Bucks', 1968, 'Milwaukee', 173699627);
   CALL ADD_PLAYER(nextval('player_seq'), currval('team_seq'), 'Giannis', 'Antetokounmpo', 83, 243, 'Greece', 'DEC-6-1994', 'F');
--player 5
INSERT INTO FORWARD(PLAYER_ID, SCORING_ABILITY)
VALUES(currval('player_seq'), 85);
--season 5
INSERT INTO SEASON_TYPE(SEASON_TYPE_ID, SEASON_TYPE, NUMBER_GAME)
VALUES(nextval('season_type_seq'), 'Playoffs', 4);
INSERT INTO SEASON(SEASON_ID, SEASON_TYPE_ID, SEASON_YEAR)
VALUES(nextval('season_seq'), currval('season_type_seq'), '2020-2021');
--game 9
INSERT INTO GAME(GAME_ID, GAME_LOCATION, GAME_DATE)
VALUES(nextval('game_seq'), 'Milwaukee', 'APR-8-2021');
INSERT INTO PLAYER_GAME_SEASON_LINK(PLAYER_GAME_LINK_ID, PLAYER_ID, GAME_ID, SEASON_ID, MIN_PLAYED, PTS, REB, AST, STL, BLK, TOV)
VALUES(nextval('player_game_link_seq'), currval('player_seq'), currval('game_seq'), currval('season_seq'), 42.0, 35, 25, 15, 3, 5, 2);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), currval('team_seq'), currval('game_seq'), currval('season_seq'), 100, 45, 50, 22, 18, 25);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), (SELECT TEAM_ID FROM TEAM WHERE TEAM_NAME = 'Boston Celtics'), currval('game_seq'), currval('season_seq'), 170, 60, 70, 22, 18, 25);
--season 6
INSERT INTO SEASON(SEASON_ID, SEASON_TYPE_ID, SEASON_YEAR)
VALUES(nextval('season_seq'), currval('season_type_seq'), '2021-2022');
--game 10
INSERT INTO GAME(GAME_ID, GAME_LOCATION, GAME_DATE)
VALUES(nextval('game_seq'), 'Milwaukee', 'APR-8-2022');
INSERT INTO PLAYER_GAME_SEASON_LINK(PLAYER_GAME_LINK_ID, PLAYER_ID, GAME_ID, SEASON_ID, MIN_PLAYED, PTS, REB, AST, STL, BLK, TOV)
VALUES(nextval('player_game_link_seq'), currval('player_seq'), currval('game_seq'), currval('season_seq'), 42.0, 45, 12, 18, 3, 5, 2);
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), currval('team_seq'), currval('game_seq'), currval('season_seq'), 100, 45, 50, 22, 18, 25);

   CALL ADD_TEAM(nextval('team_seq'), 'Miami Heats', 1950, 'Miami', 165000000);
   
INSERT INTO TEAM_GAME_SEASON_LINK(TEAM_GAME_LINK_ID, TEAM_ID, GAME_ID, SEASON_ID, TEAM_PTS, TEAM_REB, TEAM_AST, TEAM_STL, TEAM_BLK, TEAM_TOV)
VALUES(nextval('team_game_link_seq'), currval('team_seq'), currval('game_seq'), currval('season_seq'), 120, 65, 55, 22, 18, 25);

 END$$;
COMMIT TRANSACTION;

--QUERIES
--First Query
SELECT (PLAYER.PLAYER_FIRST_NAME || ' ' || PLAYER.PLAYER_LAST_NAME) AS PLAYER_NAME, to_char(AVG(PLAYER_GAME_SEASON_LINK.PTS), '99.9') AS AVG_PTS, 
        to_char(AVG(TEAM_GAME_SEASON_LINK.TEAM_PTS), '999.9') AS AVG_TEAM_PTS
FROM PLAYER
JOIN PLAYER_GAME_SEASON_LINK ON PLAYER.PLAYER_ID = PLAYER_GAME_SEASON_LINK.PLAYER_ID
JOIN GAME ON GAME.GAME_ID = PLAYER_GAME_SEASON_LINK.GAME_ID
JOIN TEAM_GAME_SEASON_LINK ON PLAYER_GAME_SEASON_LINK.GAME_ID = TEAM_GAME_SEASON_LINK.GAME_ID
WHERE DATE_PART('YEAR', NOW()) - DATE_PART('YEAR', PLAYER.BIRTH_DATE) >= 30
GROUP BY PLAYER_NAME
HAVING AVG(PLAYER_GAME_SEASON_LINK.PTS) >= 30 AND AVG(TEAM_GAME_SEASON_LINK.TEAM_PTS) <= 100;

--Second Query
SELECT (PLAYER.PLAYER_FIRST_NAME || ' ' || PLAYER.PLAYER_LAST_NAME) AS PLAYER_NAME, PLAYER.WEIGHT, FORWARD.SCORING_ABILITY
FROM PLAYER
JOIN FORWARD ON FORWARD.PLAYER_ID = PLAYER.PLAYER_ID
WHERE PLAYER.WEIGHT >= 240
AND FORWARD.SCORING_ABILITY >= 90;

--Third Query
CREATE OR REPLACE VIEW Game_view AS 
SELECT GAME.GAME_LOCATION, GAME.GAME_DATE, SEASON_TYPE.SEASON_TYPE
     FROM GAME
     JOIN PLAYER_GAME_SEASON_LINK ON PLAYER_GAME_SEASON_LINK.GAME_ID = GAME.GAME_ID
     JOIN SEASON ON SEASON.SEASON_ID = PLAYER_GAME_SEASON_LINK.SEASON_ID
     JOIN SEASON_TYPE ON SEASON.SEASON_TYPE_ID = SEASON_TYPE.SEASON_TYPE_ID;

SELECT Game_view.GAME_LOCATION, Game_view.GAME_DATE, Game_view.SEASON_TYPE
FROM Game_view
WHERE Game_view.SEASON_TYPE NOT IN (SELECT SEASON_TYPE FROM SEASON_TYPE WHERE SEASON_TYPE = 'Preseason')
ORDER BY Game_view.GAME_DATE DESC;
