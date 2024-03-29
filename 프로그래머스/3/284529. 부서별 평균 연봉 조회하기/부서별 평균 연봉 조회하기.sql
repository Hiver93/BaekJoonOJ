SELECT a.DEPT_ID, b.DEPT_NAME_EN, ROUND(AVG(a.SAL)) as AVG_SAL
FROM HR_EMPLOYEES a
LEFT OUTER JOIN HR_DEPARTMENT b
ON a.DEPT_ID = b.DEPT_ID
GROUP BY a.DEPT_ID
ORDER BY AVG_SAL desc