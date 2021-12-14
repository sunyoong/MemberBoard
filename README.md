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
```
