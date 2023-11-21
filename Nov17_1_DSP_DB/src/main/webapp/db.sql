--사과테이블
--지역 a_location, PK  
--색 a_color 맛 a_flavor 가격a_price 소개a_introduce
--데이터 4~5개 삽입

drop table nov17_apple cascade constraint purge;

create table nov17_apple(
	a_location varchar2(5 char) primary key,
	a_color varchar2(10 char) not null,
	a_flavor varchar2(10 char) not null,
	a_price number(6) not null,
	a_introduce varchar(80 char) not null
);

truncate table nov17_apple;

insert into nov17_apple values('대구', '빨강', '단맛', '5000', '대구사과');
insert into nov17_apple values('충주', '초록', '쓴맛', '4000', '충주사과');
insert into nov17_apple values('청주', '파랑', '신맛', '3000', '청주사과');
insert into nov17_apple values('부산', '검정', '매운맛', '2500', '부산사과');
insert into nov17_apple values('경주', '노랑', '단맛', '3500', '경주사과');

select*from(
select rownum as rn, a_location, a_color, a_flavor, a_price, a_introduce 
	from ( 
		select*
			from nov17_apple order by a_price
		)
)
where rn >= 3 and rn <= 6;



select*from nov17_apple;

--총데이터가 몇개인지 조회
select count(*) from nov17_apple;




update nov17_apple set a_color='빨강', a_flavor ='단맛', a_price = 2000,
						a_introduce='LA사과!!!' where a_location='LA';


--데이터삭제 : pk를 기준
delete from nov17_apple where a_location = 'LA';




--바나나테이블
--과일상표 생산지역 과일개수 맛 색 가격 설명
create table banana(
	maker varchar2(10 char) not null,
	location varchar2(10 char) primary key,
	howmany number(4) not null,
	flavor varchar2(10 char) not null,
	color varchar2(5 char) not null,
	price number(6) not null,
	introduce varchar2(100 char) not null
);

insert into banana values('델몬트', '서울', 100,
						'단맛', '노랑', 1000, '서울바나나~');
insert into banana values('썬키스트', '제주', 200, 
						'쓴맛', '빨강', 1500, '제주바나나~');
insert into banana values('삼성', '대전', 80, 
						'매운맛', '검정', 2200, '대전바나나~');
insert into banana values('LG', '부산', 600, 
						'짠맛', '초록', 4600, '부산바나나~');
insert into banana values('애플', '인천', 1000, 
						'단맛', '검정', 8200, '인천바나나~');

--sql용
drop table banana cascade constraint purge;
truncate table banana;
select*from banana;
select*from banana order by price;
--총데이터가 몇개인지 조회
select count(*) from banana;
--데이터삭제 : pk를 기준
delete from banana where a_location = '인천';

update banana set location='대구', howmany=900, flavor ='단맛',
			color='빨강', price = 2000, introduce='인천바나나!!!'
				where maker='애플';









