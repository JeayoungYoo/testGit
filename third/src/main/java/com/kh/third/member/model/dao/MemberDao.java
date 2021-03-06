package com.kh.third.member.model.dao;

import com.kh.third.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public MemberDao(){}
	
	public Member selectMember(Member m) {
		return sqlSession.selectOne("Member.loginCheck", m);
	}
	
}
