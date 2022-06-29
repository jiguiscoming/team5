-- 테이블 버리기
drop table group_purchase cascade constraint purge;

-- 닉네임, 이미지 컬럼 추가
alter table group_purchase add group_nickname varchar2(20 char) default 'nickname' not null;
alter table group_purchase add group_img varchar2(30 char) default 'img' not null;

-- 이미지 파일 이름명 제한 변경
alter table group_purchase modify group_img varchar2(100 char);

create table group_purchase (
	
	group_no number(3) primary key,
	group_id varchar2(20 char) not null,
	group_title varchar2(30 char) not null,
	group_txt varchar2(1000 char) not null,
	group_date date not null,
	group_area varchar2(10 char) not null,
	group_like number(3) not null,
	group_hits number(3) not null,
	group_nickname varchar2(20 char) not null,
	group_img varchar2(100 char) not null
	
);

-- 전체 게시글 수 확인
select count(*) from group_purchase;

-- 컬럼 버리기
ALTER TABLE group_purchase DROP COLUMN group_page;

-- 시퀀스 생성
create sequence group_purchase_seq start with 1 increment by 1;

-- 다 보기
select * from group_purchase;

-- 값 넣기
insert into group_purchase values(group_purchase_seq.nextval, 1,'id', 'title', 'txt', sysdate, 'area', 20, 10);

-- 값 변경하기
update group_purchase
set group_txt = ''
where group_no = 20;

-- 해당 넘버 게시글 버리기 
delete group_purchase
where group_no = 2;

-- 해당 넘버 게시글 보기
select * from group_purchase where group_no=3;

-- rownum으로 게시글 번호 붙이기
select rownum,group_purchase.* from group_purchase;

-- 최신순으로 정렬뒤 rownum 활용해서 제한된 게시글 뽑기
select * from (select rownum as num, a.* from (select * from group_purchase order by group_date desc)a) where num between 6 and 10;

-- 서울을 클릭한 게시글 최신순으로 하고 rownum으로 제한된 게시글 뽑기
select * from (select rownum as num, a.* from (select * from group_purchase where group_purchase.group_area='서울' order by group_date desc)a) where num between 1 and 5;

-- 응포함된 게시글 최신순으로 뽑고 rownum으로 제한된 게시글 뽑기
select * from (select rownum as num, a.* from (select * from group_purchase where group_title like '%응%' order by group_date desc)a) where num between 1 and 5;

-- 지역/검색 기능 활용해서 rownum으로 제한된 게시글 뽑기
select * from (select rownum as num, a.* from (select * from (select * from group_purchase where group_purchase.group_area='서울') where group_title like '%��%' order by group_date desc)a) where num between 1 and 5;

select count(*) from group_purchase where group_area='서울';

select count(*) from(select * from group_purchase where group_area='서울') where group_title like '%응%';

-- 랜덤
select * from (select * from group_purchase order by DBMS_RANDOM.RANDOM) where rownum < 6