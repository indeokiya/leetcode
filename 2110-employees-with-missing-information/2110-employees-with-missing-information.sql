# Write your MySQL query statement below

SELECT employee_id
FROM (SELECT employee_id
FROM Employees
UNION ALL
SELECT employee_id
FROM Salaries) t
GROUP BY 1
HAVING COUNT(1) < 2
ORDER BY 1