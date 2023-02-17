-- 2. The names and birthdays of actors in "The Fifth Element"
-- Order the results alphabetically (A-Z) by name.
-- (15 rows)

SELECT person_name, birthday
FROM person
	INNER JOIN movie_actor ON movie_actor.actor_id = person.person_id
	INNER JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE movie.title = 'The Fifth Element'
ORDER BY person_name;