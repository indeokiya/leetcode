# Write your MySQL query statement below

SELECT
    IFNULL(CASE
        WHEN id%2 = 1 THEN LEAD(id,1) OVER()
        ELSE LAG(id,1) OVER()
    END, id) as id,
    student
FROM
    Seat
ORDER BY
    id
