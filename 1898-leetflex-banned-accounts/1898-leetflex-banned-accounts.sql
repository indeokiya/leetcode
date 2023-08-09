# Write your MySQL query statement below

WITH CTE AS (
  SELECT *, DENSE_RANK() OVER(PARTITION BY account_id ORDER BY login ASC, logout ASC) AS rn
  FROM LogInfo
)

SELECT DISTINCT c1.account_id
FROM CTE c1 INNER JOIN CTE c2 ON c1.account_id = c2.account_id AND c1.rn = c2.rn - 1 
WHERE c2.login <= c1.logout AND c1.ip_address <> c2.ip_address