create table dec04_error(
	e_what varchar2(30 char) primary key,
	e_where varchar2(30 char) not null
);

select*from dec04_error;

insert into dec04_error values('@빼먹음', 'DAO, Controller');
insert into dec04_error values('mapper.xml입력안함', 'servlet-context.xml');
insert into dec04_error values('세미콜론(;)넣음', 'mapper.xml');
insert into dec04_error values('파일 위치 틀림', '프로젝트 전체');

--index.jsp에 db테이블속 데이터를 하나하나 다 나오게