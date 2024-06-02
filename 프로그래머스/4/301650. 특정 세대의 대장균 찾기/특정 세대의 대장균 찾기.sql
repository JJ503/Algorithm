-- 코드를 작성해주세요
SELECT e1.id
FROM ecoli_data e1
LEFT JOIN ecoli_data e2 ON e1.parent_id = e2.id
LEFT JOIN ecoli_data e3 ON e2.parent_id = e3.id
WHERE e2.parent_id IS NOT NULL AND e3.parent_id IS NULL
ORDER BY 1