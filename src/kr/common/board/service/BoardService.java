package kr.common.board.service;

import java.sql.Connection;
import java.util.List;

import kr.common.board.dao.BoardDao;
import kr.common.board.vo.BoardVo;
import kr.common.member.model.dao.MemberDao;

import static kr.common.jdbc.JDBCTemplate.*;

public class BoardService {
	public List<BoardVo> getBoardList(int srnum, int ernum) {
		List<BoardVo> result = null;
		Connection con = getConnection();
		result = new BoardDao().getBoardList(con, srnum, ernum);
		close(con);
		return result;
	}
	
	public List<BoardVo> getBoardList() {
		List<BoardVo> result = null;
		Connection con = getConnection();
		result = new BoardDao().getBoardList(con);
		close(con);
		return result;
	}

	public int getCountBoard() {
		int result = 0;
		Connection con = getConnection();
		result = new BoardDao().getCountBoard(con);
		close(con);
		return result;
	}
	
	public int insertBoard(BoardVo vo) {
		int result = 0;
		Connection con = getConnection();
		
		result = new BoardDao().insertBoard(vo, con);
		
		close(con);
		
		return result;
	}
	
	public int updateReadCount(int boardId, Connection con) {
		int result = 0;
		
		result = new BoardDao().updateReadCount(boardId, con);
		
		return result;
	}
	
	public BoardVo getBoardContent(int boardId) {
		System.out.println(boardId);
		BoardVo result = new BoardVo();
		Connection con = getConnection();
		
		this.updateReadCount(boardId, con);
		con = getConnection();
		
		result = new BoardDao().getBoardContent(boardId, con);
		
		
		return result;
	}

	public BoardVo getUpdateBoardContent(int boardid) {
		BoardVo result = new BoardVo();
		Connection con = getConnection();
		result = new BoardDao().getBoardContent(boardid, con);
		
		return result;
	}
	
	public int updateBoardContent(BoardVo vo) {
		int result = 0;
		Connection con = getConnection();
		
		result = new BoardDao().updateBoardContent(vo, con);
		
		return result;
	}

	public int deleteContent(int boardid) {
		int result = 0;
		Connection con = getConnection();
		
		result = new BoardDao().deleteContent(boardid, con);
		
		return result;
	}
}
