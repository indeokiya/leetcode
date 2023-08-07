# Write your MySQL query statement below

WITH UniqueEmail AS (
    SELECT MIN(id) AS min_id
    FROM Person
    GROUP BY email
)
DELETE FROM Person
WHERE id NOT IN (SELECT * FROM UniqueEmail)
