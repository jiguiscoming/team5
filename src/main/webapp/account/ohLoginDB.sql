
create table oh_account(
account_name varchar2(20 char) not null,
account_nick varchar2(20 char) not null,
account_id varchar2(30 char) primary key,
account_pw varchar2(30 char) not null,
account_gender varchar2 (1 char) not null,
account_birth varchar2 (22 char) not null,
account_addr varchar2(100 char),
account_age varchar2 (22 char) not null,
account_phone varchar2 (22 char) not null,
account_pwquestion varchar2 (100char) not null,
account_pwquestiona varchar2 (100char) not null,
account_email varchar2 (100char) not null,
account_img varchar2(500char) not null,
account_agree1 varchar(1) not null,
account_agree2 varchar(1) not null,
account_agree3 varchar(1) not null,
account_agree4 varchar(1) not null,
account_date varchar2 (22 char)
);

insert into oh_account values('이름', 'nick', 'n','1004', '여', '20001212', '', '20', '01000000000', '기억에 남는 추억의 장소는?','답!', 'ddd@naver.com', 'images.jpg','O','O','O','O',sysdate);



DELETE oh_account WHERE account_id = 'jyj';


drop table oh_account;

SELECT
    * FROM oh_account;
