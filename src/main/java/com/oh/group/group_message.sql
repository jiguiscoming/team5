-- ���̺� ������ 
drop table group_message cascade constraint purge;

create table group_message(
	group_message_no number(3) primary key,
	group_message_writer varchar2(20 char) not null,
	group_message_sender varchar2(20 char) not null,
	group_message_title varchar2(30 char) not null,
	group_message_txt varchar2(1000 char) not null,
	group_message_date date not null
);

create sequence group_message_seq start with 1 increment by 1;

select * from group_message;

-- ������ �ֱ� 
insert into group_message values(group_message_seq.nextval, 'post writer','sender', 'title', 'txt', sysdate);