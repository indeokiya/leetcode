# Write your MySQL query statement below

WITH FriendOf1 AS (
    SELECT user2_id AS friend_id
    FROM Friendship
    WHERE user1_id = 1
    UNION ALL
    SELECT user1_id AS friend_id
    FROM Friendship
    WHERE user2_id = 1    
)

SELECT DISTINCT page_id AS recommended_page
FROM Likes
WHERE user_id IN (SELECT friend_id FROM FriendOf1)
    AND page_id NOT IN (SELECT page_id FROM Likes Where user_id = 1)