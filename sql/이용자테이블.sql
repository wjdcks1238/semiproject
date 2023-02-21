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

--게시판용 테이블 작성
drop table tb_board;
create table tb_board(
        board_id number primary key
      , title varchar2(100) not null
      , board_user varchar2(20)
      , submit_date date default sysdate
      , board_content varchar2(4000) not null
      , read_count number default 0
      , CONSTRAINT fk_board_user FOREIGN KEY (board_user) REFERENCES tb_user(id)
);
commit;

desc tb_board;

select * from tb_board;

select NVL(max(BOARD_ID), 0)+1 from board;

--게시글 작성
insert into tb_board values((select NVL(max(BOARD_ID), 0)+1 from tb_board)
    , '&title', '&board_user', default, '&content', default);
    
insert into tb_board values((select NVL(max(BOARD_ID), 0)+1 from tb_board)
    , '제목', 'user4', default, '내용', default);

--게시판 전체 불러오기
select board_id, title, board_user, submit_date, read_count
from tb_board;

--범위 지정
select rownum xn, board_id, title, board_user, submit_date, read_count
        from tb_board order by board_id desc;

select * from (select rownum rn, tbl_1.*
    from(select rownum xn, board_id, title, board_user, submit_date, read_count
        from tb_board order by board_id desc) tbl_1)tbl_2
    where rn between 3 and 7;


--게시판 전체 개수 확인
select count(*) from tb_board;

--이용자 정보 불러오기
select id, passwd, name, email from TB_USER;

--내정보 수정하기
update TB_USER set name='사용자44', passwd='user44', email='user44@example.com' where id='user4';
select * from tb_user;
rollback;

--게시글 번호에 맞는 게시글 불러오기
select title, board_user, submit_date, board_content, read_count from tb_board where board_id=10;

--게시글 클릭시, 게시글 본문 들어감과 동시에 조회수 +1
update tb_board set read_count = read_count + 1 where board_id=10;