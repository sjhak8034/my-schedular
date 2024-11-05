use schedulardb;

CREATE TABLE `Schedules` (
                             schedule_id	int	AUTO_INCREMENT PRIMARY KEY,
                             posted_date	datetime	NOT NULL	,
                             title	varchar(20)	NOT NULL	,
                             content	varchar(100)	NOT NULL	D,
                             password	varchar(20)	NOT NULL	,
                             user_name	varchar(20)	NOT NULL
);




INSERT INTO schedulardb.schedules (posted_date, title , content, password, user_name ) VALUES ('2024-01-01-00-00-00','work','meeting','asdf1234','홍길동');
update schedulardb.schedules set posted_date ='2024-01-03', title = 'travel', content = 'go to restaurant'  where schedule_id = 1;
DELETE FROM schedulardb.schedules WHERE schedule_id = 1;


select title, content from schedulardb.schedules where schedule_id = 1;
select schedule_id from schedulardb.schedules where posted_date BETWEEN '2024-01-01 00:00:00' AND '2024-11-30 23:59:59' limit 10;
