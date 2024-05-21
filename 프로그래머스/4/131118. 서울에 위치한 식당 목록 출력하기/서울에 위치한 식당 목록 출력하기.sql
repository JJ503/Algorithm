-- 코드를 입력하세요
SELECT rest_id, rest_name, food_type, favorites, address, ROUND(AVG(review_score), 2) score
FROM rest_info
JOIN rest_review USING(rest_id)
WHERE address LIKE '서울%'
GROUP BY 1
ORDER BY 6 DESC, 4 DESC