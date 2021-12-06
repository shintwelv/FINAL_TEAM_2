■ 게시판과 댓글을 각각 하나의 테이블로 만들었음

■ front_test는 App.js에서 axios를 활용하여 select 테스트 용도
(이후 insert 등은 프론트 작업물과 연동 예정)

■ **article_code 데이터**
insert into article_code values ('free');
insert into article_code values ('notice');
insert into article_code values ('festival');
insert into article_code values ('review');
insert into article_code values ('transfer');
commit;



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



@@ Spring - Soon ================================================================================================================================

■ ServerInfo 엑셀파일 출력
 - C:\tmp\Resource 경로에 파일이 생성됩니다. 따로 디렉토리 생성 로직은 만들지 않았으니 해당 경로가 존재하지 않다면 디렉토리를 생성해주세요.
 - C:\tmp\OriginFile.xlsx 파일이 기본 엑셀 파일입니다. BangBangGokGok_Spring 프로젝트 내부에 OriginFile.xlsx 파일을 C:\tmp 경로로 복사 혹은 잘라내기 해주세요.
 
■ 게시판 파일 업로드
 - C:\tmp\upload 경로에 파일이 업로드됩니다. 따로 디렉토리 생성 로직은 만들지 않았으니 해당 경로가 존재하지 않다면 디렉토리를 생성해주세요.
 
■ root-context.xml에서 shemaLocation 관련 문제 ("Referenced file contains errors (project-aware.. ")
 - Problems에서 확인되는 에러로 root-context.xml 파일의 <jpa:repository> 설정에서 발생됩니다. ( jpa관련 라이브러리와 스프링 프레임워크의 버전매칭 문제로 보이나 확실하진 않음 )
 - 프로그램 실행에는 문제가 없으나 root-context.xml 파일의 첫 줄에 x 표시가 뜨고있어 우선 스프링 설정으로 해당 에러를 지울 수 있는 방법만 공유합니다.
 >> Window > Preferences > General > Validation > 최하단의 XML Validation, XSL Validator 항목 체크 해제(Manual, Build)
 
■ 스프링 시큐리티
 - /admin 하위 경로는 manager 테이블의 "ADMIN_LEVEL" 칼럼의 값을 통해 접근 권한을 제어중입니다. (webapp/WEB-INF/security/spring-security.xml 파일의 22번째 줄 이후 설정에서 확인)
 - Spring 쪽 프로젝트 추가 병합 시 스프링 시큐리티의 csrf 토큰 설정으로 인해 form, ajax 등 프론트와 통신에서 에러 발생할 수 있습니다. 
  # Ajax 통신 시 하기 구문 추가 ( /webapp/WEB-INF/views/admin/adminSa/accountEnableSet.jsp 파일 참고 )
            beforeSend : function(xhr)
            {   
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
  # form으로 데이터 넘길 시 하기 구문 추가 ( /webapp/WEB-INF/views/userJoin.jsp 파일 참고 )
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            
  # form으로 데이터 넘길 때 enctype이 multipart/form-data일 경우 (  /webapp/WEB-INF/views/admin/insertBoard.jsp 파일 참고 )
            <form action="insertBoard.do?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
  

@@ 상기 Spring - Soon 내용 중 문의사항 있으면 윤순기에게 문의 부탁드려요.
