-- 코드를 작성해주세요
SELECT COUNT(id) fish_count, fish_name
FROM fish_info
JOIN fish_name_info USING(fish_type)
GROUP BY 2
ORDER BY 1 DESC