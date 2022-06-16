-- 테이블 버리기 
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

-- 전체 행 수 구하기 
select count(*) from group_purchase;

-- 컬럼 버리기 
ALTER TABLE group_purchase DROP COLUMN group_page;

-- 시퀀스 만들기 
create sequence group_purchase_seq start with 1 increment by 1;

-- 다 보기 
select * from group_purchase;

-- 데이터 넣기 
insert into group_purchase values(group_purchase_seq.nextval, 1,'id', 'title', 'txt', sysdate, 'area', 20, 10);

-- 데이터 수정하기 
update group_purchase
set group_txt = ''
where group_no = 20;

-- 데이터 지우기 
delete group_purchase
where group_no = 2;

--일반 조건달린 select문
select * from group_purchase where group_no=3;

-- 테이블 전체 rwonum 보기 
select rownum,group_purchase.* from group_purchase;

-- 전체테이블에서 rownum을 이용한 조건절 사용 -
select * from (select rownum as num, a.* from (select * from group_purchase order by group_date desc)a) where num between 6 and 10;

-- 해당 지역 테이블에서 rownum을 이용한 조건절 사용
select * from (select rownum as num, a.* from (select * from group_purchase where group_purchase.group_area='서울' order by group_date desc)a) where num between 1 and 5;

-- 문자열 포함 테이블에서 rownum 이용한 조건문 사용
select * from (select rownum as num, a.* from (select * from group_purchase where group_title like '%ㅇㅇ%' order by group_date desc)a) where num between 1 and 5;

-- 문자열 포함 & 해당 지역 테이블에서 rownum 이용
select * from (select rownum as num, a.* from (select * from (select * from group_purchase where group_purchase.group_area='서울') where group_title like '%ㅇ%' order by group_date desc)a) where num between 1 and 5;

select count(*) from group_purchase where group_area='서울';

select count(*) from(select * from group_purchase where group_area='서울') where group_title like '%음%';