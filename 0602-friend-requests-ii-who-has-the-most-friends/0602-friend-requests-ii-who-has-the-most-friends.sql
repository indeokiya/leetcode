# Write your MySQL query statement below

WITH CTE AS (
    SELECT requester_id AS id
    FROM RequestAccepted
    UNION ALL
    SELECT accepter_id AS id
    FROM RequestAccepted
), CTE2 AS (
    SELECT id, COUNT(id) AS cnt, DENSE_RANK() OVER(ORDER BY COUNT(id) DESC) AS rn
    FROM CTE
    GROUP BY 1
)

SELECT id, cnt AS num
FROM CTE2
WHERE rn = 1

