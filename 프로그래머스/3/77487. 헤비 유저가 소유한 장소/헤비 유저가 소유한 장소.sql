SELECT P.ID, P.NAME, P.HOST_ID
FROM PLACES P
         JOIN
     (SELECT HOST_ID, COUNT(HOST_ID) AS COUNT
      FROM PLACES
      GROUP BY HOST_ID) P2
     ON (P.HOST_ID = P2.HOST_ID)
WHERE P2.COUNT > 1
ORDER BY P.ID ASC;