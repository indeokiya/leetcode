# Write your MySQL query statement below

WITH CTE AS (
    SELECT e.left_operand, e.operator, e.right_operand, v1.value AS left_value, v2.value AS right_value
    FROM Expressions e
    INNER JOIN Variables v1 ON e.left_operand = v1.name
    INNER JOIN Variables v2 ON e.right_operand = v2.name
)

SELECT left_operand, operator, right_operand, (
        CASE operator
        WHEN '<' THEN IF(left_value < right_value, 'true', 'false')
        WHEN '>' THEN IF(left_value > right_value, 'true', 'false')
        WHEN '=' THEN IF(left_value = right_value, 'true', 'false')
        END
    ) AS value
FROM CTE
