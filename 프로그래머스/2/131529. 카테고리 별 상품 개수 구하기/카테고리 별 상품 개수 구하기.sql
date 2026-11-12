-- 코드를 입력하세요
SELECT LEFT(PRODUCT_CODE,2) as CATEGORY, count(*) from PRODUCT group by CATEGORY order by 1