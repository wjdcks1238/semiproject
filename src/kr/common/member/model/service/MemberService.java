package kr.common.member.model.service;

import java.sql.Connection;

import static kr.common.jdbc.JDBCTemplate.*;

import kr.common.board.dao.BoardDao;
import kr.common.board.vo.BoardVo;
import kr.common.member.model.dao.MemberDao;
import kr.common.member.model.vo.MemberVo;

public class MemberService {
	public MemberVo login(MemberVo vo) {
		MemberVo result = null;
		Connection con = getConnection();
		result = new MemberDao().login(con, vo);
		close(con);
		return result;
	}
	
	public int join(MemberVo vo) {
		int result = -1;
		Connection con = getConnection();
		result = new MemberDao().join(con, vo);
		close(con);
		return result;
	}
	
	public int dupIdChk(String id) {
		Connection con = getConnection();
		int result = new MemberDao().dupIdChk(con, id);
		System.out.println(result);
		return result;
	}
	
	public MemberVo getInfo(String id) {
		MemberVo result = null;
		Connection con = getConnection();
		
		result = new MemberDao().getInfo(id, con);
		
		return result;
	}
	
	public int updateUser(MemberVo vo) {
		int result = 0;
		Connection con = getConnection();
		
		result = new MemberDao().updateUser(vo, con);
		System.out.println(result);
		return result;
	}
}
