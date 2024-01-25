-- table간 제약조건 x

--학생 테이블 : 이름 생일 소속강의장, 중간고사점수 기말고사점수
drop table students;
drop sequence stu_seq;
create table students(
	s_no number(30) primary key,
	name varchar2(10 char) not null,
	birth date not null,
	class varchar2(10 char) not null,
	mid_score number(3) not null,
	end_score number(3) not null
);
create sequence stu_seq;
INSERT INTO students 
VALUES (stu_seq.nextval, '학생이름', '1990-01-01', '소속강의장', 80, 90);


--강의장 테이블: 몇강의장 강의장위치
--		1강의장 : 5층복도 오른쪽 / 2강의장 : 5층 복도 왼쪽 끝
--		3강의장 : 5층복도 왼쪽 첫번째 / 4강의장 : 6층 왼쪽 / 5강의장 : 6층 오른쪽
drop table classes;
drop sequence cla_seq;
create table classes(
	classroom varchar2(10 char) primary key,
	location varchar2(20 char) not null
);

insert into classes values('1강의장', '5층복도 오른쪽');
insert into classes values('2강의장', '5층복도 왼쪽 끝');
insert into classes values('3강의장', '5층복도 왼쪽 첫번째');
insert into classes values('4강의장', '6층 왼쪽');
insert into classes values('5강의장', '6층 오른쪽');

