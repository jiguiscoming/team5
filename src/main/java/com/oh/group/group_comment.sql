drop table group_comment cascade constraint purge;

create table group_comment(
	group_comment_no number(3) primary key,
	group_comment_listno number(3) not null,
	group_comment_id varchar2(20 char) not null,
	group_comment_txt varchar2(300 char) not null,
	group_comment_date date not null
);

select * from group_comment;

create sequence group_comment_seq start with 1 increment by 1;
create sequence group_comment_seq;

insert into group_comment values(group_comment_seq.nextval, 2, 'test', 'comment', sysdate);
insert into group_comment values(group_comment_seq.nextval, 2, 'test', 'comment', sysdate);

select * from group_comment order by group_comment_date desc;

select count(*) from group_comment where group_comment_listno = 82;

ALTER SEQUENCE group_comment_seq BY MINVALUE 100;
DROP SEQUENCE group_comment_seq;

CREATE SEQUENCE group_comment_seq MINVALUE 100;