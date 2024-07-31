# Write your MySQL query statement below
SELECT activity_date day, COUNT(DISTINCT user_id) active_users
FROM activity
WHERE 0 <= DATEDIFF('2019-07-27', activity_date) AND DATEDIFF('2019-07-27', activity_date) < 30
GROUP BY 1