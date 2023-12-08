-- web 계정 생성 (관리자)

alter session set "_oracle_script" = true;

create user web
identified by web
default tablespace users;

grant connect, resource to web;

alter user web quota unlimited on users;

-- web계정 시작


