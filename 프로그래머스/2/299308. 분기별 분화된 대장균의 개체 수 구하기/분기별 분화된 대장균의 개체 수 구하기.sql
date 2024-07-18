SELECT concat(quarter(differentiation_date),'Q') AS QUARTER ,count(concat(quarter(differentiation_date),'Q')) as ECOLI_COUNT
FROM ECOLI_DATA
group by (concat(quarter(differentiation_date),'Q'))

