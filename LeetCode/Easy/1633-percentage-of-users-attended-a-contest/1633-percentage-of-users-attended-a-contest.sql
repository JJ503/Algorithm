# Write your MySQL query statement below
SELECT contest_id, ROUND(COUNT(DISTINCT user_id) / (SELECT COUNT(user_id) FROM users) * 100, 2) percentage
FROM register
GROUP BY contest_id
ORDER BY 2 DESC, 1 ASC