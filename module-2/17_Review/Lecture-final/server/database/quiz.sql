BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS quizzes;

DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(20),
	CONSTRAINT PK_users PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE TABLE quizzes (
    id      SERIAL         PRIMARY KEY,
    name    VARCHAR(50)    NOT NULL
);

CREATE TABLE questions (
    id      SERIAL          PRIMARY KEY,
    quiz_id INTEGER         NOT NULL,
    text    VARCHAR(255)    NOT NULL,

    CONSTRAINT FK_questions_quizzes FOREIGN KEY (quiz_id) REFERENCES quizzes(id)
);

CREATE TABLE answers (
    id              SERIAL          PRIMARY KEY,
    question_id     INTEGER         NOT NULL,
    text            VARCHAR(100)    NOT NULL,
    isanswer        BOOLEAN         NOT NULL,

    CONSTRAINT FK_answers_questions FOREIGN KEY (question_id) REFERENCES questions(id)
);

INSERT INTO quizzes (name) VALUES ('Dogs');

INSERT INTO questions (quiz_id, text)
VALUES (1, 'The crime solver'), (1, 'Way too many kids');

INSERT INTO answers (question_id, text, isAnswer)
VALUES (1, 'Courage', false), (1, 'The Tramp', false), (1, 'Scooby Doo', true), (1, 'Clifford', false);

INSERT INTO answers (question_id, text, isAnswer)
VALUES (2, 'Pongo', true), (2, 'Odie', false), (2, 'Max', false), (2, 'Droopy', false);

COMMIT;
