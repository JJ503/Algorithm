-- 코드를 입력하세요
SELECT title, board_id, reply_id, r.writer_id, r.contents, DATE_FORMAT(r.created_date, '%Y-%m-%d') created_date
FROM used_goods_board b
JOIN used_goods_reply r USING(board_id)
WHERE b.created_date LIKE '2022-10-%'
ORDER BY 6, 1