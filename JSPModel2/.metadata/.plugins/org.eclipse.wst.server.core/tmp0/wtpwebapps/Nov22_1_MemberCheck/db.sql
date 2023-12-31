-- sql 파일 >> 연습장

-- Javabean 멤버변수명 = DB 필드명 = JSP 요청 파라미터명(<input name="요청파라미터명">)
-- 테이블명 : nov22_member / PK는 알아서

create table nov22_member(
	m_id varchar2(10 char) primary key,
	m_pw varchar2(10 char) not null,
	m_name varchar2(10 char) not null,
	m_phone varchar2(13 char) not null,
	m_birthday date not null,
	m_photo varchar2(200 char) not null
);

drop table nov22_member cascade constraint purge;

insert into nov22_member values('asdf', '1', 'hong', '010.1111.1111',
	to_date('20231122', 'YYYYMMDD'), '1.png');
	
insert into nov22_member values(?, ?, ?, ?, to_date(?, 'YYYYMMDD'), ?)

select * from nov22_member;
	
truncate table nov22_member;

-- id가 aaaa인 것의 모든 정보 조회
select * from nov22_member where m_id = 'aaaa';
select * from nov22_member where m_id = ?

-- id가 aaaa인 것의 정보 삭제
delete from nov22_member where m_id = ?
---------------------------------------------------------
-- 게시판 테이블 : nov27_board
-- 속성(필드명) : 글쓴이(b_writer), 글쓴 시간(업로드시간, b_when), 글 내용(b_text)
-- 회원이 탈퇴하면 그 탈퇴한 회원이 쓴 글도 지워지게 + PK알아서

create table nov27_board(
	b_no number(3) primary key,
	b_writer varchar2(10 char) not null,
	b_when date not null,
	b_text varchar2(200 char) not null,
	constraint fk_board foreign key(b_writer)
		references nov22_member(m_id)
		on delete cascade
);

create sequence nov27_board_seq;

-- 테이블삭제
drop table nov27_board cascade constraint purge;
-- 시퀀스삭제
drop sequence nov27_board_seq;
-- 외래키삭제(외래키가 있는 테이블 삭제할 때 함께 삭제해야 외래키 중복에 걸리지 않음)
alter table nov27_board drop constraint fk_board;

insert into NOV27_BOARD values(nov27_board_seq.nextval, 'aa', sysdate, '하하하하');
insert into NOV27_BOARD values(nov27_board_seq.nextval, 'aa', sysdate, '게시판하는중');
insert into NOV27_BOARD values(nov27_board_seq.nextval, 'aa', sysdate, 'ㅋㅋㅋㅋㅋㅋ');
insert into NOV27_BOARD values(nov27_board_seq.nextval, 'aa', sysdate, '게시판!!!');

select * from nov27_board;

--DB에 저장된 전체 글 개수 조회
select count(*) from nov27_board;
--글쓴이와 id가 일치하면서 동시에 텍스트에 [게시판]이라는 글자가 들어있는 게시글의 갯수를 조회
select count(*) from nov27_board, NOV22_MEMBER
	where b_writer = m_id and b_text like '%게시판%';


--전체 게시글이 보이게(검색어가 있다면 검색어기준 시간 역순. 없으면 등록시간 역순)
select*from NOV27_BOARD, NOV22_MEMBER
		where m_id = b_writer and b_text like '%게시판%'
		order by b_when desc;
		
select * from(
	select rownum as rn, b_no, b_writer, b_when, b_text, m_photo
		from (
			select*from NOV27_BOARD, NOV22_MEMBER
			where m_id = b_writer and b_text like '%게시판%'
			order by b_when desc
		)
	)
	where rn >= 1 and rn <= 2

delete from NOV27_BOARD where b_no = 11;

update NOV27_BOARD set b_writer = ?, b_when = ?,
	b_text = ? where b_no = ?









