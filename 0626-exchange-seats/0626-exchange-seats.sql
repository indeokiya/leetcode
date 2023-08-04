# Write your MySQL query statement below

SELECT
    (CASE
        WHEN id%2 = 1 AND id < (SELECT COUNT(*) FROM Seat)
        THEN id+1
        WHEN id%2 = 0
        THEN id-1
        ELSE id
    END) as id,
    student
FROM
    Seat
ORDER BY
    id