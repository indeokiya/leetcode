# Write your MySQL query statement below

WITH CTE AS (
    SELECT
        transaction_id, RANK() OVER (PARTITION BY DATE(day) ORDER BY amount DESC) rn
    FROM
        Transactions
)

SELECT
    transaction_id
FROM
    CTE
WHERE
    rn = 1
ORDER BY
    transaction_id