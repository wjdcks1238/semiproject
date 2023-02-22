package kr.common.comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.common.comment.vo.CommentVo;
import static kr.common.jdbc.JDBCTemplate.*;

public class CommentDao {
	public CommentVo getBoardComment(int boardId, CommentVo vo, Connection con) {
		CommentVo result = null;      
//		--------------- -------- -------------- 
//		BOARD_ID        NOT NULL NUMBER         
//		COMMENT_ID      NOT NULL NUMBER         
//		USERNAME        NOT NULL VARCHAR2(20)   
//		COMMENT_CONTENT NOT NULL VARCHAR2(1000) 
//		SUBMIT_DATE              DATE  
		String sql = "select username, comment_content, submit_date "
				+ "from TB_COMMENT where board_id=? "
				+ "order by COMMENT_ID desc";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new CommentVo();
				result.setUserName(rs.getString("USERNAME"));
				result.setCommentContent(rs.getString("COMMENT_CONTENT"));
				result.setSubmitDate(rs.getDate("SUBMIT_DATE"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		
		return result;
	}

	public int getCountComment(int boardid, Connection con) {
		System.out.println("2게시글 번호 : " + boardid);
		int result = 0;
		String sql = "select count(*) from tb_comment where BOARD_ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("DAO : " + result);
		return result;
	}

	public ArrayList<CommentVo> getCommentList(Connection con, int srnum, int ernum, int boardid) {
		ArrayList<CommentVo> result = null;
		String sql = "select * from (select rownum rn, tbl_1.* "
				+ "from(select rownum xn, comment_id, USERNAME, COMMENT_CONTENT "
				+ ", SUBMIT_DATE from tb_comment "
				+ "where board_id=? order by comment_id desc) tbl_1)tbl_2 "
				+ "where rn between ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardid);
			pstmt.setInt(2, srnum);
			pstmt.setInt(3, ernum);
			
			rs = pstmt.executeQuery();
			result = new ArrayList<CommentVo>();
			while(rs.next()) {
				CommentVo vo = new CommentVo();
				vo.setCommentId(rs.getInt("COMMENT_ID"));
				vo.setUserName(rs.getString("USERNAME"));
				vo.setCommentContent(rs.getString("COMMENT_CONTENT"));
				vo.setSubmitDate(rs.getDate("SUBMIT_DATE"));
				System.out.println("vo값 : " + vo);
				result.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println(result);
		return result;
	}
}
