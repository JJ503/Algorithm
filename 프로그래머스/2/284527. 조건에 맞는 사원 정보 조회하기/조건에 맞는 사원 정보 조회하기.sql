-- 코드를 작성해주세요
SELECT SUM(score) score, emp_no, emp_name, position, email
FROM hr_employees
JOIN hr_grade USING(emp_no)
WHERE year = 2022
GROUP BY 2
ORDER BY 1 DESC
LIMIT 1