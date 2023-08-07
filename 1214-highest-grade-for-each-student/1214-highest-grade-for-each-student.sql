# Write your MySQL query statement below

WITH CTE AS (
    SELECT student_id, course_id, grade, RANK() OVER(PARTITION BY student_id ORDER BY grade DESC, course_id ASC) AS rn
    FROM Enrollments
)

SELECT student_id, course_id, grade
FROM CTE
WHERE rn = 1
ORDER BY student_id