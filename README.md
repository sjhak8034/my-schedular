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
|특정기간 일정 목록 조회|	GET	|/api/schedules?startDate="시작날짜"&endDate="마지막 날짜"|	요청 param	|다건 응답 정보	|200: 정상 조회|
|특정 일정 조회|	GET	|/api/schedules/{schedule_id}|	요청 param|	단건 응답 정보|	200: 정상 조회|
|일정 수정|	PUT|	/api/schedules/{schedule_id}|	요청 body	|수정 정보	|200: 정상 수정|
|일정 삭제|	DELETE|	/api/schedules/{schedule_id}|	요청 param	|삭제 정보	|204: 정상 삭제|
###  일정 생성 
* PUT/api/schedules
* 요청 Request
  * Body:
|#|변수 설명|변수 이름|타입|Nullable|
|-|--------|---------|---|---|
|1|제목||
## 2. ERD
![image](https://github.com/user-attachments/assets/5ff30f78-9b26-4500-93f4-17d2580ebd2b)
## 3. Query 목록
