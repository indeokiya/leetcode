# Write your MySQL query statement below

SELECT
    transaction_id
FROM
    Transactions
WHERE
    (DAY(day), amount) IN (
        SELECT
            DAY(day), MAX(amount) OVER (PARTITION BY DAY(day))
        FROM
            Transactions
    )
ORDER BY
    transaction_id