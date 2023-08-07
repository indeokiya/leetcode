# Write your MySQL query statement below

SELECT d.name AS Department, e1.name AS Employee, salary
FROM Employee e1 INNER JOIN Department d ON e1.departmentId = d.id
WHERE 3 > (
  SELECT COUNT(DISTINCT e2.salary)
  FROM Employee e2
  WHERE e1.departmentId = e2.departmentId AND e1.salary < e2.salary
)