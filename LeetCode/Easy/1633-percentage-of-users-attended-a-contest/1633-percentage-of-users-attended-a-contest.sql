# Write your MySQL query statement below
SELECT r.contest_id, ROUND(COUNT(DISTINCT r.user_id) / COUNT(DISTINCT u.user_id) * 100, 2) percentage
FROM users u JOIN register r
GROUP BY r.contest_id
ORDER BY 2 DESC, 1 ASC