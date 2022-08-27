DROP TABLE Person CASCADE;
DROP TABLE Post CASCADE;
DROP TABLE Likes CASCADE;
DROP SEQUENCE person_seq, post_seq, likes_seq;

CREATE TABLE Person(
person_id DECIMAL(12) NOT NULL,
first_name VARCHAR(32) NOT NULL,
last_name  VARCHAR(32) NOT NULL,
username VARCHAR(20) NOT NULL,
PRIMARY KEY (person_id));

CREATE TABLE Post (
post_id   DECIMAL(12) NOT NULL,
person_id DECIMAL(12) NOT NULL,
content   VARCHAR(255) NOT NULL,
created_on DATE NOT NULL,
summary VARCHAR(13) NOT NULL,
PRIMARY KEY (post_id),
FOREIGN KEY (person_id) REFERENCES Person);

CREATE TABLE Likes(
likes_id      DECIMAL(12) NOT NULL,
person_id     DECIMAL(12) NOT NULL,
post_id       DECIMAL(12) NOT NULL,
liked_on      DATE,
PRIMARY KEY (likes_id),
FOREIGN KEY (person_id) REFERENCES Person,
FOREIGN KEY (post_id) REFERENCES Post);

CREATE SEQUENCE person_seq START WITH 1;
CREATE SEQUENCE post_seq START WITH 1;
CREATE SEQUENCE likes_seq START WITH 1;

--Steph's posts.
INSERT INTO Person VALUES(nextval('person_seq'),'Steph','Curry','stephcurry');
INSERT INTO Post
VALUES(nextval('post_seq'),currval('person_seq'),'Three point shooting drill',
       CAST('1-DEC-2020' AS DATE), 'Three poin...');
INSERT INTO Post
VALUES(nextval('post_seq'),currval('person_seq'),'Just arrived at China',
       CAST('21-AUG-2015' AS DATE), 'Just arriv...');

--Kobe's posts.
INSERT INTO Person VALUES(nextval('person_seq'),'Kobe','Bryant','mamba');
INSERT INTO Post
VALUES(nextval('post_seq'),currval('person_seq'),'Mamba Mentality',
       CAST('1-JAN-2020' AS DATE), 'Mamba Ment...');

--Lebron's posts.
INSERT INTO Person VALUES(nextval('person_seq'),'Lebron','James','kingjames');
INSERT INTO Post
VALUES(nextval('post_seq'),currval('person_seq'),'Always improving',
       CAST('1-JUL-2022' AS DATE), 'Always imp...');
INSERT INTO Post
VALUES(nextval('post_seq'),currval('person_seq'),'Taco Tuesday!',
       CAST('26-JUL-2022' AS DATE), 'Taco Tuesd...');

--Kevin's posts.
INSERT INTO Person VALUES(nextval('person_seq'),'Kevin','Durant','easychampionship');
INSERT INTO Post
VALUES(nextval('post_seq'),currval('person_seq'),'Which team is interested in me',
       CAST('15-June-2022' AS DATE), 'Which team...');
INSERT INTO Post
VALUES(nextval('post_seq'),currval('person_seq'),'That fan is annoying',
       CAST('25-June-2017' AS DATE), 'That fan i...');

--Jason's posts.
INSERT INTO Person VALUES(nextval('person_seq'),'Jason','Tatum','mambajr');
INSERT INTO Post
VALUES(nextval('post_seq'),currval('person_seq'),'Killer instinct',
       CAST('1-OCT-2018' AS DATE), 'Killer ins...');

--Likes
INSERT INTO Likes
VALUES(nextval('likes_seq'), (SELECT person_id FROM Person WHERE person_id = 5), (SELECT post_id FROM Post WHERE post_id = 1), CAST('2-DEC-2020' AS DATE));
INSERT INTO Likes
VALUES(nextval('likes_seq'), (SELECT person_id FROM Person WHERE person_id = 4), (SELECT post_id FROM Post WHERE post_id = 3), CAST('15-AUG-2022' AS DATE));
INSERT INTO Likes
VALUES(nextval('likes_seq'),(SELECT person_id FROM Person WHERE person_id = 3), (SELECT post_id FROM Post WHERE post_id = 4), CAST('1-AUG-2022' AS DATE));
INSERT INTO Likes
VALUES(nextval('likes_seq'), (SELECT person_id FROM Person WHERE person_id = 4), (SELECT post_id FROM Post WHERE post_id = 2), CAST('20-JULY-2022' AS DATE));
INSERT INTO Likes
VALUES(nextval('likes_seq'), (SELECT person_id FROM Person WHERE person_id = 1), (SELECT post_id FROM Post WHERE post_id = 5), CAST('27-JULY-2022' AS DATE));
INSERT INTO Likes
VALUES(nextval('likes_seq'), (SELECT person_id FROM Person WHERE person_id = 2), (SELECT post_id FROM Post WHERE post_id = 8), CAST('1-OCT-2020' AS DATE));

--Get all details
SELECT first_name, last_name, username, content, created_on, summary, liked_on
FROM   Person
JOIN   Post ON Person.person_id = Post.person_id
JOIN   Likes ON Post.post_id = Likes.post_id
ORDER BY first_name, last_name, created_on, content;


CREATE OR REPLACE PROCEDURE ADD_MICHELLE_STELLA()
AS
$proc$
      BEGIN
        INSERT INTO Person (person_id, first_name, last_name, username)
        VALUES (nextval('person_seq'), 'Michelle', 'Stella', 'michellestella');
      END;
