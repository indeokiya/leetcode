# Write your MySQL query statement below

WITH CTE AS (
  SELECT *, RANK() OVER(PARTITION BY project_id ORDER BY experience_years DESC) AS rn
  FROM Project INNER JOIN Employee USING(employee_id)
)

SELECT project_id, employee_id
FROM CTE
WHERE rn = 1
