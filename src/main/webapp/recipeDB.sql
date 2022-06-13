create table recipe(
RECIPE_ID number(10) primary key,
RECIPE_NM_KO varchar2(10 char) not null,
RECIPE_SUMRY varchar2(100 char) not null,
RECIPE_NATION_CODE varchar2(20 char) not null,
RECIPE_NATION_NM varchar2(10 char) not null,
RECIPE_TY_CODE varchar2(20 char) not null,
RECIPE_TY_NM varchar2(10 char) not null,
RECIPE_COOKING_TIME varchar2(10 char) not null,
RECIPE_CALORIE varchar2(10 char) not null,
RECIPE_QNT varchar2(10 char) not null,
RECIPE_LEVEL_NM varchar2(10 char) not null,
RECIPE_IRDNT_CODE varchar2(10 char) not null,
RECIPE_PC_NM varchar2(10 char) not null
);
create sequence recipe_seq;

insert into recipe values(recipe_seq.nextval, '레시피이름 ', '요약소개', '유형코드', '유형분류'
, '음식분류코드', '음식분류', '조리시간', '칼로리', '분량', '난이도', '재료별 분류명', '가격별 분류');


select * from recipe;