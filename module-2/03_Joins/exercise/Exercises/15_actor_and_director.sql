-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)

SELECT title, person_name
FROM movie
	JOIN person ON person.person_id = movie.director_id
	JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
WHERE actor_id = director_id
ORDER BY title;