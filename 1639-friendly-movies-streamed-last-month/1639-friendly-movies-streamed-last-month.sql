# Write your MySQL query statement below

SELECT DISTINCT title
FROM Content c INNER JOIN TVProgram t USING(content_id)
WHERE Kids_content = 'Y' AND content_type = 'Movies' AND program_date LIKE '2020-06-%'