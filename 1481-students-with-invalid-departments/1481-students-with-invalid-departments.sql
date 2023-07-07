# Write your MySQL query statement below

SELECT
    s.id, s.name
FROM
    Students s
WHERE
    s.department_id NOT IN (
        SELECT
            id
        FROM
            Departments
    )
;