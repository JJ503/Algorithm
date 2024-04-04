-- 코드를 입력하세요
SELECT YEAR(sales_date) year, MONTH(sales_date) month, gender, COUNT(DISTINCT(user_id)) users
FROM user_info
JOIN online_sale USING(user_id)
WHERE gender IS NOT NULL
GROUP BY 1, 2, 3
ORDER BY 1, 2, 3