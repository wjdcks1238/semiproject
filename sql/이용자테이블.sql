drop table tb_user;

create table tb_user(
      id varchar2(25) PRIMARY key
    , passwd varchar2(30) not null
    , name varchar2(20) not null
    , email varchar2(50) not null
);

desc tb_user;

select * from tb_user;

--id중복 확인
select count(*) from tb_user where id='user1';
--로그인
select count(*) from tb_user where id='user1' and passwd='user2';
--회원가입
insert into tb_user values('user1', 'user1', '사용자1', 'user1@example.com');
--회원삭제
delete TB_USER where ID='user2';
commit;