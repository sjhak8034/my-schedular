use schedulardb;

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
    constraint schedules_ibfk_1
        foreign key (user_id) references user (user_id)
);

create index user_id
    on schedules (user_id);

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



