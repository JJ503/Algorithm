# Write your MySQL query statement below
SELECT e1.employee_id, e1.name, COUNT(e2.reports_to) reports_count, ROUND(AVG(e2.age)) average_age
FROM employees e1 LEFT JOIN employees e2 ON e1.employee_id = e2.reports_to
WHERE e2.reports_to IS NOT NULL
GROUP BY 1
ORDER BY 1