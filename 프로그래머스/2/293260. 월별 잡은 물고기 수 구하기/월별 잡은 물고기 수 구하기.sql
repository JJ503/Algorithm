-- 코드를 작성해주세요
SELECT COUNT(id) fish_count, MONTH(time) month
FROM fish_info
GROUP BY 2
ORDER BY 2