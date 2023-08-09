# Write your MySQL query statement below

SELECT customer_id, name
FROM Orders o INNER JOIN Product p USING (product_id) INNER JOIN Customers c USING (customer_id)
WHERE YEAR(order_date) = 2020 AND MONTH(order_date) BETWEEN 6 AND 7
GROUP BY customer_id
HAVING SUM((MONTH(order_date) = 6) * quantity * price) >= 100 AND
        SUM((MONTH(order_date) = 7) * quantity * price) >= 100

