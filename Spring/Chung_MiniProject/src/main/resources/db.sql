create table chung_memeber(
	c_id varchar2(10 char) primary key,
	c_pw varchar2(10 char) not null,
	c_name varchar2(10 char) not null,
	c_addr varchar2(200 char) not null,
	c_photo varchar2(200 char) not null,
	c_role char(1 char) not null
);

select * from CHUNG_MEMEBER

insert into CHUNG_MEMEBER values('asdf', '1', 'hong', 'asdfasdf', 'wegds', '관');

----------------------------------------------------
create table chung_sns(
	c_no number(4) primary key, 			
	c_owner varchar2(10 char) not null, 	
	c_txt varchar2(300 char) not null,
	c_when date not null,
	c_color char(7) not null
);
create sequence chung_sns_seq;
-----
create table chung_sns_reply(
	cr_no number(5) primary key, -- 댓글번호
	cr_c_no number(4) not null, -- 소속된 글 번호
	cr_owner varchar2(10 char) not null,
	cr_txt varchar2(200 char) not null,
	cr_when date not null,
	constraint sns_reply1
		foreign key(cr_c_no) references chung_sns(c_no)
		on delete cascade
);
create sequence chung_sns_reply_seq;