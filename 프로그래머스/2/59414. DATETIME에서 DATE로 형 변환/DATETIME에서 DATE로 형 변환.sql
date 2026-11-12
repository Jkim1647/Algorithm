-- 코드를 입력하세요
-- SELECT ANIMAL_ID, NAME, year(DATETIME)+"-"+month(DATETIME)+'-'+day(DATETIME) as "날짜" from ANIMAL_INS 

SELECT ANIMAL_ID, NAME, date_format(DATETIME, '%Y-%m-%d') as "날짜" from ANIMAL_INS