-- 코드를 입력하세요
SELECT COUNT(*) users
FROM user_info
WHERE YEAR(joined) = 2021 AND 20 <= age AND age <= 29