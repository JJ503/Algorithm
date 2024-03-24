-- 코드를 입력하세요
SELECT car_type, COUNT(*) cars
FROM car_rental_company_car
WHERE OPTIONS REGEXP("통풍시트|열선시트|가죽시트")
GROUP BY car_type
ORDER BY car_type