# Write your MySQL query statement below

WITH split_call AS (
    SELECT caller_id AS id, duration FROM Calls
    UNION ALL
    SELECT callee_id AS id, duration FROM Calls
), id_country_map AS (
    SELECT id, c.name AS country
    FROM Person p
        LEFT JOIN Country c
        ON left(p.phone_number, 3) = c.country_code
)

SELECT country
FROM split_call s
    LEFT JOIN id_country_map m
    USING (id)
GROUP BY country
HAVING AVG(duration) > (
    SELECT AVG(duration)
    FROM split_call
)