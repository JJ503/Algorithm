-- 코드를 작성해주세요
SELECT dept_id, dept_name_en, ROUND(AVG(sal), 0) avg_sal
FROM hr_employees
JOIN hr_department USING(dept_id)
GROUP BY 1
ORDER BY 3 DESC