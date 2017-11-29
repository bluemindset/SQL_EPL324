IF OBJECT_ID('countHorsesByAgeProc', 'P') IS NOT NULL
		DROP PROCEDURE countHorsesByAgeProc;
GO
CREATE PROCEDURE countHorsesByAgeProc
--If max age is 0 maxAge is not taken into consideration.
--(Horses that are shown are from @minAge to MAX_HORSE_AGE
@minAge  AS INTEGER , @maxAge	AS INTEGER
AS
BEGIN
	DECLARE @MIN_AGE INTEGER;
	DECLARE @MAX_AGE INTEGER;
	SET @MIN_AGE = @minAge;
	SET @MAX_AGE = (SELECT MAX(H.age) AS oldestHorse
				    FROM HORSE H);
	IF @maxAge != 0
		SET @MAX_AGE = @max_age;

	SELECT H.age, COUNT(*) countHorsesByAge
	FROM HORSE H
	WHERE H.age BETWEEN @minAge AND @maxAge
	GROUP BY H.age
END;
EXEC countHorsesByAgeProc @minAge = 0, @maxAge =  25;

