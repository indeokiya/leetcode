# Write your MySQL query statement below

WITH
    UserRatingCnt AS (
    SELECT
        COUNT(*) AS cnt,
        name
    FROM
        MovieRating
            INNER JOIN
        Users
            USING(user_id)
    GROUP BY
        user_id
    ORDER BY
        cnt DESC, name ASC
    LIMIT
        1
    ),
    FebRatingAvg AS (
    SELECT
        movie_id,
        AVG(rating) AS rating,
        title
    FROM
        MovieRating
            INNER JOIN
        Movies
            USING(movie_id)
    WHERE
        DATEDIFF(created_at, '2020-02-01') >= 0 AND
        DATEDIFF('2020-03-01', created_at) > 0
    GROUP BY
        movie_id
    ORDER BY
        rating DESC, title ASC
    LIMIT
        1
    )

SELECT
    name AS results
FROM
    UserRatingCnt
UNION ALL
SELECT
    title AS results
FROM
    FebRatingAvg