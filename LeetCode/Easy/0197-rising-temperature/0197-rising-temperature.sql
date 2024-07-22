# Write your MySQL query statement below
SELECT t.id
FROM weather t JOIN weather y ON t.recordDate = DATE_ADD(y.recordDate, INTERVAL 1 DAY)
WHERE t.temperature > y.temperature
ORDER BY t.recordDate