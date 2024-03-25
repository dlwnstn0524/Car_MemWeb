package com.ssafy.test.service;

import java.sql.SQLException;

import com.ssafy.test.dao.MemberDao;
import com.ssafy.test.dao.MemberDaoImpl;
import com.ssafy.test.model.Member;

public class MemberServiceImpl implements MemberService{

	private static MemberServiceImpl instance = new MemberServiceImpl();
	private MemberDao memDao = MemberDaoImpl.getInstance();
	
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public Member login(Member m) throws SQLException {
		// TODO Auto-generated method stub
		return memDao.login(m);
	}

}
