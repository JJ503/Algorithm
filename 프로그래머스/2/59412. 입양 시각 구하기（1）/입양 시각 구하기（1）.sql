-- 코드를 입력하세요
SELECT HOUR(datetime) hour, COUNT(animal_id) count
FROM animal_outs
WHERE HOUR(datetime) >= 9 AND HOUR(datetime) < 20
GROUP BY 1
ORDER BY 1