-- 코드를 입력하세요
SELECT animal_id, o.name
FROM animal_ins i
LEFT JOIN animal_outs o USING(animal_id)
ORDER BY DATEDIFF(o.datetime, i.datetime) DESC
LIMIT 2