$proc$ LANGUAGE plpgsql;

CALL ADD_MICHELLE_STELLA();

SELECT *
FROM Person;

CREATE OR REPLACE PROCEDURE ADD_PERSON( 
   first_name_arg IN VARCHAR, 
   last_name_arg IN VARCHAR,
   username_arg IN VARCHAR) 
   LANGUAGE plpgsql
AS 
$resuableproc$ 
BEGIN
   INSERT INTO Person (person_id, first_name, last_name, username)
   VALUES(nextval('person_seq'),first_name_arg,last_name_arg,username_arg);
END;
$resuableproc$; 

CALL ADD_PERSON('Ming', 'Yao', 'presidentyao');

SELECT *
FROM Person;

CREATE OR REPLACE PROCEDURE ADD_POST(
    p_person_id IN DECIMAL,
    p_content IN VARCHAR,
    p_created_on IN DATE)
  LANGUAGE plpgsql
AS
$$ 
DECLARE
  v_summary VARCHAR(13);
BEGIN
   v_summary := SUBSTRING(p_content FROM 1 FOR 10) || '...';
   INSERT INTO Post (post_id, person_id, content, created_on, summary)
   VALUES(nextval('post_seq'), p_person_id, p_content, p_created_on, v_summary);
END;
$$; 

CALL ADD_POST(1, 'Intensive Playoff Games. Need to relax for months.', CAST('15-JUN-2022' AS DATE));

SELECT *
FROM Post;

CREATE OR REPLACE PROCEDURE ADD_LIKE(
 p_username IN VARCHAR,
 p_post_id IN DECIMAL,
 l_liked_on IN DATE)
  LANGUAGE plpgsql
AS 
$$
DECLARE
v_person_id DECIMAL(12);
BEGIN
SELECT person_id
INTO   v_person_id
FROM   Person
WHERE  username = p_username;

INSERT INTO Likes(likes_id, person_id, post_id, liked_on)
VALUES(nextval('likes_seq'), v_person_id, p_post_id, l_liked_on);
END; 
$$;

CALL ADD_LIKE('stephcurry', 2, CAST('21-AUG-2015' AS DATE));

SELECT *
FROM Likes;

CREATE OR REPLACE FUNCTION sum_limit_func()
 RETURNS TRIGGER LANGUAGE plpgsql
 AS $trigfunc$
 BEGIN
   RAISE EXCEPTION USING MESSAGE = 'Summary must be the first 10 characters followed by ...',
   ERRCODE = 22000;
 END;
$trigfunc$;
CREATE TRIGGER sum_limit_trg
BEFORE UPDATE OR INSERT ON Post
FOR EACH ROW WHEN(NEW.summary != SUBSTRING(NEW.content FROM 1 FOR 10) || '...')
EXECUTE PROCEDURE sum_limit_func();

-- valid insert
INSERT INTO Post
VALUES(nextval('post_seq'),currval('person_seq'),'Build a better league',
       CAST('1-May-2020' AS DATE), 'Build a be...');
-- invalid insert
INSERT INTO Post
VALUES(nextval('post_seq'),currval('person_seq'),'Hope to play in NBA again',
       CAST('30-June-2022' AS DATE), 'play in ...');
       
SELECT *
FROM Post;

CREATE OR REPLACE FUNCTION liked_limit_func()
RETURNS TRIGGER LANGUAGE plpgsql
AS $$
DECLARE
  v_created_on DATE;
BEGIN
   SELECT created_on
   INTO   v_created_on
   FROM   Post
   WHERE  Post.post_id = NEW.post_id;
   
   IF NEW.liked_on < v_created_on THEN
     RAISE EXCEPTION USING MESSAGE = 'The liked date must be after the created date.',
     ERRCODE = 22000;
END IF;
   RETURN NEW;
END;
$$;

CREATE OR REPLACE TRIGGER liked_limit_trg
BEFORE UPDATE OR INSERT ON Likes
FOR EACH ROW
EXECUTE PROCEDURE liked_limit_func();

-- valid insert
INSERT INTO Likes
VALUES(nextval('likes_seq'), 1, 1, CAST('2-Dec-2020' AS DATE));
-- invalid insert
INSERT INTO Likes
VALUES(nextval('likes_seq'), 1, 1, CAST('30-Nov-2020' AS DATE));

SELECT *
FROM Likes;

CREATE TABLE Post_content_history (
post_id DECIMAL(12) NOT NULL,
old_content VARCHAR(255) NOT NULL,
new_content VARCHAR(255) NOT NULL,
change_date DATE NOT NULL,
FOREIGN KEY (post_id) REFERENCES Post(post_id));

CREATE OR REPLACE FUNCTION post_content_history_func()
RETURNS TRIGGER LANGUAGE plpgsql
AS $$
BEGIN
    IF OLD.content <> NEW.content THEN
        INSERT INTO Post_content_history(post_id, old_content, new_content, change_date)
        VALUES(NEW.post_id, OLD.content, NEW.content, CURRENT_DATE);
END IF;
    RETURN NEW;
END;
$$;

CREATE TRIGGER post_content_history_trg
BEFORE UPDATE ON Post
FOR EACH ROW
EXECUTE PROCEDURE post_content_history_func();

UPDATE Post
SET content = 'Done with shooting', summary = 'Done with ...'
WHERE post_id = 1;

SELECT *
FROM Post_content_history;