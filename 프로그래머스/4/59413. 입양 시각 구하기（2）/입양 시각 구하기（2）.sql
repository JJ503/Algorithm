-- 코드를 입력하세요
WITH RECURSIVE time AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour+1 FROM time WHERE hour<23
)

SELECT time.hour, COUNT(DISTINCT(animal_id)) count
FROM time
LEFT JOIN animal_outs on HOUR(datetime)=time.hour
GROUP BY 1
ORDER BY 1