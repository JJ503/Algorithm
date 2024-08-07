# Write your MySQL query statement below
SELECT a1.machine_id AS machine_id, ROUND(AVG(a1.timestamp - a2.timestamp), 3) AS processing_time
FROM activity a1 JOIN activity a2
ON a1.machine_id = a2.machine_id AND a1.process_id = a2.process_id
    AND a1.activity_type = 'end' AND a2.activity_type = 'start'
GROUP BY 1