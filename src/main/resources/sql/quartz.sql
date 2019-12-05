-- declare
--     i integer;
--     begin
--     select count(*) into i from user_Tables where TABLE_NAME = 'quartz_job';
--     if i > 0 then
--         execute immediate 'DROP TABLE QUARTZ_JOB';
--     end if;
--     execute immediate 'CREATE TABLE QUARTZ_JOB (
--     job_id  number(2)   not null,
--     job_name    varchar(64) not null
--                        );

-- ';
--
-- end;
--
--
-- insert into QUARTZ_JOB(job_id, job_name) values (QUARTZ_JOB_ID_SEQ.nextval,'abc');
--
-- select * from quartz_job;

-- CREATE TABLE quartz_job (
--     job_id  number  not null,
--     job_name varchar(64)    default '',
--     job_group   varchar(64) default 'DEFAULT',
--     primary key (job_name, job_group)
-- );
--
-- DROP TABLE quartz_job;
-- DROP sequence QUARTZ_JOB_ID_SEQ;
--
-- create sequence QUARTZ_JOB_ID_SEQ
-- minvalue 1
-- maxvalue 999999999999999999999999
-- start with 1
-- increment by 1
-- cache 20;
--
-- CREATE OR REPLACE TRIGGER quartz_job_tir
--     BEFORE INSERT ON QUARTZ_JOB
--     FOR EACH ROW
--     BEGIN
--         SELECT QUARTZ_JOB_ID_SEQ.nextval INTO new.job_id FROM DUAL;
--     end;
--
-- DROP TRIGGER quartz_job_tir;
--
-- INSERT INTO QUARTZ_JOB (job_name, job_group) VALUES ('job', 'jobs');
-- commit;
-- SELECT * FROM QUARTZ_JOB;



drop table quartz_job;

create table quartz_job(
   job_id integer not null ,
   job_name varchar2(64),
   job_group varchar2(64) default 'DEFAULT',
   invoke_target varchar(500) not null ,
   cron_expression varchar(255) not null ,
   misfire_policy varchar(20) not null ,
   concurrent char(1) not null ,
   status char(1) not null ,
   remake varchar(500) default null,
   primary key (job_name, job_group)
   );

create sequence quartz_job_id_seq minvalue 1 maxvalue 99999999
       increment by 1
       start with 1;   /*步长为1*/


insert into quartz_job values (quartz_job_id_seq.nextval, 'job1', 'jobs', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1','插入的第一个任务');
commit;
select * from quartz_job;

select count(*) from QUARTZ_JOB;

select * from QUARTZ_JOB where job_name like '%' || 'j'|| '%';