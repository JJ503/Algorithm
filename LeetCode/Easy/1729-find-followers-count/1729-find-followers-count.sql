# Write your MySQL query statement below
SELECT user_id, COUNT(follower_id) followers_count
FROM followers
GROUP BY 1
ORDER BY 1