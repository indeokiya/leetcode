# Write your MySQL query statement below

WITH CTE AS (
    SELECT
        c.name AS customer_name, customer_id, order_id, order_date,
        ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY order_date DESC) AS rn
    FROM
        Orders o
        INNER JOIN Customers c
        USING (customer_id)
)

SELECT
    customer_name, customer_id, order_id, order_date
FROM
    CTE
WHERE
    rn <= 3
ORDER BY
    1 ASC, 2 ASC, 4 DESC