-- 코드를 입력하세요
SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') sales_date, product_id, user_id, sales_amount
FROM online_sale
WHERE sales_date LIKE '2022-03-%'
UNION DISTINCT
SELECT DATE_FORMAT(sales_date, '%Y-%m-%d'), product_id, NULL user_id, f.sales_amount
FROM offline_sale f
WHERE sales_date LIKE '2022-03-%'
ORDER BY 1, 2, 3