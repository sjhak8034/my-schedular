# my-schedular
# 목차
* [일정 관리 API 명세서](#1-일정-관리-API-명세서)
* [ERD](#2-ERD)
* [Query 목록 ](#3-Query-목록)
* [Postman API 명세서](#4-PostMan-API-명세서)
## 1. 일정 관리 API 명세서
### 요약
|기능|	method|	url	|request	|response	|status|
|-------------|----|---------------|-----------|---------|--------------|
|일정 작성|POST|	/schedules/users/|	요청 body	|등록 정보	|200: 정상 등록|
|일정 목록 조회|	GET	|/schedules/users/|	요청 param	|다건 응답 정보	|200: 정상 조회|
|특정 일정 조회|	GET	|/schedules/{scheduleId}|	요청 param|	단건 응답 정보|	200: 정상 조회|
|일정 수정|	PUT|	/schedules/{scheduleId}|	요청 body	|수정 정보	|200: 정상 수정|
|일정 삭제|	DELETE|	/schedules/{scheduleId}|	요청 param	|삭제 정보	|200: 정상 삭제|
### 일정 작성 
* POST /schedules/users/{userId}/{userName}
* 요청 Request
  * Header:
     * Content-Type: application/json
     * pathVariable:  userId
|#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|유저 식별자|userId|long|x|AUTO-INCREMENT|

  * Body:
 
 
 ```
{
    "title": "work",
    "content": "meeting",
    "password": "0000"
    "userName": "김민수"
}
```


|#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|제목|title|String|x|20글자 제한|
|2|할일|content|String|x|200글자 제한|
|3|비밀번호|password|String|x|20글자 제한|
|4|작성자명|userName|String|x|20글자 제한|


* 응답 Response
  * Status Code: 200 Created

  * Body:

```

{
    "scheduleId": 26
}

```


|#|변수 설명|변수 이름|타입|Nullable|description|
|-|-|-|-|-|-|
|1|작성된 게시글 식별자|scheduleId|long| x	|AUTO-INCREMENT|


### 특정기간 일정 목록 조회
* GET /schedules/users/{userId}/?startDate=2024-11-05&endDate=2024-11-11&schedulePage=1&pageSize=5
* 요청 Request
  * Header:
    * Content-Type: application/json
    * request parameters:
       * startDate (optional) : 조회할 작성일 (시작) (YYYY-MM-DD)
       * endDate (optional) : 조회할 작성일 (끝) (YYYY-MM-DD)
       * schedulePage  : 조회할 페이지
       * pageSize : 한 페이지당 게시글 수
    * path variable:
      * userId : 유저 식별번호 
  * 정렬: 작성일 기준 내림차순
 
|#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|시작 일|startDate|String|x|YYYY-MM-DD|
|2|마지막 일|endDate|String|x|YYYY-MM-DD|
|3|유저 식별번호|userId|long|x|AUTO-INCREMENT|
|4||조회할 페이지|long|x|최소 1|
|5|게시글 수|pageSize|long|x|최소 1|


* 응답
  * Status Code: 200 OK
  * Body


```
[
    {
        "scheduleId": "게시글 고유 번호",
        "title": "제목",
        "userName": "작성자명",
        "postedDate": "YYYY-MM-DD HH:mm:ss",
        "editedDate": "YYYY-MM-DD HH:mm:ss"
    },
    ...
]
```
|#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|게시글 고유 번호|scheduleId|int|x|AUTO-INCREMENT|
|2|제목|title|String|x|20글자 제한|
|3|작성자명|userName|String|x|20글자 제한|
|4|postedDate|postedDate|String|x|YYYY-MM-DD HH:mm:ss|
|5|editedDate|editedDate|String|x|YYYY-MM-DD HH:mm:ss|



### 특정 일정 조회
* GET /schedules/{scheduleId}
* 요청 Request
   * Header:
    * Content-Type: application/json
    * Path Variable: scheduleId
 
 
|#|변수 설명|변수 이름|	타입|	Nullable|description|
|-|-|-|-|-|-|
|1|게시글 고유 번호|scheduleId|int|x|AUTO-INCREMENT|
* 응답
   * Status Code: 200 OK
   * Body:
```
{
    "scheduleId": "게시글 고유 번호",
    "title": "제목",
    "content": "할일 내용",
    "userName": "작성자명",
    "postedDate": "YYYY-MM-DD HH:mm:ss",
    "editedDate": "YYYY-MM-DD HH:mm:ss"
}
```

|#|변수 설명|변수 이름|	타입|	Nullable|description|
|-|-|-|-|-|-|
|1|게시글 고유 번호|scheduleId|int|x|AUTO-INCREMENT|
|2|제목|title|String|x|20글자 제한|
|3|할일 내용|content|String|x|100글자 제한|
|4|작성자명|userName|String|x|20글자 제한|
|5|작성일|postedDate|String|x|YYYY-MM-DD HH:mm:ss|
|6|수정일|editedDate|String|x|YYYY-MM-DD HH:mm:ss|

### 일정 수정
* PUT /schedules/{scheduleId}
* 요청
   * Header:
     * Content-Type: application/json
     * path Variable: scheduleid
|#|변수 설명|변수 이름|	타입|	Nullable|description|
|-|-|-|-|-|-|
|1|게시글 고유 번호|scheduleId|int|x|AUTO-INCREMENT|

   * Body:
```
{
    "title": "travel",
    "content": "travel",
    "password": "0000",
    "userName": "김민수"
}
```
 
|#|변수 설명|변수 이름|	타입|	Nullable|description|
|-|-|-|-|-|-|
|1|제목|password|String|x|20글자 제한|
|2|할 일|password|String|x|20글자 제한|
|3|비밀번호|password|String|x|20글자 제한|
|4|작성자명|userName|String|x|20글자 제한|

* 응답
  * Status Code: 200 OK
  * Body:

{
    "scheduleId": 10,
    "result": 1
}
|#|변수 설명|변수 이름|	타입|	Nullable|description|
|-|-|-|-|-|-|
|1|수정된 게시글 식별자|scheduleId|long|x|AUTO-INCREMENT|
|2|결과|result|int|x|1은 성공|


### 일정 삭제
* DELETE /schedules/{scheduleId}
* 요청
   *Header:
     * Content-Type: application/json
     * Path Variable: scheduleId
 |#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|게시글 고유 번호|scheduleId|long|x|AUTO_INCREMENT|
   *Body:
```
{
    "password" : "0000"
}
```
 
|#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|비밀번호|password|String|x|20글자 제한|


* 응답
   * Status Code: 200 OK
   * Body:
{
    "scheduleId": 12,
    "result": 1
}
|#|변수 설명|변수 이름|	타입|	Nullable|description|
|-|-|-|-|-|-|
|1|삭제된 게시글 식별자|scheduleId|long|x|AUTO-INCREMENT|
|2|결과|result|int|x|1은 성공|

### 유저 등록
* Post /schedules/register
* 요청
   * Header:
    * Content-Type: application/json

```
{
    "userName" : "김민수",
    "email" : "qw1235@naver.com"
}
```
 
|#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|유저 이름|userName|String|x|20글자 제한|
|2|이메일|email|String|x|20글자 제한|


* 응답
   * Status Code: 200 OK
   * Body:
{
    "userId": 19
}
|#|변수 설명|변수 이름|	타입|	Nullable|description|
|-|-|-|-|-|-|
|1|생성된 유저 식별자|userId|long|x|AUTO-INCREMENT|


### 유저 수정
* DELETE /schedules/user-profile/{userId}
* 요청
    * Header:
       * Content-Type: application/json
       * Path Variable: userId
 |#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|유저 식별자|userId|long|x|AUTO_INCREMENT|
   *Body:
```
{
    "userName" : "홍길동",
    "email" : "asdf3445@naver.com"
}
```
 
|#|변수 설명|변수 이름|타입|Nullable|description|
|-|--------|---------|---|---|--|
|1|수정한 이름|userName|String|x|20글자 제한|
|1|수정한 이메일|email|String|x|20글자 제한|

* 응답
   * Status Code: 200 OK
   * Body:
{
    "scheduleId": 12,
    "result": 1
}
|#|변수 설명|변수 이름|	타입|	Nullable|description|
|-|-|-|-|-|-|
|1|수정한 유저의 게시글 식별자|userId|long|x|AUTO-INCREMENT|
|2|결과|result|int|x|1은 성공|

## 2. ERD
![image](https://github.com/user-attachments/assets/5739eab7-6dc6-4cab-8cf8-8d210f92440a)
## 3. Query 목록


* 테이블 생성
```
create table schedules
(
    schedule_id bigint auto_increment comment '게시글 식별자'
        primary key,
    post_date   datetime     not null comment '작성 날짜',
    edit_date   datetime     not null comment '수정 날짜',
    title       varchar(20)  not null comment '제목',
    content     varchar(200) not null comment '내용',
    password    varchar(20)  not null comment '비밀번호',
    user_name   varchar(20)  not null comment '작성자 이름',
    user_id     bigint       null,
    foreign key (user_id) references user (user_id)
);
create table user
(
    user_id       bigint auto_increment comment '유저 식별자'
        primary key,
    user_name     varchar(20) not null comment '유저 이름',
    register_date datetime    not null comment '등록일',
    edit_date     datetime    not null comment '유저 수정일',
    email         varchar(20) not null comment '이메일',
    constraint email
        unique (email)
);
```
* 일정 생성

```
INSERT INTO schedulardb.schedules (posted_date,editeted_date, title , content, password, user_name ) VALUES ('2024-01-01-00-00-00','2024-01-01-00-00-00','work','meeting','asdf1234','홍길동');
```
* 일정 수정
```
jdbcTemplate.update("update schedules set user_name= ?, edit_date = ?, title = ?, content = ? where schedule_id = ? and password = ?",
                entity.getUserName(), entity.getEditDate(), entity.getTitle(), entity.getContent(), entity.getScheduleId(),entity.getPassword());
```
* 일정 삭제
```
jdbcTemplate.update("delete from schedules where schedule_id = ? AND password = ?", entity.getScheduleId(), entity.getPassword()));
```
* 특정 일정 조회
```
jdbcTemplate.query("select * from schedules where schedule_id = ?", scheduleRowMapperForView(), entity.getScheduleId());
```
* 특정 기간 일정 조회
```
private RowMapper<ResponseToSearchScheduleListDto> scheduleRowMapperForSearch(){
        return (rs, rowNum) -> new ResponseToSearchScheduleListDto(
                rs.getLong("schedule_id"),
                rs.getString("title"),
                rs.getString("user_name"),
                rs.getString("post_date"),
                rs.getString("edit_date")
        );
    }
jdbcTemplate.query("select * from schedules where user_id = ? and edit_date between ? and ? " +
                "order by schedule_id desc limit ? offset ?",new Object[]{
                entity.getUserId(), entity.getStartDate(), entity.getEndDate(),entity.getPageSize(),
                entity.getOffset()
        }, scheduleRowMapperForSearch());

```
* 유저 등록
```
SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
        simpleJdbcInsert.withTableName("user").usingGeneratedKeyColumns("user_id");
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("user_name", entity.getUserName());
        params.addValue("password", entity.getPassword());
        params.addValue("register_date", entity.getRegisterDate());
        params.addValue("edit_date", entity.getEditDate());
        params.addValue("email", entity.getEmail());

        try {
            Number userId = simpleJdbcInsert.executeAndReturnKey(params);
            return new ResponseToRegisterUserDto( Optional.of(userId).map(Number::longValue));
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return new ResponseToRegisterUserDto(null);
        }
```

* 유저 수정
```
jdbcTemplate.update("update user set user_name= ?, edit_date = ?, email = ? where user_id = ?",
                entity.getUserName(), entity.getEditDate(), entity.getEmail(), entity.getUserId());
```
## 4. Postman API 명세서
https://web.postman.co/workspace/dc9a47b3-2ced-4fb4-818d-ef16a3835a45/documentation/39355348-3b4eb661-11b8-4878-8829-ce1b5fd04a5a
