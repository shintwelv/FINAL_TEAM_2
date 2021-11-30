■ 게시판과 댓글을 각각 하나의 테이블로 만들었음

■ front_test는 App.js에서 axios를 활용하여 select 테스트 용도
(이후 insert 등은 프론트 작업물과 연동 예정)

■ **article_code 데이터**
insert into articlecode ('free');
insert into articlecode ('notice');
insert into articlecode ('festival');
insert into articlecode ('review');
insert into articlecode ('transfer');


■ 프로필 사진 업로드를 위해 cos-20.08 사용 (http://servlets.com/cos/)

이 링크에서 바로 다운로드 가능
http://servlets.com/cos/cos-20.08.zip

com.oreilly import 오류시 
cos-20.08.zip/lib/cos.jar을
WEB-INF/lib에 추가 바람

-----------------------------------------

front_test는 App.js에서 axios를 활용하여 select 테스트 용도 (이후 insert 등은 프론트 작업물과 연동 예정)

Spring은 실행시 tomcat server -> modules 에서 path를 /로 설정하고 연결 테스트

-----------------------------------------
이하 테스트 데이터

insert into festival (FESTIVAL_ID, FESTIVAL_LOCATION, FESTIVAL_NAME, FESTIVAL_CONTENT, FESTIVAL_DURATION, FESTIVAL_FEE, FESTIVAL_OWNER) values (FESTIVAL_SEQ.nextval, '제주', '제주도 불꽃 축제', '불꽃 축제에 초대합니다', '2021.11.25 ~ 2022.01.15', 3000, '제주도청');

insert into users (USER_ID, USER_PW, USER_NAME, NICKNAME) values ('myId', 'myPw', '허신일', 'shinil');

insert into festival_reply (REPLY_ID, FESTIVAL_ID, REPLY_CONTENT, REPLY_WRITER_ID, REPLY_DATE) values (festival_reply_seq.nextval, 2, '너무 멋져요', 'myId', sysdate);

insert into festival (FESTIVAL_ID, FESTIVAL_LOCATION, FESTIVAL_NAME, FESTIVAL_CONTENT, FESTIVAL_DURATION, FESTIVAL_FEE, FESTIVAL_OWNER) values (FESTIVAL_SEQ.nextval, '전라', '전라도 불꽃 축제', '불꽃 축제에 초대합니다', '2021.11.25 ~ 2022.01.15', 3000, '전라도청');

insert into review (REVIEW_ID, REVIEW_TITLE, REVIEW_CONTENT, REVIEW_WRITER_ID, REVIEW_DATE, REVIEW_VIEW_COUNT, REVIEW_STAR, REVIEW_LIKE) values (review_seq.nextval, '강원 불꽃축제 후기입니다', '너무 재밌었어요', 'myId', sysdate, 0, 0, 0); insert into review_reply (REPLY_ID, REVIEW_ID, REPLY_CONTENT, REPLY_WRITER_ID, REPLY_DATE, REPLY_RATING) values (review_reply_seq.nextval, 2, '너무 멋져요', 'myId', sysdate, 5); insert into review_reply (REPLY_ID, REVIEW_ID, REPLY_CONTENT, REPLY_WRITER_ID, REPLY_DATE, REPLY_RATING) values (review_reply_seq.nextval, 2, '진짜 꿀잼', 'myId', sysdate, 5);

insert into notice (NOTICE_ID, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_DATE, NOTICE_WRITER_ID, NOTICE_VIEWCOUNT) values (notice_seq.nextval, '10월의 FAQ입니다', '이번달의 내용은 없습니다', sysdate, 'myId', 0);
insert into notice (NOTICE_ID, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_DATE, NOTICE_WRITER_ID, NOTICE_VIEWCOUNT) values (notice_seq.nextval, '11월의 FAQ입니다', '이번달의 내용은 없습니다', sysdate, 'myId', 0);

commit;