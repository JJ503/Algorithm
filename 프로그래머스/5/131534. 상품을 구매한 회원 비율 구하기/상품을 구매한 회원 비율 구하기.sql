-- 코드를 입력하세요
WITH USER_2021 AS
(SELECT *
FROM USER_INFO
WHERE YEAR(JOINED) = 2021)

SELECT 
    YEAR(SALES_DATE) AS YEAR,
    MONTH(SALES_DATE) AS MONTH,
    COUNT(DISTINCT USER_ID) AS PURCHAED_USERS,
    ROUND(COUNT(DISTINCT USER_ID) / (SELECT COUNT(* ) FROM USER_2021), 1) AS PURCHAED_RATIO
FROM ONLINE_SALE
WHERE USER_ID IN (SELECT USER_ID FROM USER_2021)
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH