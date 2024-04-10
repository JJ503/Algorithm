-- 코드를 작성해주세요
WITH grade_info AS (
    SELECT emp_no,
    CASE
        WHEN AVG(score) >= 96 THEN 'S'
        WHEN AVG(score) >= 90 THEN 'A'
        WHEN AVG(score) >= 80 THEN 'B'
        ELSE 'C'
    END AS grade,
    CASE
        WHEN AVG(score) >= 96 THEN 0.2 * sal
        WHEN AVG(score) >= 90 THEN 0.15 * sal
        WHEN AVG(score) >= 80 THEN 0.1 * sal
    ELSE 0
    END AS bonus
    FROM hr_employees
    JOIN hr_grade USING(emp_no)
    GROUP BY 1
)


SELECT emp_no, emp_name, grade, bonus
FROM hr_employees
JOIN grade_info USING(emp_no)
ORDER BY 1