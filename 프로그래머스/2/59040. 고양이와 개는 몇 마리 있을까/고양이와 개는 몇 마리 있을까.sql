-- 코드를 입력하세요
SELECT animal_type, COUNT(animal_id) count
FROM animal_ins
WHERE animal_type IN ('Cat', 'Dog')
GROUP BY 1
ORDER BY 1