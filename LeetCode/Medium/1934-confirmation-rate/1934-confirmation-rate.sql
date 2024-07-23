# Write your MySQL query statement below
SELECT user_id, ROUND(AVG(IF(action = 'confirmed', 1, 0)), 2) confirmation_rate
FROM signups LEFT JOIN confirmations USING(user_id)
GROUP BY user_id