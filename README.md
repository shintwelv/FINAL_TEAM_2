■ 게시판과 댓글을 각각 하나의 테이블로 만들었음

■ article_code 데이터 삽입
insert into article_code values ('free');
insert into article_code values ('notice');
insert into article_code values ('festival');
insert into article_code values ('review');
insert into article_code values ('transfer');
commit;

■ 초기 관리자 계정 생성 (이 계정으로 로그인은 할 수 없음, 단지 RPA로 축제 정보를 삽입하기 위한 계정)
INSERT INTO USERS (USER_ID, ADMIN, USER_PW, USER_NAME, NICKNAME, ENABLED) VALUES ('admin', 'Y', 'admin', '관리자', '관리자', 1);

commit;


■ 프로필 사진 업로드를 위해 cos-20.08 사용 (http://servlets.com/cos/)

이 링크에서 바로 다운로드 가능
http://servlets.com/cos/cos-20.08.zip

com.oreilly import 오류시 
cos-20.08.zip/lib/cos.jar을
Spring의 WEB-INF/lib에 추가 바람

■ 사진 저장 위치
C:\Final_team2\React_Front\src\img

■ Spring 설정
실행시 tomcat server -> modules 에서 path를 /로 설정


■ RPA로 축제데이터 DB에 삽입



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
  . Ajax 통신 시 하기 구문 추가 ( /webapp/WEB-INF/views/admin/adminSa/accountEnableSet.jsp 파일 참고 )
            beforeSend : function(xhr)
            {   
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
  . form으로 데이터 넘길 시 하기 구문 추가 ( /webapp/WEB-INF/views/userJoin.jsp 파일 참고 )
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            
  . form으로 데이터 넘길 때 enctype이 multipart/form-data일 경우 (  /webapp/WEB-INF/views/admin/insertBoard.jsp 파일 참고 )
            <form action="insertBoard.do?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
  

@@ 상기 Spring - Soon 내용 중 문의사항 있으면 윤순기에게 문의 부탁드려요.

