-- 코드를 입력하세요
WITH rental AS (
    SELECT
        history_id,
        car_type,
        daily_fee,
        DATEDIFF(end_date, start_date)+1 AS duration, 
        CASE
            WHEN DATEDIFF(end_date, start_date)+1 >= 90 THEN '90일 이상'
            WHEN DATEDIFF(end_date, start_date)+1 >= 30 THEN '30일 이상'
            WHEN DATEDIFF(end_date, start_date)+1 >= 7 THEN '7일 이상'
            ELSE '할인 없음'
        END AS duration_type
    FROM car_rental_company_rental_history
    LEFT JOIN car_rental_company_car USING(car_id)
    WHERE car_type = '트럭'
)

SELECT
    history_id, ROUND(duration * daily_fee * (100 - ifnull(discount_rate, 0)) / 100) fee
FROM rental r
LEFT JOIN car_rental_company_discount_plan p ON r.car_type = p.car_type AND
    CASE
        WHEN duration >= 90 THEN '90일 이상'
        WHEN duration >= 30 THEN '30일 이상'
        WHEN duration >= 7 THEN '7일 이상'
    END = p.duration_type
ORDER BY 2 DESC, 1 DESC