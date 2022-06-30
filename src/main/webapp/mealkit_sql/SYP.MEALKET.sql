CREATE table mealkit_QnA_test (
    mealkit_QnA_no number(5) primary key,
    mealkit_QnA_mk_no number(10) not null,
    mealkit_QnA_id varchar2(500 char) not null,
    mealkit_QnA_pw number(10) not null,
    mealkit_QnA_title varchar2(500 char) not null,
    mealkit_QnA_img varchar2(500 char) null,
    mealkit_QnA_txt varchar2(500 char) not null,
    mealkit_QnA_Answer_title varchar2(500 char)  null,
    mealkit_QnA_Answer_txt varchar2(500 char) null,
    mealkit_QnA_Answer_Confirm number(1) DEFAULT 0,
    mealkit_QnA_date DATE
);
create table mealkit_test (

    mealkit_no NUMBER PRIMARY KEY,
    mealkit_name varchar2(300 char) not null,
    mealkit_price NUMBER not null,
    mealkit_type VARCHAR2(10 char) not null,
    mealkit_img varchar2 (500 char) not null,
    mealkit_txt varchar2 (500 char) not null,
    mealkit_date DATE 

);
create table mealkit_review_test (

    mealkit_review_no NUMBER PRIMARY KEY,
    -- mealkit_review_id varchar2(300 char) not null,
    mealkit_review_mk_no NUMBER  not null,
    mealkit_review_title varchar2 (100 char) not null,
     mealkit_review_img varchar2 (500 char) not null,
    mealkit_review_txt varchar2 (500 char) not null,
     mealkit_review_star NUMBER ,
    mealkit_review_date DATE 

);

CREATE table mealkit_Answer_test (
    mealkit_Answer_no number(5) primary key,
    mealkit_Answer_QnA_no number(10) not null,
    mealkit_Answer_title varchar2(500 char) not null,
    mealkit_Answer_text varchar2(500 char) not null,
    mealkit_Answer_date DATE
);