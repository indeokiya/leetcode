# Write your MySQL query statement below

WITH CTE AS (
SELECT
    requester_id,
    accepter_id
FROM
    RequestAccepted
UNION ALL
SELECT
    accepter_id AS requester_id,
    requester_id AS accepter_id
FROM
    RequestAccepted
)

SELECT
    requester_id AS id,
    COUNT(1) AS num
FROM
    CTE
GROUP BY
    requester_id
ORDER BY
    num DESC
LIMIT
    1