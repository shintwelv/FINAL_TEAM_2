게시판과 댓글을 각각 하나의 테이블로 만들었음

front_test는 App.js에서 axios를 활용하여 select 테스트 용도
(이후 insert 등은 프론트 작업물과 연동 예정)

**article_code 데이터**
insert into articlecode ('free');
insert into articlecode ('notice');
insert into articlecode ('festival');
insert into articlecode ('review');
insert into articlecode ('transfer');


**이하 테스트 데이터**



insert into users (USER_ID, USER_PW, USER_NAME, NICKNAME) values ('myId', 'myPw', '허신일', 'shinil');


commit;