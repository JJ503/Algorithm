-- 코드를 입력하세요
SELECT user_id,
        nickname,
        CONCAT(city, ' ', street_address1, ' ', street_address2) 전체주소,
        CONCAT(SUBSTRING(tlno, 1, 3), '-', SUBSTRING(tlno, 4, 4), '-', SUBSTRING(tlno, 8, 4)) 전화번호
FROM used_goods_board
JOIN used_goods_user ON user_id = writer_id
GROUP BY writer_id
HAVING COUNT(board_id) >= 3
ORDER BY 1 DESC