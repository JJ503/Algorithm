-- 코드를 작성해주세요
SELECT a.id, a.genotype, b.genotype parent_genotype
FROM ecoli_data a, ecoli_data b
WHERE a.parent_id = b.id AND a.genotype & b.genotype = b.genotype
ORDER BY 1