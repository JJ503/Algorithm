-- 코드를 작성해주세요
SELECT
    route,
    CONCAT(ROUND(SUM(d_between_dist), 1), "km") total_distance,
    CONCAT(ROUND(AVG(d_between_dist), 2), "km") average_distance
FROM subway_distance
GROUP BY 1
ORDER BY 1 DESC