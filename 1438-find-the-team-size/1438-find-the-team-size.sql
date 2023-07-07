# Write your MySQL query statement below

SELECT
    e.employee_id, t.team_size
FROM
    Employee e
        INNER JOIN
    (SELECT
        team_id,
        COUNT(employee_id) AS team_size
    FROM
        Employee
    GROUP BY
        team_id) t ON
    e.team_id = t.team_id
