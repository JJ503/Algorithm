-- 코드를 작성해주세요
WITH developers_skill_info AS (
    SELECT id, email, CASE 
        WHEN skill_code & (SELECT code FROM skillcodes WHERE name = 'Python') > 0
            AND skill_code & (SELECT SUM(code) FROM skillcodes WHERE category = 'Front End') > 0 THEN 'A'
        WHEN skill_code & (SELECT code FROM skillcodes WHERE name = 'C#') > 0 THEN 'B'
        WHEN skill_code & (SELECT SUM(code) FROM skillcodes WHERE category = 'Front End') > 0 THEN 'C'
        ELSE NULL
        END AS grade
    FROM developers
)


SELECT grade, id, email
FROM developers_skill_info
WHERE grade IS NOT NULL
ORDER BY 1, 2