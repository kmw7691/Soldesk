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

insert into nov22_member values('1234', '1234', '1234', '1234',
	to_date('2023-11-23', 'YYYYMMDD'), 'aa.png');
	
truncate table nov22_member;

--id가 aaaa인 것의 모든 정보 조회
select*from NOV22_MEMBER where m_id = 'aaaa';
select*from NOV22_MEMBER;

delete from NOV22_MEMBER where m_id = ?;
update NOV22_MEMBER_ set m_pw = ?, m_name = ?, m_phone = ?,
						m_birthday = ?, m_photo = ? where m_id = ?
							
						