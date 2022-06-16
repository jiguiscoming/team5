create table RecipeBasicCourse(
RECIPE_ID varchar2(1000 char) not null,
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
create sequence RecipeBasicCourse_seq;

insert into RecipeBasicCourse values(recipe_seq.nextval, '레시피이름', '요약소개', '유형코드', '유형분류'
, '음식분류코드', '음식분류', '조리시간', '칼로리', '분량', '난이도', '재료별 분류명', '가격별 분류', '이미지', 'DET');

select * from RecipeBasicCourse;

drop table RecipeBasicCourse




CREATE TABLE RecipeIngredients(
RECIPE_ID varchar2(1000 char) not null,
RECIPE_IRDNT_SN varchar2(1000 char) not null,
RECIPE_IRDNT_NM varchar2(1000 char) not null,
RECIPE_IRDNT_CPCTY varchar2(1000 char) not null,
RECIPE_IRDNT_TY_CODE varchar2(1000 char) not null,
RECIPE_IRDNT_TY_NM varchar2(1000 char) not null
);

create sequence RecipeIngredients_seq;

select * from RecipeIngredients;

drop table RecipeIngredients





CREATE TABLE Recipeprocessinformation(
RECIPE_ID varchar2(1000 char) not null,
COOKING_NO varchar2(1000 char) not null,
COOKING_DC varchar2(1000 char) not null,
STRE_STEP_IMAGE_URL varchar2(1000 char) not null,
STEP_TIP varchar2(1000 char) not null
);

create sequence Recipeprocessinformation_seq;

select * from Recipeprocessinformation;

drop table Recipeprocessinformation