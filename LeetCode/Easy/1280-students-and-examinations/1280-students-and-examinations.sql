# Write your MySQL query statement below
SELECT student_id, student_name, subject_name, COUNT(e.student_id) AS attended_exams
FROM students CROSS JOIN subjects
    LEFT JOIN examinations e USING(student_id, subject_name)
GROUP BY 1, 3
ORDER BY 1, 3