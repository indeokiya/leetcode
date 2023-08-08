# Write your MySQL query statement below

SELECT c.from_id AS person1, c.to_id AS person2, COUNT(1) AS call_count, SUM(duration) AS total_duration
FROM (
    SELECT *
    FROM Calls
    WHERE from_id < to_id
    UNION ALL
    SELECT to_id AS from_id, from_id AS to_id, duration
    FROM Calls
    WHERE from_id > to_id
) c
GROUP BY from_id, to_id