CREATE TABLE member(
	member_id serial NOT NULL,
	last_name varchar(50) NOT NULL,
	first_name varchar(50) NOT NULL,
	member_email varchar (100) NOT NULL,
	member_phone varchar(20) NULL,
	member_dob date NOT NULL,
	flag_for_emails boolean NOT NULL,
	CONSTRAINT PK_member PRIMARY KEY (member_id)
);

CREATE TABLE interest_group(
	group_id serial NOT NULL,
	group_name varchar (100) UNIQUE NOT NULL,
	CONSTRAINT PK_interest_group PRIMARY KEY (group_id)
);

CREATE TABLE event(
	event_id serial NOT NULL,
	event_name varchar (100) NOT NULL,
	description varchar (2000) NOT NULL,
	start_date_and_time timestamp NOT NULL,
	duration_in_minutes int DEFAULT 30 NOT NULL,
	group_id int NOT NULL,
	CONSTRAINT PK_event PRIMARY KEY (event_id),
	CONSTRAINT FK_event_interest_group FOREIGN KEY (group_id) REFERENCES interest_group(group_id)
);

DROP TABLE member_group;

CREATE TABLE member_group(
	member_id int NOT NULL,
	group_id int NOT NULL,
	CONSTRAINT PK_member_group PRIMARY KEY (member_id, group_id),
	CONSTRAINT FK_member_group_member FOREIGN KEY (member_id) REFERENCES member(member_id),
	CONSTRAINT FK_member_group_interest_group FOREIGN KEY (group_id) REFERENCES interest_group(group_id)
);

CREATE TABLE attendee(
	event_id int NOT NULL,
	member_id int NOT NULL,
	CONSTRAINT PK_attendee PRIMARY KEY (event_id, member_id),
	CONSTRAINT FK_attendee_event FOREIGN KEY (event_id) REFERENCES event(event_id),
	CONSTRAINT FK_attendee_member FOREIGN KEY (member_id) REFERENCES member(member_id)
);

INSERT INTO member (last_name, first_name, member_email, member_dob, flag_for_emails)
VALUES ('LaForge', 'Geordi', 'LavarBurton@gmail.com', '19570216', true);


INSERT INTO member (last_name, first_name, member_email, member_dob, flag_for_emails)
VALUES ('Troi', 'Deanna', 'MarinaSirtis@gmail.com', '19590329', false),
		('Picard', 'Jean-Luc', 'PatrickStewart@gmail.com','19400713', false),
		('Garak', 'Elim', 'AndrewRobinson@gmail.com', '19420214', true),
		('Sisko', 'Benjamin', 'AveryBrooks@gmail.com', '19490418', false),
		('OBrien', 'Miles', 'ColmMeaney@gmail.com', '19530530', true),
		('Janeway', 'Kathryn', 'KateMulgrew@gmail.com','19550429', true),
		('Kim', 'Harry', 'GarrettWang@gmail.com', '19681215', false);
		
INSERT INTO member (last_name, first_name, member_email, member_dob, flag_for_emails)
VALUES ('Chapel', 'Christine', 'MajelBarrett@gmail.com', '19390223', true),
		('Earp', 'Wyatt', 'RonSoble@gmail.com','19320328', true);


INSERT INTO interest_group (group_name)
VALUES ('TNG Club'),
		('DS9 Club'),
		('Voyager Club');
INSERT INTO interest_group (group_name)
VALUES ('TOS Club');
		
INSERT INTO event (event_name, description, start_date_and_time, duration_in_minutes, group_id)
VALUES ('TNG Reunion', 'Reunion for all of those who served on the Enterprise!', '2023-10-05 14:01:10-08', 210, (SELECT group_id FROM interest_group WHERE group_name = 'TNG Club'));

INSERT INTO event (event_name, description, start_date_and_time, duration_in_minutes, group_id)
VALUES ('DS9 Reunion', 'Reunion for all of those who served, worked, or lived on Deep Space Nine before the Dominion war!', '2023-08-05 14:01:10-08', 210, (SELECT group_id FROM interest_group WHERE group_name = 'DS9 Club')),
		 ('Voyager Reunion', 'Reunion for all of those who were on the Voyager as it traversed the delta quadrant!', '2023-06-05 14:01:10-08', 210, (SELECT group_id FROM interest_group WHERE group_name = 'Voyager Club'));
		 

