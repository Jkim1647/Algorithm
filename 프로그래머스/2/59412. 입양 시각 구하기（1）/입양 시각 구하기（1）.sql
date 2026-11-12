-- 코드를 입력하세요
SELECT hour(DATETIME) as hour, count(*) as count 
from ANIMAL_OUTS 
where hour(DATETIME) between 9 and 19
group by hour order by 1