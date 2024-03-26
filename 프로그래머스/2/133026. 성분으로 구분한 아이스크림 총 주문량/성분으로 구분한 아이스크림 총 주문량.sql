-- 코드를 입력하세요
SELECT ingredient_type, SUM(total_order) total_order
FROM first_half
JOIN icecream_info USING(FLAVOR)
GROUP BY ingredient_type
ORDER BY SUM(total_order)