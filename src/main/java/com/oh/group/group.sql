-- ���̺� ������ 
drop table group_purchase cascade constraint purge;

-- �÷� �߰�(�г���, �������)
alter table group_purchase add group_nickname varchar2(20 char) default 'nickname' not null;
alter table group_purchase add group_img varchar2(30 char) default 'img' not null;

-- �÷� �Ӽ� ����
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

-- ��ü �� �� ���ϱ� 
select count(*) from group_purchase;

-- �÷� ������ 
ALTER TABLE group_purchase DROP COLUMN group_page;

-- ������ ����� 
create sequence group_purchase_seq start with 1 increment by 1;

-- �� ���� 
select * from group_purchase;

-- ������ �ֱ� 
insert into group_purchase values(group_purchase_seq.nextval, 1,'id', 'title', 'txt', sysdate, 'area', 20, 10);

-- ������ �����ϱ� 
update group_purchase
set group_txt = ''
where group_no = 20;

-- ������ ����� 
delete group_purchase
where group_no = 2;

--�Ϲ� ���Ǵ޸� select��
select * from group_purchase where group_no=3;

-- ���̺� ��ü rwonum ���� 
select rownum,group_purchase.* from group_purchase;

-- ��ü���̺��� rownum�� �̿��� ������ ��� -
select * from (select rownum as num, a.* from (select * from group_purchase order by group_date desc)a) where num between 6 and 10;

-- �ش� ���� ���̺��� rownum�� �̿��� ������ ���
select * from (select rownum as num, a.* from (select * from group_purchase where group_purchase.group_area='����' order by group_date desc)a) where num between 1 and 5;

-- ���ڿ� ���� ���̺��� rownum �̿��� ���ǹ� ���
select * from (select rownum as num, a.* from (select * from group_purchase where group_title like '%����%' order by group_date desc)a) where num between 1 and 5;

-- ���ڿ� ���� & �ش� ���� ���̺��� rownum �̿�
select * from (select rownum as num, a.* from (select * from (select * from group_purchase where group_purchase.group_area='����') where group_title like '%��%' order by group_date desc)a) where num between 1 and 5;

select count(*) from group_purchase where group_area='����';

select count(*) from(select * from group_purchase where group_area='����') where group_title like '%��%';