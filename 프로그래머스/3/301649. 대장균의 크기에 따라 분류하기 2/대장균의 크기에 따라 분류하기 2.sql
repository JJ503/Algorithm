-- 코드를 작성해주세요
SELECT id,
    CASE
    WHEN a.per <= 0.25 THEN 'CRITICAL'
    WHEN a.per <= 0.5 THEN 'HIGH'
    WHEN a.per <= 0.75 THEN 'MEDIUM'
    ELSE 'LOW'
    END AS colony_name
FROM (SELECT id, PERCENT_RANK() OVER (ORDER BY size_of_colony DESC) AS per
    FROM ecoli_data) a
ORDER BY 1