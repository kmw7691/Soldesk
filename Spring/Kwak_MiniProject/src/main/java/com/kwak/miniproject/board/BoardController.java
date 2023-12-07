package com.kwak.miniproject.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwak.miniproject.member.MemberDAO;
import com.kwak.miniproject.TokenMaker;


@Controller
public class BoardController {
	
	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private BoardDAO bDAO;
	
	private boolean isFirstReq;
	
	public BoardController() {
		isFirstReq = true;
	}
	
	@RequestMapping(value = "/board.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		if (isFirstReq) {
			bDAO.countAllMsg();
			isFirstReq = false;
		}
		mDAO.loginCheck(req);
		bDAO.searchClear(req);
		bDAO.searchMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/board.delete", method = RequestMethod.GET)
	public String BoardDelete(BoardMsg bm, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			bDAO.deleteMsg(bm, req);
		}
		bDAO.searchMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/board.page.change", method = RequestMethod.GET)
	public String BoardPageChange(HttpServletRequest req) {
		mDAO.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
		bDAO.searchMsg(p, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/board.reply.delete", method = RequestMethod.GET)
	public String BoardReplyDelete(BoardReply br, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			bDAO.deleteReply(br, req);
		}
		bDAO.searchMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/board.reply.write", method = RequestMethod.POST)
	public String BoardReplyWrite(BoardReply br, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			bDAO.writeReply(br, req);
		}
		bDAO.searchMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/board.search", method = RequestMethod.POST)
	public String BoardSearch(HttpServletRequest req) {
		mDAO.loginCheck(req);
		bDAO.searchMsg(req);
		bDAO.searchMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/board.update", method = RequestMethod.GET)
	public String BoardUpdate(BoardMsg bm, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			bDAO.updateMsg(bm, req);
		}
		bDAO.searchMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board.jsp");
		return "index";
	}

	@RequestMapping(value = "/board.write", method = RequestMethod.POST)
	public String BoardWrite(BoardMsg bm, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			bDAO.writeMsg(bm, req);
		}
		bDAO.searchMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board.jsp");
		return "index";
	}
}
