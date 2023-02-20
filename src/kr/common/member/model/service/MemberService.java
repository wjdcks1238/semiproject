package kr.common.member.model.service;

import java.sql.Connection;

import static kr.common.jdbc.JDBCTemplate.*;

import kr.common.member.model.dao.MemberDao;
import kr.common.member.model.vo.MemberVo;

public class MemberService {
	public MemberVo login(MemberVo vo) {
		MemberVo result = null;
		Connection con = getConnection();
		System.out.println(vo);
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
}
