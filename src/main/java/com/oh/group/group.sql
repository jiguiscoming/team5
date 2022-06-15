drop table group_purchase cascade constraint purge;

create table group_purchase (
	
	group_no number(3) primary key,
	group_id varchar2(20 char) not null,
	group_title varchar2(30 char) not null,
	group_txt varchar2(1000 char) not null,
	group_date date not null,
	group_area varchar2(10 char) not null,
	group_like number(3) not null,
	group_hits number(3) not null

);

create sequence group_purchase_seq start with 1 increment by 1;

select * from group_purchase;

select rownum,group_purchase.* from group_purchase;

select rownum, group_purchase.* from group_purchase order by group_date desc;

insert into group_purchase values(group_purchase_seq.nextval, 'id', 'title', 'txt', sysdate, 'area', 20, 10);

update group_purchase
set group_txt = ''
where group_no = 20;

delete group_purchase
where group_no = 2;

select * from group_purchase where group_no=3;

select * from group_purchase order by group_date desc;

select * from group_purchase where group_title like '%°æ±â%' order by group_date desc;