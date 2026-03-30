SELECT history_id, car_id, date_format(start_date, "%Y-%m-%d") as start_date,
date_format(end_date, "%Y-%m-%d") as end_date, 
CASE 
WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30
THEN '장기 대여'
ELSE '단기 대여'
END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE start_date between '2022-09-01' and '2022-09-30'
ORDER BY history_id desc;