# Write your MySQL query statement below

SELECT
    product_name, SUM(unit) AS unit
FROM
    Products p
        INNER JOIN
    Orders o ON
        DATEDIFF('2020-02-29', o.order_date) BETWEEN 0 AND 28 AND
        p.product_id = o.product_id
GROUP BY
    p.product_id
HAVING
    unit >= 100