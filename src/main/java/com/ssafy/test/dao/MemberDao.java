package com.ssafy.test.dao;

import com.ssafy.test.model.Member;
import java.sql.SQLException;

public interface MemberDao {
	Member login(Member m) throws SQLException;
}
