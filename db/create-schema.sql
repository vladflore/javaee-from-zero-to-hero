CREATE TABLESPACE javaee_ts DATAFILE
    'javaee_ts.dat' SIZE 50 M REUSE
        AUTOEXTEND ON NEXT 10 M;

CREATE TEMPORARY TABLESPACE javaee_ts_temp TEMPFILE
    'javaee_ts_temp.dbf' SIZE 5 M
        AUTOEXTEND ON;

-- run this in case of error: ORA-65096: invalid common user or role name
ALTER SESSION SET "_ORACLE_SCRIPT" = true;

CREATE USER javaeeadmin IDENTIFIED BY welcome1
  DEFAULT TABLESPACE javaee_ts
  TEMPORARY TABLESPACE javaee_ts_temp
  QUOTA 20 M ON javaee_ts;

GRANT create session TO javaeeadmin;
GRANT create table TO javaeeadmin;
GRANT create view TO javaeeadmin;
GRANT create any trigger TO javaeeadmin;
GRANT create any procedure TO javaeeadmin;
GRANT create sequence TO javaeeadmin;
GRANT create synonym TO javaeeadmin;
