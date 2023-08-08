# Write your MySQL query statement below

SELECT u.name, SUM(t.amount) AS balance
FROM Users u INNER JOIN Transactions t USING(account)
GROUP BY account
HAVING balance > 10000