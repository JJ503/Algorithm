-- 코드를 작성해주세요
SELECT COUNT(id) fish_count, MAX(length) max_length, fish_type
FROM fish_info
GROUP BY 3
HAVING AVG(IFNULL(length, 10)) >= 33
ORDER BY 3