# Write your MySQL query statement below

WITH SalaryRank AS (
    SELECT *, DENSE_RANK() OVER(ORDER BY salary DESC) AS rn
    FROM Employee
)

SELECT IFNULL((SELECT DISTINCT salary FROM SalaryRank WHERE rn = 2), NULL) AS SecondHighestSalary