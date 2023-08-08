# Write your MySQL query statement below

SELECT customer_id, name
FROM (
  SELECT *
  FROM Orders o INNER JOIN Product p USING (product_id) INNER JOIN Customers c USING (customer_id)
  WHERE YEAR(order_date) = 2020 AND MONTH(order_date) BETWEEN 6 AND 7
  GROUP BY customer_id, MONTH(order_date)
  HAVING SUM(quantity * price) >= 100
) t
GROUP BY customer_id
HAVING COUNT(1) > 1
