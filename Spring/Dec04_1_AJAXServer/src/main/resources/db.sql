--테이블명 : dec04_fruit
--필드명 : f_name(pk) f_price f_location
create table dec04_fruit(
	f_name varchar2(10 char) primary key,
	f_price number(6) not null,
	f_location varchar2(20 char) not null
);

drop table dec04_fruit;

select*from dec04_fruit where f_price <= 5000 
		order by f_price;

insert into dec04_fruit values('포도', 2000, '베트남');
insert into dec04_fruit values('귤', 2000, '제주');
insert into dec04_fruit values('망고', 4000, '인도네시아');
insert into dec04_fruit values('레몬', 3500, '싱가폴');
insert into dec04_fruit values('샤인머스켓', 5500, '네덜란드');

--테이블 완성후 -> Spring버전일때 어떻게 햇엇는지

--자바빈 + fruitMapper.xml
-- + Fruit컨트롤러 + FruitDAO + servletcontext.xml