package com.kh.third.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.third.member.model.service.MemberService;
import com.kh.third.member.model.vo.Member;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String loginCheck(Member m, HttpSession session) {

		Member member = memberService.loginMember(m);
		if (member != null) {
			System.out.println(member);
			session.setAttribute("member", member);
		}
		return "index";
	}

	@RequestMapping("logout.do")
	public String logoutMember(HttpSession session) {
		logger.info("logoutMember() call...");

		if (session.getAttribute("member") != null) {
			session.invalidate();
		}

		return "home";
	}
	
	@RequestMapping("enrollView.do")
	public String enrollView() {
		return "member/enroll";
	}
	
	@RequestMapping("minsert.do")
	public String insertNoticeForm(Member m, HttpServletRequest request) {
		
		String address = request.getParameter("address1") + ", " +request.getParameter("address2") + ", " + request.getParameter("address3"); 
		m.setAddress(address);
		return memberService.minsert(m);
	}
	
	/*@RequestMapping("/member/enroll")
	public String getNoticeList(@RequestParam(value="page", defaultValue="1") int page, Model model) throws Exception {
		model.addAttribute("noticeItemList", nSvc.getNoticeList(page))
		.addAttribute("pageInfo", new PagingUtil().getPageInfo(page, nSvc.getNoticeTotalCount()))
		.addAttribute("queryInfo", new MakeQueryUtil());
		return "notice/noticeList";
	}*/

	
}
