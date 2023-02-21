package kr.common.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kr.common.jdbc.JDBCTemplate.*;

import kr.common.board.vo.BoardVo;
import kr.common.member.model.vo.MemberVo;

public class BoardDao {
	public ArrayList<BoardVo> getBoardList(Connection con) {
		ArrayList<BoardVo> result = null;
		String sql = "select rownum xn, board_id, title, board_user, submit_date, read_count "
			   + "from tb_board order by board_id desc";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<BoardVo>();
			
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBoardId(rs.getInt("boardId"));
				vo.setBoardUser(rs.getString("boardUser"));
				vo.setReadCount(rs.getInt("readCount"));
				vo.setSubmitDate(rs.getDate("submitDate"));
				vo.setTitle(rs.getString("title"));
				
				result.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	
	public ArrayList<BoardVo> getBoardList(Connection con, int srnum, int ernum) {
		ArrayList<BoardVo> result = null;
		String sql = "select * from (select rownum rn, tbl_1.* "
			   + "from(select rownum xn, board_id, title, board_user, submit_date, read_count "
			   + "from tb_board order by board_id desc) tbl_1)tbl_2 "
			   + "where rn between ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, srnum);
			pstmt.setInt(2, ernum);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<BoardVo>();
			
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBoardId(rs.getInt("BOARD_ID"));
				vo.setBoardUser(rs.getString("BOARD_USER"));
				vo.setReadCount(rs.getInt("READ_COUNT"));
				vo.setSubmitDate(rs.getDate("SUBMIT_DATE"));
				vo.setTitle(rs.getString("TITLE"));
				
				result.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

	public int getCountBoard(Connection con) {
		int result = -1;
		
		String sql="select count(*) from tb_board";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return result;
	}
	
	public int insertBoard(BoardVo vo, Connection con) {
		int result = 0;
		String sql = "insert into tb_board values( "
				+ "(select NVL(max(BOARD_ID), 0)+1 from tb_board) "
				+ ", ?, ?"
				+ ", default, ?, default)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getBoardUser());
			pstmt.setString(3, vo.getBoardContent());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con);
			close(pstmt);
		}
		return result;
	}
	
	public BoardVo getBoardContent(int boardId, Connection con) {
		BoardVo result = null;
		
		String sql = "select title, board_user, submit_date "
				+ ", board_content, read_count "
				+ "from tb_board where board_id=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			rs=pstmt.executeQuery();
			
			result = new BoardVo();
			
			while(rs.next()) {
				result.setBoardContent(rs.getString("BOARD_CONTENT"));
				result.setTitle(rs.getString("TITLE"));
				result.setBoardUser(rs.getString("BOARD_USER"));
				result.setSubmitDate(rs.getDate("SUBMIT_DATE"));
				result.setReadCount(rs.getInt("BOARD_CONTENT"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updateReadCount(int boardId, Connection con) {
		int result = 0;
		String sql = "update tb_board set read_count = read_count + 1 where board_id=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con);
			close(pstmt);
		}
		
		return result;
	}
}
