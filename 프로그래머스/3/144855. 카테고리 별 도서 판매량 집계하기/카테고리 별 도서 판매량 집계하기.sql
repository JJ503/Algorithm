-- 코드를 입력하세요
SELECT category, SUM(sales) total_sales
FROM book
JOIN book_sales USING(book_id)
WHERE sales_date BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY category
ORDER BY category