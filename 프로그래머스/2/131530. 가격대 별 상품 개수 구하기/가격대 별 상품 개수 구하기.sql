-- 코드를 입력하세요
SELECT (price DIV 10000) * 10000 price_group, COUNT(product_id) products
FROM product
GROUP BY 1
ORDER BY 1