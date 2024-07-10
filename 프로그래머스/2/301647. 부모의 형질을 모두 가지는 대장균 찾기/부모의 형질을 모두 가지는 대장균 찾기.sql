select a.id, a.genotype, b.genotype as `PARENT_GENOTYPE` from ECOLI_DATA a
LEFT OUTER JOIN ECOLI_DATA b
on a.parent_ID = b.id
where (a.genotype | b.genotype) = a.genotype
order by a.id