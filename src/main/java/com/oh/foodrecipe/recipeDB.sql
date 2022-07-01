create table RecipeBasicCourse(
RECIPE_BASIC_NO NUMBER(30) PRIMARY KEY,
RECIPE_BASIC_ID varchar2(1000 char) not null,
RECIPE_NM_KO varchar2(1000 char) not null,
RECIPE_SUMRY varchar2(1000 char) not null,
RECIPE_NATION_CODE varchar2(1000 char) not null,
RECIPE_NATION_NM varchar2(1000 char) not null,
RECIPE_TY_CODE varchar2(1000 char) not null,
RECIPE_TY_NM varchar2(1000 char) not null,
RECIPE_COOKING_TIME varchar2(1000 char) not null,
RECIPE_CALORIE varchar2(1000 char) not null,
RECIPE_QNT varchar2(1000 char) not null,
RECIPE_LEVEL_NM varchar2(1000 char) not null,
RECIPE_IRDNT_CODE varchar2(1000 char) not null,
RECIPE_PC_NM varchar2(1000 char) not null,
RECIPE_IMG_URL varchar2(1000 char) not null,
RECIPE_DET_URL varchar2(1000 char) not null
);


insert into RecipeBasicCourse values(RecipeBasicCourse_seq.nextval,'레시피코드1', '레시피이름1', '요약소개1', '유형코드1', '유형분류1'
, '음식분류코드1', '음식분류1', '조리시간1', '칼로리1', '분량1', '난이도1', '재료별 분류명1', '가격별 분류1', '이미지1', 'DET1');

select * from RecipeBasicCourse;

create sequence RecipeBasicCourse_seq start with 1 increment by 1;
drop table RecipeBasicCourse;
drop sequence RecipeBasicCourse_seq;
-----------------------------------------

CREATE TABLE RecipeIngredients(
RECIPE_IN_NO NUMBER(30) PRIMARY KEY,
RECIPE_IN_ID varchar2(1000 char) not null,
RECIPE_IRDNT_SN varchar2(1000 char) not null,
RECIPE_IRDNT_NM varchar2(1000 char) not null,
RECIPE_IRDNT_CPCTY varchar2(1000 char) not null,
RECIPE_IRDNT_TY_CODE varchar2(1000 char) not null,
RECIPE_IRDNT_TY_NM varchar2(1000 char) not null
);

create sequence RecipeIngredients_seq;

select * from RecipeIngredients;

create sequence RecipeIngredients_seq start with 1 increment by 1;
drop table RecipeIngredients;
drop sequence RecipeIngredients_seq;

/*
 재료 
 */

select RECIPE_IRDNT_NM, RECIPE_IRDNT_CPCTY
from RecipeBasicCourse, RecipeIngredients
where RECIPE_BASIC_ID = RECIPE_IN_ID
and RECIPE_BASIC_NO=443



-----------------------------------------

CREATE TABLE Recipeprocessinformation(
RECIPE_PRO_NO NUMBER(30) PRIMARY KEY,
RECIPE_PRO_ID varchar2(1000 char) not null,
RECIPE_COOKING_NO varchar2(1000 char) not null,
RECIPE_COOKING_DC varchar2(1000 char) not null,
RECIPE_STRE_STEP_IMAGE_URL varchar2(1000 char) not null,
RECIPE_STEP_TIP varchar2(1000 char) not null
);

create sequence Recipeprocessinformation_seq;

select * from Recipeprocessinformation;

create sequence Recipeprocessinformation_seq start with 1 increment by 1;

drop table Recipeprocessinformation;
drop sequence Recipeprocessinformation_seq;


/*
 *조리설명
 */
select RECIPE_COOKING_DC, RECIPE_STRE_STEP_IMAGE_URL
from RecipeBasicCourse, Recipeprocessinformation
where RECIPE_BASIC_ID = RECIPE_PRO_ID
and RECIPE_BASIC_NO=443;


