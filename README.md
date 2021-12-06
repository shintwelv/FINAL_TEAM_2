■ 게시판과 댓글을 각각 하나의 테이블로 만들었음

■ article_code 데이터 삽입
insert into article_code values ('free');
insert into article_code values ('notice');
insert into article_code values ('festival');
insert into article_code values ('review');
insert into article_code values ('transfer');
commit;

■ 초기 관리자 계정 생성
INSERT INTO USERS (USER_ID, ADMIN, USER_PW, USER_NAME, NICKNAME) VALUES ('admin', 'Y', 'admin', '관리자', 'ADMIN');

■ 프로필 사진 업로드를 위해 cos-20.08 사용 (http://servlets.com/cos/)

이 링크에서 바로 다운로드 가능
http://servlets.com/cos/cos-20.08.zip

com.oreilly import 오류시 
cos-20.08.zip/lib/cos.jar을
Spring의 WEB-INF/lib에 추가 바람

■ 사진 저장 위치
C:\Final_team2\React_Front\src\img

■ DB에 저장되는 파일 위치 (React에서 src로 불러오기 위함)
../img/

■ Spring 설정
실행시 tomcat server -> modules 에서 path를 /로 설정

■ RPA로 축제데이터 DB에 삽입