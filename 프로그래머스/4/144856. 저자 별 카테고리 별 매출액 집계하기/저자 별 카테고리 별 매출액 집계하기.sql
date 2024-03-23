-- 코드를 입력하세요
SELECT b.author_id, author_name, category, SUM(sales * price) AS total_sales
FROM book b
JOIN author USING(author_id)
LEFT JOIN book_sales USING(book_id)
WHERE sales_date LIKE '2022-01%'
GROUP BY b.author_id, category
ORDER BY author_id, category DESC