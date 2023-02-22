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

select title, board_user, submit_date , board_content, read_count from tb_board where board_id=11;

--게시물 수정
update tb_board set title='2323', BOARD_CONTENT='232323' where BOARD_ID=11;
rollback;
select * from TB_BOARD;

--게시글 삭제
delete TB_BOARD where board_id=11;

--댓글 테이블 관련
--댓글 테이블
drop table tb_comment;
create table tb_comment(
      board_id number not null
    , comment_id number primary key
    , username varchar2(20) not null
    , comment_content varchar2(1000) not null
    , submit_date date default sysdate
    , CONSTRAINT fk_board_id FOREIGN KEY (board_id) REFERENCES tb_board(board_id)
    , constraint fk_username foreign key (username) references tb_user(id)
);

desc TB_COMMENT;

select * from tb_comment;

select NVL(max(comment_id), 0)+1 from tb_comment;

--특정 게시물에 대한 댓글 호출
select username, comment_content, submit_date
    from TB_COMMENT where board_id=1
    order by COMMENT_ID desc;
    
--특정 게시물에 대한 댓글의 갯수 확인
select count(*) from tb_comment where BOARD_ID=1;

select count(*) from tb_comment where BOARD_ID=1;

-- 댓글 삽입
insert into TB_COMMENT values(4, (select NVL(max(comment_id), 0)+1 from tb_comment)
    , 'user3', '두번째댓글입니다.', default);

--댓글 페이징
select * from (select rownum rn, tbl_1.*
    from(select rownum xn, comment_id, USERNAME, COMMENT_CONTENT, SUBMIT_DATE
        from tb_comment where board_id=1 order by comment_id desc) tbl_1)tbl_2
    where rn between 1 and 5;