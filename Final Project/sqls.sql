use itm411db

select * from daylightrecord where rownum < 10

update DAYLIGHTRECORD set
 daylength = UNIX_TIMESTAMP(sunset)-UNIX_TIMESTAMP(sunrise)
 where sunrise = '2013-01-01 07:18:56'

describe daylightrecord

update daylightrecord set 
nightlength=UNIX_TIMESTAMP(sunrise)-lag(UNIX_TIMESTAMP(sunset)) 
where sunrise='2013-01-01 07:18:56'

SELECT A.sunrise,  
(timestampdiff(MINUTE,A.sunset,B.sunrise)) AS timedifference
FROM daylightrecord A CROSS JOIN daylightrecord B
WHERE B.sunrise IN 
(SELECT min(c.sunrise) FROM daylightrecord c 
WHERE C.sunrise > A.sunrise)
and a.sunrise = '2013-01-03 07:18:56'
ORDER BY A.sunrise ASC

select sunrise,sunset, daylength, timestampdiff(MINUTE,sunrise,sunset)
from daylightrecord

update daylightrecord as D set nightlength =
(
	select timestampdiff(MINUTE,A.sunset,B.sunrise) AS nightlength
	FROM daylightrecord A CROSS JOIN daylightrecord B
	WHERE B.sunrise IN 
	(
		SELECT min(c.sunrise) FROM daylightrecord c 
		WHERE C.sunrise > A.sunrise
	)
	and a.sunrise = '2013-01-03 07:18:00'
)
where sunrise = '2013-01-03 07:18:00'

update DAYLIGHTRECORD set daylength = timestampdiff(MINUTE,sunrise,sunset) 
 where sunrise = '2013-01-01 07:18:56'

insert into daylightrecord values('2013-01-01 07:18:56','2013-01-01 17:18:56'
,timestampdiff(MINUTE,'2013-01-01 07:18:56','2013-01-01 17:18:56'),null);

insert into daylightrecord values('2013-01-01 07:18:56','2013-01-01 17:18:56',null,null);

select * from daylightrecord where sunrise = '2013-01-01 07:18:00'

select min(sunrise) from daylightrecord

select max(rowcount) from daylightrecord


UPDATE daylightrecord SET SUNRISE = '2013-01-01 07:18:56' 
where DATE_FORMAT(sunrise,'%m-%d-%Y') = '01-01-2013'

update daylightrecord SET daylength =




select * from daylightrecord where DATE_FORMAT(sunrise,'%m-%d-%Y') = '01-01-2013'