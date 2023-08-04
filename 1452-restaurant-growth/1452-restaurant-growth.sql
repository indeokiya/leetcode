# Write your MySQL query statement below

WITH DaySum AS (
    SELECT
        visited_on,
        SUM(amount) AS amount
    FROM
        Customer
    GROUP BY
        visited_on
    ORDER BY
        visited_on
)

SELECT
    d1.visited_on,
    SUM(d2.amount) AS amount,
    ROUND(SUM(d2.amount)/7, 2) AS average_amount
FROM
    DaySum d1
        INNER JOIN
    DaySum d2
WHERE
    DATEDIFF(d1.visited_on, d2.visited_on) BETWEEN 0 AND 6
GROUP BY
    d1.visited_on
HAVING
    DATEDIFF(d1.visited_on, (SELECT MIN(visited_on) FROM Customer)) >= 6
ORDER BY
    d1.visited_on