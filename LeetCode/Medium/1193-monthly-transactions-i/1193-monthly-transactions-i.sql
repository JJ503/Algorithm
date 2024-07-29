# Write your MySQL query statement below
SELECT SUBSTRING(trans_date, 1, 7) month,
    country,
    COUNT(*) trans_count,
    SUM(state = 'approved') approved_count,
    SUM(amount) trans_total_amount,
    SUM(IF(state = 'approved', amount, 0)) approved_total_amount
FROM transactions
GROUP BY 1, 2