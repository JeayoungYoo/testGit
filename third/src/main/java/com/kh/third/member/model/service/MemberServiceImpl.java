package com.kh.third.member.model.service;

import com.kh.third.member.model.dao.MemberDao;
import com.kh.third.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
		
	@Override
	public Member loginMember(Member m) {
		// TODO Auto-generated method stub
		return memberDao.selectMember(m);
	}

	@Override
	public String minsert(Member m) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
