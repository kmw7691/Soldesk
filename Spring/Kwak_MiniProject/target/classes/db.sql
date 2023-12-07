--db

create table member(
	id varchar2(10 char) primary key,
	pw varchar2(10 char) not null,
	name varchar2(10 char) not null,
	addr varchar2(200 char) not null,
	photo varchar2(200 char) not null
);

drop table member;

select*from member;

insert into member values('asd', '12', 'name', 'aaaassss', 'a.png')


------------------------------


create table sns(
	s_no number(4) primary key,
	s_writer varchar2(10 char) not null,
	s_text varchar2(300 char) not null,
	s_when date not null
);
create sequence sns_seq;
--
create table sns_reply(
	sr_no number(5) primary key,
	sr_s_no number(4) not null,
	sr_writer varchar2(10 char) not null,
	sr_text varchar2(300 char) not null,
	sr_when date not null,
	constraint reply
		foreign key(sr_s_no) references sns(s_no)
		on delete cascade
);
create sequence sns_reply_seq;