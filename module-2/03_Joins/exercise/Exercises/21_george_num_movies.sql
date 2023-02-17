-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in. Name the count column 'num_of_movies'.
-- Include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. 
-- (59 rows)

SELECT COUNT(*) title AS num_of_movies,
	(SELECT person_name FROM person WHERE person_name LIKE 'George %')
FROM movie
	OUTER JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
	OUTER JOIN person ON person_id = movie_actor.actor_id
ORDER BY person_name;