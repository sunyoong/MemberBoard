### member_table
```
create table member_table (
	 m_number bigint auto_increment,
     m_id varchar(20) not null,
     m_password varchar(20) not null,
     m_name varchar(20) not null,
     m_email varchar(30),
     m_phone varchar(20),
     constraint primary key(m_number),
     constraint un_member_table unique(m_id)
     );
```


### board_table
```
create table board_table (
	b_number bigint auto_increment,
    m_number bigint,
    b_title varchar(20) not null,
    m_id varchar(20) not null,
    b_contents varchar(1000) not null,
    b_hits int,
    b_date datetime,
    b_filename varchar(30),
    constraint primary key(b_number),
    constraint foreign key(m_number) references member_table(m_number) on delete set null
    
   
    );
    
    alter table board_table modify column b_filename varchar(100);
```

### Comment_table
```
create table comment_table(
	c_number bigint auto_increment,
    b_number bigint,
    c_writer varchar(20),
    c_contents varchar(300),
    c_date datetime,
    constraint primary key(c_number),
    constraint foreign key(b_number) references board_table(b_number) on delete cascade
);
```
 
# 기능
### 회원(member)
1. 회원가입
	- 아이디 중복확인
2. 로그인
	- 아이디, 비밀번호 일치여부 확인
3. 로그아웃
4. 마이페이지 
 - 회원상세정보
 - 내정보 수정
 	- 비밀번호 일치여부 확인 후 정보수정
5. 로그인 하지 않았을 경우 : 회원가입, 로그인 링크만 보여짐
   로그인 했을 경우 : 게시글, 마이페이지, 로그아웃 링크 보여짐
6. (추가할 기능) 회원 탈퇴
	- 비밀번호 확인 후 회원탈퇴 
	- 회원 탈퇴를 해도 작성한 게시글은 남아있도록.
	 

### 게시판(board)
1. 검색기능 : 작성자, 글제목 분류에 따른 검색어를 입력받고 해당하는 게시글 리스트 출력
2. 전체글목록 조회 
	- 페이징으로 페이지도 함께 넘겨옴 
	- 한 화면에 3페이지까지, 게시글은 5개가 보여지도록 설정
3. 상세글 조회
	- 제목을 누르고 들어가면 상세글을 볼 수 있음
	- 댓글(Comment)
		- 로그인 한 아이디가 댓글 작성자로 보여지고
		- 댓글 작성자, 내용, 작성시간을 볼 수 있음
		- 댓글수정 및 삭제는 추후 프로젝트에서
	- 목록을 누르면 해당 게시글이 위치하는 목록으로 돌아감	
4. 게시글 삭제
	- 로그인 한 사람이 자신의 게시글에 한해서만 수정, 삭제 가능
	- 관리자(admin)는 삭제만 가능함.
 	

 
 

-	