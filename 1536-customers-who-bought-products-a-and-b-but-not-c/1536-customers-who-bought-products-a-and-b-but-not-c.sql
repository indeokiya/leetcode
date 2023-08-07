# Write your MySQL query statement below

WITH boughtA AS (
    SELECT DISTINCT customer_id
    FROM Orders
    WHERE product_name = 'A'
), boughtB AS (
    SELECT DISTINCT customer_id
    FROM Orders
    WHERE product_name = 'B'
), boughtC AS (
    SELECT DISTINCT customer_id
    FROM Orders
    WHERE product_name = 'C'
)

SELECT
    *
FROM
    Customers
WHERE
    customer_id IN (SELECT * FROM boughtA) AND
    customer_id IN (SELECT * FROM boughtB) AND
    customer_id NOT IN (SELECT * FROM boughtC)
ORDER BY customer_id