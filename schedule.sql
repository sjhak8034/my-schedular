use schedulardb;
CREATE TABLE `Calender` (
                            `date`	DATE	NOT NULL	DEFAULT '2024-01-01',
                            `month`	int	NOT NULL	DEFAULT 01,
                            `day`	int	NOT NULL	DEFAULT 01,
                            `id`	int	NULL	DEFAULT NULL
);

CREATE TABLE `Schedules` (
                             `hour`	int	NULL	DEFAULT NULL,
                             `minute`	int	NULL	DEFAULT NULL,
                             `title`	varchar(20)	NULL	DEFAULT NULL,
                             `content`	varchar(100)	NULL	DEFAULT NULL,
                             `date`	DATE	NOT NULL	DEFAULT '2024-01-01',
                             `id`	int	NULL	DEFAULT NULL
);

CREATE TABLE `User` (
                        `id`	int	NULL	DEFAULT NULL,
                        `userId`	varchar(20)	NOT NULL,
                        `password`	varchar(20)	NOT NULL,
                        `name`	varchar(20)	NOT NULL	DEFAULT '홍길동'
);

ALTER TABLE `Calender` ADD CONSTRAINT `PK_CALENDER` PRIMARY KEY (
                                                                 `date`
    );

ALTER TABLE `User` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
                                                         `id`
    );
SHOW TABLES IN schedulardb;
INSERT INTO schedulardb.calender (`date`, `month`, `day` ,`id` ) VALUES ('2024-01-01',01,01,1);
INSERT INTO schedulardb.schedules (`hour`, `minute`, title , content, `date`,id ) VALUES (00,00,'work','meeting','2024-01-01',1);
update schedulardb.calender set `date` = 2024-01-01, `month` = 01, `day`= 01 ,`id` = 1;
update schedulardb.schedules set `hour` = 00, `minute` = 00, title ='travel', content = 'shopping', `date` = '2024-01-01',id = 1;
DELETE FROM schedulardb.schedules WHERE `date` = 2024-01-01;
DELETE FROM schedulardb.calender WHERE `date` = 2024-01-01;

select * from schedulardb.schedules;
select * from schedulardb.calender;