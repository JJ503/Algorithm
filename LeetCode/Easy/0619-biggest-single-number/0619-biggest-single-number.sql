# Write your MySQL query statement below
SELECT IFNULL(
    (
        SELECT num
        FROM mynumbers
        GROUP BY 1
        HAVING COUNT(num) = 1
        ORDER BY 1 DESC
        LIMIT 1
    )
    , null
) AS num
