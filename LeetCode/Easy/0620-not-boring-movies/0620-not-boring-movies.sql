# Write your MySQL query statement below
SELECT id, movie, description, rating
FROM cinema
WHERE description != 'boring' AND id % 2 != 0
ORDER BY 4 DESC