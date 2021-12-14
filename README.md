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
### 회원
1. 회원가입
	- 아이디 중복확인
2. 로그인
	- 아이디, 비밀번호 일치여부 확인
3. 로그아웃
4. 마이페이지 
 - 회원상세정보
 - 내정보 수정
 	- 비밀번호 일치여부 확인 후 정보수정
 	
 

-	