INSERT INTO event (event_name, description, start_date_and_time, duration_in_minutes, group_id)
VALUES ('TOS Reunion', 'Reunion for all the OGs left', '2023-04-05 14:01:10-08', 210, (SELECT group_id FROM interest_group WHERE group_name = 'TOS Club'));
	
		
INSERT INTO attendee (event_id, member_id)
VALUES (
	(SELECT event_id FROM event WHERE event_name = 'TNG Reunion'), (SELECT member_id FROM member WHERE last_name = 'Troi')
);
	
	
INSERT INTO attendee (event_id, member_id)
VALUES (
	(SELECT event_id FROM event WHERE event_name = 'TNG Reunion'), (SELECT member_id FROM member WHERE last_name = 'LaForge')
	);
	
INSERT INTO attendee (event_id, member_id)
VALUES	
	(
	(SELECT event_id FROM event WHERE event_name = 'TNG Reunion'), (SELECT member_id FROM member WHERE last_name = 'Picard')
	);
	
INSERT INTO attendee (event_id, member_id)
VALUES		
	(
	(SELECT event_id FROM event WHERE event_name = 'DS9 Reunion'), (SELECT member_id FROM member WHERE last_name = 'Garak')
	);
INSERT INTO attendee (event_id, member_id)
VALUES	
	(
	(SELECT event_id FROM event WHERE event_name = 'DS9 Reunion'), (SELECT member_id FROM member WHERE last_name = 'Sisko')
	);
INSERT INTO attendee (event_id, member_id)
VALUES	
	(
	(SELECT event_id FROM event WHERE event_name = 'DS9 Reunion'), (SELECT member_id FROM member WHERE member.last_name = 'OBrien')
	),
	
	(
	(SELECT event_id FROM event WHERE event_name = 'Voyager Reunion'), (SELECT member_id FROM member WHERE last_name = 'Janeway')
	),	
	(
	(SELECT event_id FROM event WHERE event_name = 'Voyager Reunion'), (SELECT member_id FROM member WHERE last_name = 'Kim')
	),	
	(
	(SELECT event_id FROM event WHERE event_name = 'TOS Reunion'), (SELECT member_id FROM member WHERE last_name = 'Chapel')
	),	
	(
	(SELECT event_id FROM event WHERE event_name = 'TOS Reunion'), (SELECT member_id FROM member WHERE last_name = 'Earp')
	);
	

INSERT INTO member_group (member_id, group_id)
VALUES (
		(SELECT member_id FROM member WHERE last_name = 'Troi'), (SELECT group_id FROM interest_group WHERE group_name = 'TNG Club')
		),
		(
		(SELECT member_id FROM member WHERE last_name = 'LaForge'), (SELECT group_id FROM interest_group WHERE group_name = 'TNG Club')
		),
		(
		(SELECT member_id FROM member WHERE last_name = 'Picard'), (SELECT group_id FROM interest_group WHERE group_name = 'TNG Club')
		),
		(
		(SELECT member_id FROM member WHERE last_name = 'Garak'), (SELECT group_id FROM interest_group WHERE group_name = 'DS9 Club')
		),
		(
		(SELECT member_id FROM member WHERE last_name = 'Sisko'), (SELECT group_id FROM interest_group WHERE group_name = 'DS9 Club')
		),
		(
		(SELECT member_id FROM member WHERE last_name = 'OBrien'), (SELECT group_id FROM interest_group WHERE group_name = 'DS9 Club')
		),
		(
		(SELECT member_id FROM member WHERE last_name = 'Janeway'), (SELECT group_id FROM interest_group WHERE group_name = 'Voyager Club')
		),
		(
		(SELECT member_id FROM member WHERE last_name = 'Kim'), (SELECT group_id FROM interest_group WHERE group_name = 'Voyager Club')
		),
		(
		(SELECT member_id FROM member WHERE last_name = 'Chapel'), (SELECT group_id FROM interest_group WHERE group_name = 'TOS Club')
		),
		(
		(SELECT member_id FROM member WHERE last_name = 'Earp'), (SELECT group_id FROM interest_group WHERE group_name = 'TOS Club')
		);


SELECT first_name, last_name, group_name
FROM member
	JOIN member_group ON member_group.member_id = member.member_id
	JOIN interest_group ON interest_group.group_id = member_group.group_id
WHERE group_name = 'TNG Club';

SELECT first_name, last_name, description
FROM member
	JOIN attendee ON attendee.member_id = member.member_id
	JOIN event ON event.event_id = attendee.event_id
WHERE event_name = 'DS9 Reunion';

