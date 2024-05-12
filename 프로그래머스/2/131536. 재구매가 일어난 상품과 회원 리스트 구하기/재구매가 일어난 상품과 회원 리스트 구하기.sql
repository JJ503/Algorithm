-- 코드를 입력하세요
SELECT user_id, product_id
FROM online_sale
GROUP BY user_id, product_id
HAVING COUNT(online_sale_id) > 1
ORDER BY 1, 2 DESC