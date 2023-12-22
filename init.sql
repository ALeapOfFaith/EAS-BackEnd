# create database springhomework;

# 初始化学生数据表
create table STUDENT
	(SNO varchar(10) not null,
	PSD varchar(16) not null,
	SNAME varchar(10) not null,
	primary key(SNO));
insert into STUDENT(SNO,PSD,SNAME,SEX) values
	("S1","123456","宋江",1),
	("S2","123456","鲁智深",1),
	("S3","123456","孙二娘",0);

# 初始化教师数据表
create table PROFESSOR
	(PNO varchar(10) not null,
	PSD varchar(16) not null,
	PNAME varchar(10) not null,
	primary key(PNO));
insert into PROFESSOR(PNO,PSD,PNAME,SEX) values
	("P1","123456","关羽",1),
	("P2","123456","曹操",1),
	("P3","123456","张辽",1)

# 初始化课程数据表
create table COURSE
	(CNO varchar(10) not null,
	CNAME varchar(10) not null,
	PNO varchar(10) not null,
	CREDIT real,
	primary key(CNO),
	constraint course_fk_1 foreign key(PNO) references PROFESSOR(PNO)) ON DELETE CASCADE;
insert into COURSE(CNO,CNAME,PNO,CREDIT) values
	("C1","数据库","P1",4),
	("C2","离散数学","P2",2),
	("C3","组合数学","P2",2),
	("C4","操作系统","P1",4),
	("C5","数据结构","P3",3),
	("C6","近世代数","P2",2),
	("C7","高等数学","P2",4),
	("C8","C语言","P3",2),
	("C9","数理逻辑","P2",4);

# 初始化学生选课数据表
create table SC
	(SNO varchar(10) not null,
	CNO varchar(10) not null,
	SCORE real,
	constraint sc_fk_1 foreign key(SNO) references STUDENT(SNO) ON DELETE CASCADE,
	constraint sc_fk_2 foreign key(CNO) references COURSE(CNO) ON DELETE CASCADE,
	constraint ck_score check(score>=0 and score<=100));
insert into SC(SNO,CNO,SCORE) values
	("S1","C1",80),
	("S1","C2",60),
	("S1","C3",40),
	("S1","C4",90),
	("S1","C5",70),
	("S1","C6",null),	
	("S1","C7",50),
	("S1","C9",null),
	("S2","C1",80),
	("S2","C2",60),
	("S2","C3",40),
	("S2","C8",90),
	("S3","C5",70),
	("S3","C6",60);
