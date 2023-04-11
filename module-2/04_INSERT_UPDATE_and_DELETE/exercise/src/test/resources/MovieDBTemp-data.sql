BEGIN TRANSACTION;

DROP TABLE IF EXISTS movie_genre, movie_actor, movie, collection, person, genre CASCADE;
DROP SEQUENCE IF EXISTS genre_serial, person_serial, collection_serial, movie_serial;


CREATE SEQUENCE genre_serial;
CREATE TABLE genre (
    genre_id int NOT NULL DEFAULT nextval('genre_serial'),
    genre_name varchar(50) NOT NULL,
	CONSTRAINT PK_genre PRIMARY KEY(genre_id)
);


CREATE SEQUENCE movie_serial;
CREATE TABLE movie (
    movie_id int NOT NULL DEFAULT nextval('movie_serial'),
    title varchar(200) NOT NULL,
    overview text NULL,
    tagline varchar(400) NULL,
    poster_path varchar(200) NULL,
    home_page varchar(200) NULL,
    release_date date NULL,
    length_minutes int NOT NULL,
    director_id int NULL,
    collection_id int NULL,
	CONSTRAINT PK_movie PRIMARY KEY(movie_id),
    CONSTRAINT FK_movie_director FOREIGN KEY(director_id) REFERENCES person(person_id),
    CONSTRAINT FK_movie_collection FOREIGN KEY(collection_id) REFERENCES collection(collection_id)
);



CREATE TABLE movie_genre (
    movie_id int NOT NULL,
    genre_id int NOT NULL,
	CONSTRAINT PK_movie_genre PRIMARY KEY(movie_id, genre_id),
    CONSTRAINT FK_movie_genre_movie FOREIGN KEY(movie_id) REFERENCES movie(movie_id),
    CONSTRAINT FK_movie_genre_genre FOREIGN KEY(genre_id) REFERENCES genre(genre_id)
);

