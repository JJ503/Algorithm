# Write your MySQL query statement below
SELECT project_id, ROUND(SUM(experience_years) / COUNT(employee_id), 2) average_years
FROM project LEFT JOIN employee USING(employee_id)
GROUP BY 1