create table nov29_student(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_nickname varchar2(10 char) not null
);

create sequence nov29_student_seq;
drop sequence nov29_student_seq;

insert into nov29_student values(nov29_student_seq.nextval, '홍길동', '홍홍');