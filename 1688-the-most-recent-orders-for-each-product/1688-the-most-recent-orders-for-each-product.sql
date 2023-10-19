# Write your MySQL query statement below

WITH CTE AS (
    SELECT
        product_name, product_id, order_id, order_date, RANK() OVER (PARTITION BY product_id ORDER BY order_date DESC) AS rn
    FROM
        Orders o
        JOIN Products p
        USING (product_id)
)

SELECT
    product_name, product_id, order_id, order_date
FROM
    CTE
WHERE
    rn = 1
ORDER BY
    product_name ASC,
    product_id ASC,
    order_id ASC