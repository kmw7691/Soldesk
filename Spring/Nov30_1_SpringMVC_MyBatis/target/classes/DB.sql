create table nov29_student(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_nickname varchar2(10 char) not null
);

create sequence nov29_student_seq;
drop sequence nov29_student_seq;

insert into nov29_student values(nov29_student_seq.nextval, '홍길동', '홍홍');

select*from NOV29_STUDENT order by s_no;




------------------------------------------
--테이블명 : nov30_test
--칼럼 : t_title(과목명), t_when(시험날짜)
--값넣고 확인
--자바빈등 생성
--그외에필요한거 다 만들기
--패키지명 : com.kwak.nov301.test
create table nov30_test(
	t_title varchar2(10 char) primary key,
	t_when date not null
);

insert into nov30_test values('자바프로그래밍', to_date('2023-11-30', 'YYYY-MM-DD'));

select*from nov30_test;


