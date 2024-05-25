-- 코드를 작성해주세요
SELECT id, email, first_name, last_name
FROM developers
WHERE skill_code & (SELECT sum(code)
                    FROM skillcodes
                    WHERE name IN ('Python', 'C#')) != 0
ORDER BY 1