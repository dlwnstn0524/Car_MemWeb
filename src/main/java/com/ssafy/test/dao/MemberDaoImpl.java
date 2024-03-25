package com.ssafy.test.dao;

import java.sql.SQLException;

import com.ssafy.test.model.Member;
import com.ssafy.test.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao = new MemberDaoImpl();
	private DBUtil dbUtil;
	
	private MemberDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static MemberDao getInstance() {
		return memberDao;
	}

	@Override
	public Member login(Member m) throws SQLException {
		// TODO Auto-generated method stub
		Member member = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder loginMember = new StringBuilder();
			loginMember.append("select * \n");
			loginMember.append("from members \n");
			loginMember.append("where id = ? and password = ? \n");
			pstmt = conn.prepareStatement(loginMember.toString());
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				member = new Member(id, password);
			}
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		return member;
	}

}
