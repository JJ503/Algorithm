-- 코드를 작성해주세요
SELECT id, fish_name, length
FROM fish_info
LEFT JOIN fish_name_info USING(fish_type)
WHERE (fish_type, length) IN (
    SELECT fish_type, MAX(length)
    FROM fish_info
    GROUP BY 1
)
ORDER BY 1