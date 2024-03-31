-- 코드를 입력하세요
SELECT mcdp_cd 진료과코드, COUNT(mddr_id) 5월예약건수
FROM appointment
WHERE DATE_FORMAT(apnt_ymd, '%Y-%m-%d') BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY 1
ORDER BY 2, 1