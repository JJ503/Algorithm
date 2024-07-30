# Write your MySQL query statement below
SELECT teacher_id, COUNT(*) cnt
FROM teacher
GROUP BY teacher_id, subject_id, dept_id