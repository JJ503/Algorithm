-- 코드를 작성해주세요
WITH max_size AS (
    SELECT MAX(size_of_colony) max_dev, YEAR(differentiation_date) year
    FROM ecoli_data
    GROUP BY 2
)

SELECT YEAR(e.differentiation_date) year, (m.max_dev - e.size_of_colony) year_dev, id
FROM max_size m
INNER JOIN ecoli_data e ON YEAR(e.differentiation_date) = m.year
ORDER BY 1, 2