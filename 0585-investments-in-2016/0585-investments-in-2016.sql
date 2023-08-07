# Write your MySQL query statement below

WITH Duplicate_tiv_2015 AS (
    SELECT tiv_2015
    FROM Insurance
    GROUP BY tiv_2015
    HAVING COUNT(1) > 1
), Unique_lat_lon AS (
    SELECT pid
    FROM Insurance
    GROUP BY lat, lon
    HAVING COUNT(1) = 1
)

SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM Insurance
WHERE tiv_2015 IN (SELECT tiv_2015 FROM Duplicate_tiv_2015) AND pid IN (SELECT pid FROM Unique_lat_lon)