-- 코드를 입력하세요
SELECT 
        RC.CAR_ID
      , RC.CAR_TYPE
      , FLOOR(RC.DAILY_FEE * 30 * (100 - RD.DISCOUNT_RATE)/100) AS FEE
  FROM CAR_RENTAL_COMPANY_CAR RC
  JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN RD
        ON RC.CAR_TYPE = RD.CAR_TYPE AND RD.DURATION_TYPE = '30일 이상'
 WHERE 
        RC.CAR_TYPE IN ('세단', 'SUV')
        AND RC.CAR_ID NOT IN (
                SELECT CAR_ID
                FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                WHERE START_DATE <= '2022-11-30'
                  AND END_DATE >= '2022-11-01'
            )
        AND (RC.DAILY_FEE * 30 * (1 - RD.DISCOUNT_RATE / 100)) >= 500000
        AND (RC.DAILY_FEE * 30 * (1 - RD.DISCOUNT_RATE / 100)) < 2000000
 ORDER BY FEE DESC, RC.CAR_TYPE, RC.CAR_ID DESC;
 


-- WHERE : 종류가 '세단' 혹은 'SUV'
-- 대여 가능 기간 : 2022-11-1 ~ 2022-11-30
-- 30일간의 대여 금액이 50만 이상, 200만 미만

-- 정렬 : 대여 금액 내림차순, 자동차 종류 오름차순, 자동차 ID DESC