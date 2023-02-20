package kr.common.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static kr.common.jdbc.JDBCTemplate.*;
import kr.common.member.model.vo.MemberVo;

public class MemberDao {
	public MemberVo login(Connection con, MemberVo vo) {
		MemberVo result = null;
		String sql = "select id, name, email from tb_user ";
		sql += "where id=? and passwd=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result = new MemberVo();
				result.setEmail("email");
				result.setId("id");
				result.setName("name");
				result.setPasswd("passwd");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public int join(Connection con, MemberVo vo) {
		int result = -1;
		String sql = "insert into tb_user values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		return result;
	}
	
	public int dupIdChk(Connection con, String id) {
		int result = 0;
		System.out.println(id);
		String sql = "select count(*) from tb_user where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}
}
