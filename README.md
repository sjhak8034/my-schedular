# my-schedular
# 목차
* [일정 관리 API 명세서](#1-일정-관리-API-명세서)
* [ERD](#2-ERD)
* [Query 목록 ](#3-Query-목록)
## 1. 일정 관리 API 명세서
### 요약
|기능|	method|	url	|request	|response	|status|
|-------------|----|---------------|-----------|---------|--------------|
|일정 생성|POST|	/api/schedules|	요청 body	|등록 정보	|201: 정상 등록|
|특정기간 일정 목록 조회|	GET	|/api/schedules?start-date="시작날짜"&end-date="마지막 날짜"|	요청 param	|다건 응답 정보	|200: 정상 조회|
|특정 일정 조회|	GET	|/api/schedules/{scheduleId}|	요청 param|	단건 응답 정보|	200: 정상 조회|
|일정 수정|	PUT|	/api/schedules/{scheduleId}|	요청 body	|수정 정보	|200: 정상 수정|
|일정 삭제|	DELETE|	/api/schedules/{scheduleId}|	요청 param	|삭제 정보	|204: 정상 삭제|
### 일정 생성 
* POST/api/schedules
* 요청 Request
  * Headers: Authorization: 비밀번호 (비밀번호를 요청 헤더로 전달)
  * Body:
 
 
 ```
{
    "title": "work",
    "content": "meeting",
    "userName": "홍길동"

}
```


|#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|제목|title|String|o|20글자 제한|
|2|할일|content|String|o|100글자 제한|
|3|작성자명|userName|String|o|20글자 제한|


* 응답 Response
  * Status Code: 201 Created

  * Body:

```
{
    "responseMessage" : "일정 등록 성공하였습니다."
}
```


|#|변수 설명|변수 이름|타입|Nullable|description|
|-|-|-|-|-|-|
|1|요청 결과|responseMessage|	String| x	| |


### 특정기간 일정 목록 조회
* GET/api/schedules
* 요청 Request
  * parameters:
     * startDate (optional) : 조회할 작성일 (시작) (YYYY-MM-DD)
     * endDate (optional) : 조회할 작성일 (끝) (YYYY-MM-DD)
     * userName (optional) : 조회할 작성자명
  * 정렬: 작성일 기준 내림차순
 
|#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|시작 일|startDate|String|o|YYYY-MM-DD|
|2|마지막 일|endDate|String|o|YYYY-MM-DD|
|3|작성자명|userName|String|o|20글자 제한|


* 응답
  * Status Code: 200 OK
  * Body


```
[
    {
        "scheduleId": "게시글 고유 번호",
        "content": "할일 내용",
        "userName": "작성자명",
        "postedDate": "YYYY-MM-DD HH:mm:ss",
        "editedDate": "YYYY-MM-DD HH:mm:ss"
    },
    ...
]
```
|#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|게시글 고유 번호|scheduleId|int|o|YYYY-MM-DD|
|2|할일 내용|content|String|o|YYYY-MM-DD|
|3|작성자명|userName|String|o|20글자 제한|
|4|postedDate|postedDate|String|o|YYYY-MM-DD HH:mm:ss|
|5|editedDate|editedDate|String|o|YYYY-MM-DD HH:mm:ss|



### 특정 일정 조회
* GET /api/schedules/{scheduleId}
* 요청 Request
   * Path Variable: scheduleId
* 응답
   * Status Code: 200 OK
   * Body:
```
{
    "scheduleId": "게시글 고유 번호",
    "content": "할일 내용",
    "userName": "작성자명",
    "postedDate": "YYYY-MM-DD HH:mm:ss",
    "editedDate": "YYYY-MM-DD HH:mm:ss"
}
```

|#|변수 설명|변수 이름|	타입|	Nullable|description|
|-|-|-|-|-|-|
|1|게시글 고유 번호|scheduleId|int|o|YYYY-MM-DD|
|2|할일 내용|content|String|o|YYYY-MM-DD|
|3|작성자명|userName|String|o|20글자 제한|
|4|작성일|postedDate|String|o|YYYY-MM-DD HH:mm:ss|
|5|수정일|editedDate|String|o|YYYY-MM-DD HH:mm:ss|

### 일정 수정
* PUT/api/schedules/{scheduleId}
* 요청
   * Header:
     * Content-Type: application/json
   * path Variable: scheduleid
   * Body:
 ```
{
    "content": "수정된 내용",
    "title" : "수정된 제목",
    "userName": "수정된 작성자명"
}

```

* 응답
  * Status Code: 200 OK
  * Body:
```
{
    "scheduleId": "게시글 고유 번호",
    "content": "할일 내용",
    "userName": "작성자명",
    "postedDate": "YYYY-MM-DD HH:mm:ss",
    "editedDate": "YYYY-MM-DD HH:mm:ss"
}
```

|#|변수 설명|변수 이름|	타입|	Nullable|description|
|-|-|-|-|-|-|
|1|게시글 고유 번호|scheduleId|int|o|YYYY-MM-DD|
|2|할일 내용|content|String|o|YYYY-MM-DD|
|3|작성자명|userName|String|o|20글자 제한|
|4|작성일|postedDate|String|o|YYYY-MM-DD HH:mm:ss|
|5|수정일|editedDate|String|o|YYYY-MM-DD HH:mm:ss|

### 일정 삭제
* DELETE /api/schedules/{scheduleId}
* 요청
   *Header:
     * Authorization: 비밀번호 (비밀번호를 요청 헤더로 전달)
     * Path Variable: scheduleId
 
|#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|게시글 고유 번호|scheduleId|int|x|AUTO_INCREMENT|

* 응답
   * Status Code: 200 OK
   * Body:
 ```
{
    "responseMessage": "일정이 삭제되었습니다."
}

```
## 2. ERD
![image](https://github.com/user-attachments/assets/5ff30f78-9b26-4500-93f4-17d2580ebd2b)
## 3. Query 목록
* 테이블 생성
```
CREATE TABLE `Schedules` (
                             schedule_id	int	AUTO_INCREMENT PRIMARY KEY,
                             posted_date	datetime	NOT NULL	DEFAULT '2024-01-01-00-00-00',
                             title	varchar(20)	NULL	DEFAULT NULL,
                             content	varchar(100)	NULL	DEFAULT NULL,
                             password	varchar(20)	NOT NULL	DEFAULT '0000',
                             user_name	varchar(20)	NULL	DEFAULT NULL
);
```
* 일정 생성

```
INSERT INTO schedulardb.schedules (posted_date, title , content, password, user_name ) VALUES ('2024-01-01-00-00-00','work','meeting','asdf1234','홍길동');
```
* 일정 수정
```
update schedulardb.schedules set posted_date ='2024-01-03', title = 'travel', content = 'go to restaurant'  where schedule_id = 1;
```
* 일정 삭제
```
DELETE FROM schedulardb.schedules WHERE schedule_id = 1;
```
* 특정 일정 조회
```
select title, content from schedulardb.schedules where schedule_id = 1;
```
* 특정 기간 일정 조회
```
select schedule_id from schedulardb.schedules where posted_date BETWEEN '2024-01-01 00:00:00' AND '2024-11-30 23:59:59' limit 10;

```
