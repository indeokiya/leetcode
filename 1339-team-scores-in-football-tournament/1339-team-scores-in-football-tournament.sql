# Write your MySQL query statement below

WITH Host AS (
    SELECT t.team_id, t.team_name, SUM(CASE
        WHEN m.host_goals > guest_goals THEN 3 
        WHEN m.host_goals = guest_goals THEN 1
        ELSE 0
        END
    ) AS num_points
    FROM Teams t LEFT JOIN Matches m ON t.team_id = m.host_team
    GROUP BY team_id
), Guest AS (
    SELECT t.team_id, t.team_name, SUM(CASE
        WHEN m.host_goals < guest_goals THEN 3
        WHEN m.host_goals = guest_goals THEN 1
        ELSE 0
        END
    ) AS num_points
    FROM Teams t LEFT JOIN Matches m ON t.team_id = m.guest_team
    GROUP BY team_id    
)

SELECT team_id, team_name, SUM(num_points) AS num_points
FROM (SELECT * FROM Host UNION ALL SELECT * FROM Guest) tt
GROUP BY team_id
ORDER BY num_points DESC, team_id ASC