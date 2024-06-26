SELECT c.ITEM_ID, c.ITEM_NAME, c.RARITY
FROM ITEM_INFO c
RIGHT OUTER JOIN
    (SELECT a.ITEM_ID
    FROM ITEM_TREE a
    LEFT OUTER JOIN ITEM_TREE b
    ON a.ITEM_ID = b.PARENT_ITEM_ID
    WHERE b.ITEM_ID IS NULL) d
ON c.ITEM_ID = d.ITEM_ID
ORDER BY c.ITEM_ID desc