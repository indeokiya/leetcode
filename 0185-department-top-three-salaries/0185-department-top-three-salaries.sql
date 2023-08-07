# Write your MySQL query statement below

WITH SalaryRank AS (
  SELECT e.id, e.name, e.salary, d.name AS department, DENSE_RANK() OVER(PARTITION BY d.id ORDER BY e.salary DESC) AS rn
  FROM Employee e INNER JOIN Department d ON e.departmentId = d.id
)

SELECT department, name AS Employee, salary
FROM SalaryRank
WHERE rn <= 3