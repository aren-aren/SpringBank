package com.moveone.app.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.moveone.app.member.MemberDAO.";

	public int join(MemberDTO memberDTO) {
		return sqlSession.insert(NAMESPACE + "join", memberDTO);
	}

	public int addAvatar(AvatarDTO avatarDTO) {
		return sqlSession.insert(NAMESPACE + "addAvatar", avatarDTO);
	}

	public MemberDTO getDetail(MemberDTO memberDTO) {
		return sqlSession.selectOne(NAMESPACE + "getDetail", memberDTO);
	}

	public int setUpdate(MemberDTO memberDTO) {
		return sqlSession.update(NAMESPACE + "setUpdate", memberDTO);
	}

	public int setMemberRole(MemberDTO memberDTO) {
		return sqlSession.insert(NAMESPACE + "setMemberRole", memberDTO);
	}

}
