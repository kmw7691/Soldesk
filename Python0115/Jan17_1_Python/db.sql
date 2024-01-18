create table jan17_coffee(
	c_no number(3) primary key,
	c_name varchar2(10 char) not null,
	c_price number(6) not null,
	c_bean varchar2(10char) not null
);

create sequence jan17_coffee_seq;

select * from jan17_coffee;

select avg(c_price) from jan17_coffee order by c_price asc where rownum between 2 and 8

select avg(c_price) 
	from (
		select rownum as rn, c_price 
			from (
				select c_price
				from jan17_coffee 
					order by c_price
			)
	)
where rn between 2 and 8
