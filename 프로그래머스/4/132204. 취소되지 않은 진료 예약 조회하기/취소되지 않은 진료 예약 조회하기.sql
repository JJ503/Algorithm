-- 코드를 입력하세요
SELECT apnt_no, pt_name, pt_no, a.mcdp_cd, dr_name, apnt_ymd
FROM appointment a
JOIN patient USING(pt_no)
JOIN doctor ON dr_id = mddr_id
WHERE apnt_ymd LIKE '2022-04-13%' AND apnt_cncl_yn = 'N'
ORDER BY 6