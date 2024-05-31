-- 코드를 작성해주세요
SELECT COUNT(*) count
FROM ecoli_data
WHERE genotype & 5 > 0 AND genotype & 2 = 0