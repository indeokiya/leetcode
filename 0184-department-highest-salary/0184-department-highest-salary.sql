# Write your MySQL query statement below

WITH CTE AS (
SELECT d.name AS Department, e.name AS Employee, e.salary, RANK() OVER(PARTITION BY e.departmentId ORDER BY salary DESC) AS rn
FROM Employee e INNER JOIN Department d ON e.departmentId = d.id
)

SELECT department, employee, salary
FROM CTE
WHERE rn = 1
