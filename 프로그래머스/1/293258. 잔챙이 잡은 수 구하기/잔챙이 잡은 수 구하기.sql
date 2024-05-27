-- 코드를 작성해주세요
SELECT COUNT(*) fish_count
FROM fish_info
WHERE length IS NULL OR length < 10