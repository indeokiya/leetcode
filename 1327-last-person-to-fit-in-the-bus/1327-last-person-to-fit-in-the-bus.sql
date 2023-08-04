# Write your MySQL query statement below

WITH CTE AS (
    SELECT
        turn,
        SUM(weight) OVER (ORDER BY turn) as total
    FROM
        Queue
)
SELECT
    person_name
FROM
    Queue
WHERE turn = (SELECT MAX(turn) FROM CTE WHERE total <= 1000)