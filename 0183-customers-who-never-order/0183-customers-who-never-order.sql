# Write your MySQL query statement below

SELECT name As Customers
FROM Customers
WHERE id NOT IN (
    SELECT DISTINCT customerId
    FROM Orders
)