INSERT INTO genre (genre_id, genre_name) VALUES (28, 'Action');
INSERT INTO genre (genre_id, genre_name) VALUES (12, 'Adventure');
INSERT INTO genre (genre_id, genre_name) VALUES (16, 'Animation');
INSERT INTO genre (genre_id, genre_name) VALUES (35, 'Comedy');
INSERT INTO genre (genre_id, genre_name) VALUES (80, 'Crime');
INSERT INTO genre (genre_id, genre_name) VALUES (99, 'Documentary');
INSERT INTO genre (genre_id, genre_name) VALUES (18, 'Drama');
INSERT INTO genre (genre_id, genre_name) VALUES (10751, 'Family');
INSERT INTO genre (genre_id, genre_name) VALUES (14, 'Fantasy');
INSERT INTO genre (genre_id, genre_name) VALUES (36, 'History');
INSERT INTO genre (genre_id, genre_name) VALUES (27, 'Horror');
INSERT INTO genre (genre_id, genre_name) VALUES (10402, 'Music');
INSERT INTO genre (genre_id, genre_name) VALUES (9648, 'Mystery');
INSERT INTO genre (genre_id, genre_name) VALUES (10749, 'Romance');
INSERT INTO genre (genre_id, genre_name) VALUES (878, 'Science Fiction');
INSERT INTO genre (genre_id, genre_name) VALUES (10770, 'TV Movie');
INSERT INTO genre (genre_id, genre_name) VALUES (53, 'Thriller');
INSERT INTO genre (genre_id, genre_name) VALUES (10752, 'War');
INSERT INTO genre (genre_id, genre_name) VALUES (37, 'Western');


																			
INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (11, 'Star Wars', 'Princess Leia is captured and held hostage by the evil Imperial forces in their effort to take over the galactic Empire. Venturesome Luke Skywalker and dashing captain Han Solo team together with the loveable robot duo R2-D2 and C-3PO to rescue the beautiful princess and restore peace and justice in the Empire.', 'A long time ago in a galaxy far, far away...', 'https://image.tmdb.org/t/p/w500/6FfCtAuVAW8XJjZ7eWeLibRLWTw.jpg', 'http://www.starwars.com/films/star-wars-episode-iv-a-new-hope', '5/25/1977 12:00:00 AM', 121, '1', '10');
INSERT INTO movie_genre (movie_id, genre_id) VALUES (11, 12);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (11, 28);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (11, 878);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (1891, 'The Empire Strikes Back', 'The epic saga continues as Luke Skywalker, in hopes of defeating the evil Galactic Empire, learns the ways of the Jedi from aging master Yoda. But Darth Vader is more determined than ever to capture Luke. Meanwhile, rebel leader Princess Leia, cocky Han Solo, Chewbacca, and droids C-3PO and R2-D2 are thrown into various stages of capture, betrayal and despair.', 'The Adventure Continues...', 'https://image.tmdb.org/t/p/w500/7BuH8itoSrLExs2YZSsM01Qk2no.jpg', 'http://www.starwars.com/films/star-wars-episode-v-the-empire-strikes-back', '5/20/1980 12:00:00 AM', 124, '10930', '10');
INSERT INTO movie_genre (movie_id, genre_id) VALUES (1891, 12);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (1891, 28);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (1891, 878);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (1892, 'Return of the Jedi', 'Luke Skywalker leads a mission to rescue his friend Han Solo from the clutches of Jabba the Hutt, while the Emperor seeks to destroy the Rebellion once and for all with a second dreaded Death Star.', 'The Empire Falls...', 'https://image.tmdb.org/t/p/w500/mDCBQNhR6R0PVFucJl0O4Hp5klZ.jpg', 'http://www.starwars.com/films/star-wars-episode-vi-return-of-the-jedi', '5/25/1983 12:00:00 AM', 135, '19800', '10');
INSERT INTO movie_genre (movie_id, genre_id) VALUES (1892, 12);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (1892, 28);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (1892, 878);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (299536, 'Avengers: Infinity War', 'As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.', 'An entire universe. Once and for all.', 'https://image.tmdb.org/t/p/w500/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg', 'https://www.marvel.com/movies/avengers-infinity-war', '4/25/2018 12:00:00 AM', 149, '19271', '86311');
INSERT INTO movie_genre (movie_id, genre_id) VALUES (299536, 12);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (299536, 28);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (299536, 878);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (105, 'Back to the Future', 'Eighties teenager Marty McFly is accidentally sent back in time to 1955, inadvertently disrupting his parents'' first meeting and attracting his mother''s romantic interest. Marty must repair the damage to history by rekindling his parents'' romance and - with the help of his eccentric inventor friend Doc Brown - return to 1985.', 'He''s the only kid ever to get into trouble before he was born.', 'https://image.tmdb.org/t/p/w500/xlBivetfrtF84Yx0zISShnNtHYe.jpg', 'http://www.backtothefuture.com/movies/backtothefuture1', '7/3/1985 12:00:00 AM', 116, '24', '264');
INSERT INTO movie_genre (movie_id, genre_id) VALUES (105, 12);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (105, 35);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (105, 878);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (105, 10751);


INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (7214, 'Coach Carter', 'Based on a true story, in which Richmond High School head basketball coach Ken Carter made headlines in 1999 for benching his undefeated team due to poor academic results.', 'It begins on the street. It ends here.', 'https://image.tmdb.org/t/p/w500/eYfA48NXSMzt8W5Iqj6GvKKNb8L.jpg', 'http://www.ibuyanessay.com/', '1/14/2005 12:00:00 AM', 136, '52038', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (7214, 18);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (7214, 36);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (77, 'Memento', 'Leonard Shelby is tracking down the man who raped and murdered his wife. The difficulty of locating his wife''s killer, however, is compounded by the fact that he suffers from a rare, untreatable form of short-term memory loss. Although he can recall details of life before his accident, Leonard cannot remember what happened fifteen minutes ago, where he''s going, or why.', 'Some memories are best forgotten.', 'https://image.tmdb.org/t/p/w500/yuNs09hvpHVU1cBTCAk9zxsL2oW.jpg', 'http://www.otnemem.com/', '10/11/2000 12:00:00 AM', 113, '525', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (77, 9648);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (77, 53);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (367220, 'The Blob', 'Coal miners accidentally unleash an alien lifeform that consumes everything in its path.', '', 'https://image.tmdb.org/t/p/w500/5xOqbSEswdHLAuXDzpahTMnTHA2.jpg', NULL, '1/1/0001 12:00:00 AM', 0, NULL, NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (367220, 878);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (367220, 27);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (367220, 9648);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (367220, 12);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (311, 'Once Upon a Time in America', 'A former Prohibition-era Jewish gangster returns to the Lower East Side of Manhattan over thirty years later, where he once again must confront the ghosts and regrets of his old life.', 'Crime, passion and lust for power.', 'https://image.tmdb.org/t/p/w500/i0enkzsL5dPeneWnjl1fCWm6L7k.jpg', NULL, '5/23/1984 12:00:00 AM', 229, '4385', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (311, 18);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (311, 80);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (947, 'Lawrence of Arabia', 'The story of British officer T.E. Lawrence''s mission to aid the Arab tribes in their revolt against the Ottoman Empire during the First World War. Lawrence becomes a flamboyant, messianic figure in the cause of Arab unity but his psychological instability threatens to undermine his achievements.', 'A mighty motion picture of action and adventure!', 'https://image.tmdb.org/t/p/w500/yBc8a5wQL7FmSra4TgcdNrBcoP9.jpg', NULL, '12/11/1962 12:00:00 AM', 227, '12238', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (947, 12);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (947, 18);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (947, 36);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (947, 10752);


INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (3870, '1900', 'Set in Bertolucci''s ancestral region of Emilia, the film chronicles the lives of two men during the political turmoils that took place in Italy in the first half of the 20th century.', 'From the cradle to the grave - victims of history and change!', 'https://image.tmdb.org/t/p/w500/87ELdlKW5h5qpJfVRXITvsDqYJ.jpg', NULL, '5/21/1976 12:00:00 AM', 317, '4956', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3870, 18);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3870, 36);


INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (507, 'Killing Zoe', 'Zed is an American vault-cracker who travels to Paris to meet up with his old friend Eric. Eric and his gang have planned to raid the only bank in the city which is open on Bastille day. After offering his services, Zed soon finds himself trapped in a situation beyond his control when heroin abuse, poor planning and a call-girl named Zoe all conspire to turn the robbery into a very bloody siege.', '', 'https://image.tmdb.org/t/p/w500/k3UEKMVnkljOlsO5sLmz87YGlaG.jpg', NULL, '10/1/1993 12:00:00 AM', 96, '8297', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (507, 28);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (507, 80);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (507, 18);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (507, 53);


INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (10344, 'The Fly II', 'Martin Brundle, born of the human/fly, is adopted by his father''s place of employment (Bartok Inc.) while the employees simply wait for his mutant chromosomes to come out of their dormant state.', 'Like Father Like Son', 'https://image.tmdb.org/t/p/w500/gORksEPahEgO409HYJOZlNVyEpe.jpg', NULL, '2/10/1989 12:00:00 AM', 105, '64875', '109609');
INSERT INTO movie_genre (movie_id, genre_id) VALUES (10344, 27);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (10344, 878);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (10344, 53);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (11800, 'Naked in New York', 'Naked in New York begins in the car of grown up Jake, he is talking to us about his girlfriend, Joanne,  and to whom you can turn to for help while facing life. From there it flashes back to his memories of his parents, college, house across from a squirrel infested peanut factory, best friend, writing career and Joanne.', 'Love. Work. Life. Even when you have all the pieces… some assembly is required', 'https://image.tmdb.org/t/p/w500/gAufFGm2Qly8TYrhy4me9X35B7m.jpg', NULL, '11/10/1993 12:00:00 AM', 95, '69696', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (11800, 35);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (11800, 10749);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (15143, 'Some Kind of Wonderful', 'A young tomboy, Watts, finds her feelings for her best friend, Keith, run deeper than just friendship when he gets a date with the most popular girl in school.', 'Before they could stand together, they had to stand alone.', 'https://image.tmdb.org/t/p/w500/lc6KUGAetADDQNxbz3u5dJ27OSb.jpg', NULL, '2/27/1987 12:00:00 AM', 95, '26502', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (15143, 18);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (15143, 10749);


INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (61418, 'The Waterdance', 'Author Joel Garcia breaks his neck while hiking, and finds himself in a rehab center with Raymond, an exaggerating ladies man, and Bloss, a racist biker. Considerable tension builds as each character tries to deal with his new found handicap and the problems that go with it, especially Joel, whose lover Anna is having as difficult a time as he is.', 'Sometimes, life happens by accident.', 'https://image.tmdb.org/t/p/w500/Et6tFS1Ch3zOQPZQ3upVNWDg1G.jpg', NULL, '5/13/1992 12:00:00 AM', 106, '7406', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (61418, 18);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (37146, 'Penn & Teller Get Killed', 'Penn &amp; Teller enjoy playing jokes on each other. When Penn says on an interview show that he wishes he has someone threatening his life so that he "wouldn''t sweat the small stuff," each of them begins a series of pranks on the other to suggest a real threat. Then they find that a real psychopath is interested in them.', 'What more do you want?', 'https://image.tmdb.org/t/p/w500/ja27nQA4Wofys5hAB6f3aDX801q.jpg', NULL, '9/22/1989 12:00:00 AM', 89, '6448', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (37146, 35);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (37146, 12);


INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (43589, 'Penn & Teller: Off the Deep End', 'Penn & Teller: Off the Deep End is a two-hour special that premiered on NBC on November 13, 2005. It featured magicians Penn & Teller performing a variety of illusions in various locations around the Caribbean, most of which were done underwater or involved marine animals. It also featured a performance by musician Aaron Carter.', '', 'https://image.tmdb.org/t/p/w500/q0rJR1fzbZCHgpkrSD25inRJYP2.jpg', NULL, '11/13/2005 12:00:00 AM', 88, '504377', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (43589, 35);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (48425, 'Penn & Teller Go Public', 'Penn reads "Casey at the Bat" while Teller escapes from a straight jacket; Penn does a not-wimpy card trick; Teller gives the illusion of reality with a cigarette; Penn eats fire; and the guys show you a trick you can do at home, if you don''t mind taping over Masterpiece Theatre.', '', 'https://image.tmdb.org/t/p/w500/fZ1r7tHAYp2SQErUd0Xw2ahVWZ3.jpg', NULL, '1/28/1985 12:00:00 AM', 37, NULL, NULL);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (67520, 'Grand Illusions - The Story Of Magic', 'Explore the rich, fascinating culture and history of magic through this six-part series, which takes you inside an alluring and enchanting world. It''s all here, from the mechanical automata of Robert-Houdin to the elaborate illusions of Penn and Teller, from the death-defying escapes of Houdini to the bizarre and tragic feats of the sideshow performers. Come backstage and see what''s behind the curtain.', '', 'https://image.tmdb.org/t/p/w500/mhWwUqZV3OgbmZCmQjby2DmRjtq.jpg', NULL, '3/25/2003 12:00:00 AM', 160, NULL, NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (67520, 99);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (79207, 'Phobophilia: The Love of Fear', 'More terror/magic hijinks from Penn &amp; Teller, with support from some other players. Paul Provenza spends the whole show trapped in a system of giant tubes. Skits include a new director and an auditioning starlet who can and will do anything, and the Three Stooges on a construction project. Other notable tricks include earthworms finding a photo from a stack, a borrowed ring apparently cut from a volunteer''s stomach, and a bullet swap.', '', 'https://image.tmdb.org/t/p/w500', NULL, '1/1/1995 12:00:00 AM', 60, '81809', NULL);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (137, 'Groundhog Day', 'A narcissistic TV weatherman, along with his attractive-but-distant producer, and his mawkish cameraman, is sent to report on Groundhog Day in the small town of Punxsutawney, where he finds himself repeating the same day over and over.', 'He’s having the worst day of his life … over, and over …', 'https://image.tmdb.org/t/p/w500/gCgt1WARPZaXnq523ySQEUKinCs.jpg', NULL, '2/11/1993 12:00:00 AM', 101, '1524', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (137, 10749);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (137, 14);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (137, 18);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (137, 35);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (153, 'Lost in Translation', 'Two lost souls visiting Tokyo -- the young, neglected wife of a photographer and a washed-up movie star shooting a TV commercial -- find an odd solace and pensive freedom to be real in each other''s company, away from their lives in America.', 'Everyone wants to be found.', 'https://image.tmdb.org/t/p/w500/wkSzJs7oMf8MIr9CQVICsvRfwA7.jpg', NULL, '9/18/2003 12:00:00 AM', 102, '1769', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (153, 18);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (153, 10749);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (153, 35);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (308, 'Broken Flowers', 'As the devoutly single Don Johnston is dumped by his latest girlfriend, he receives an anonymous pink letter informing him that he has a son who may be looking for him.', 'Sometimes life brings some strange surprises', 'https://image.tmdb.org/t/p/w500/xDjCNGmDOesm8UenVrCBkUv38VT.jpg', NULL, '8/5/2005 12:00:00 AM', 106, '4429', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (308, 35);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (308, 18);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (308, 9648);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (308, 10749);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (421, 'The Life Aquatic with Steve Zissou', 'Renowned oceanographer Steve Zissou has sworn vengeance upon the rare shark that devoured a member of his crew. In addition to his regular team, he is joined on his boat by Ned, a man who believes Zissou to be his father, and Jane, a journalist pregnant by a married man. They travel the sea, all too often running into pirates and, perhaps more traumatically, various figures from Zissou''s past, including his estranged wife, Eleanor.', 'The deeper you go, the weirder life gets.', 'https://image.tmdb.org/t/p/w500/qZoFLNBC78jzboWeDH6Ha0qavF2.jpg', NULL, '12/10/2004 12:00:00 AM', 119, '5655', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (421, 12);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (421, 35);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (421, 18);


INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (620, 'Ghostbusters', 'After losing their academic posts at a prestigious university, a team of parapsychologists goes into business as proton-pack-toting "ghostbusters" who exterminate ghouls, hobgoblins and supernatural pests of all stripes. An ad campaign pays off when a knockout cellist hires the squad to purge her swanky digs of demons that appear to be living in her refrigerator.', 'They ain''t afraid of no ghost.', 'https://image.tmdb.org/t/p/w500/h5Qz8J4T8YQnbZzHXM73WVYYVPK.jpg', 'http://www.ghostbusters.com/', '6/8/1984 12:00:00 AM', 107, '8858', '2980');
INSERT INTO movie_genre (movie_id, genre_id) VALUES (620, 35);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (620, 14);


INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (250658, 'The Internet''s Own Boy: The Story of Aaron Swartz', 'Programming prodigy and information activist Aaron Swartz achieved groundbreaking work in social justice and political organizing. His passion for open access ensnared him in a legal nightmare that ended with the taking of his own life at the age of 26.', 'Information is power.', 'https://image.tmdb.org/t/p/w500/s8qznCAjPRcRwQkvGU6rRdF7mxb.jpg', NULL, '6/27/2014 12:00:00 AM', 105, '1102384', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (250658, 80);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (250658, 99);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (379447, 'Foreveryone.net', 'Foreveryone.net connects the future of the web with the little-known story of its birth. In 1989, 33-year-old computer programmer Tim Berners-Lee invented the world wide web and his visionary decision to make it a free and accessible resource sparked a global revolution in communication. Tim has declared internet access a human right and has called for an “online Magna Carta” to protect privacy and free speech, extend connectivity to populations without access and maintain “One Web” for all. Tim’s dramatic story poses the question: will we fight for the web we want or let it be taken away?', 'The web, past and future.', 'https://image.tmdb.org/t/p/w500/uJEive0zmo4J42IgAAIkFkfbinC.jpg', 'http://www.foreveryone.net/', '1/1/2016 12:00:00 AM', 35, '19509', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (379447, 99);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (347495, 'Inside the Dark Web', 'Twenty-five years after the world wide web was created, it is now caught in the greatest controversy of its existence - surveillance. With many concerned that governments and corporations can monitor our every move, Horizon meets the hackers and scientists whose technology is fighting back. It is a controversial technology, and some law enforcement officers believe it is leading to risk-free crime on the dark web - a place where almost anything can be bought, from guns and drugs to credit card details.', '', 'https://image.tmdb.org/t/p/w500/ILguuyDqXnV3uuAhDk0KDSteAZ.jpg', NULL, '9/3/2014 12:00:00 AM', 50, '1520071', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (347495, 99);

INSERT INTO movie (movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) VALUES (481573, 'The Gutenberg Enigma', 'A portrait of the inventor of the letterpress, who was a key figure in the history of mankind, but also an enthusiastic inventor, a daring businessman, a tenacious troublemaker: the life of Johannes Gutenberg (circa 1400-68).', 'The man who succeeds against all odds', 'https://image.tmdb.org/t/p/w500/cQYMWnUJ3gV7KXSruWjR1DyfuVA.jpg', NULL, '9/25/2017 12:00:00 AM', 86, '1132115', NULL);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (481573, 99);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (481573, 36);



SELECT setval('genre_serial', (SELECT MAX(genre_id) + 1000 FROM genre));



SELECT setval('movie_serial', (SELECT MAX(movie_id) + 1000 FROM movie));



COMMIT;