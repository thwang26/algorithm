SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, "%Y-%m-%d") AS PUBLISHED_DATE
FROM BOOK B
         JOIN AUTHOR A ON (B.AUTHOR_ID = A.AUTHOR_ID)
WHERE B.CATEGORY = '경제'
ORDER BY B.PUBLISHED_DATE ASC;