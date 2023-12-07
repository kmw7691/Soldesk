package com.kwak.miniproject.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwak.miniproject.SiteOption;
import com.kwak.miniproject.member.Member;


@Service
public class BoardDAO {
	private int allMsgCount;
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SiteOption so;
	
	public void countAllMsg() {
		allMsgCount = ss.getMapper(BoardMapper.class).getAllMsgCount();
	}
	
	//글삭제
	public void deleteMsg(BoardMsg bm, HttpServletRequest req) {
		try {
			if(ss.getMapper(BoardMapper.class).deleteMsg(bm) == 1) {
				req.setAttribute("r", "글삭성공");
				allMsgCount--;
			}else {
				req.setAttribute("r", "글삭실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글삭실패");
		}
	}
	
	//댓글삭제
	public void deleteReply(BoardReply br, HttpServletRequest req) {
		try {
			if(ss.getMapper(BoardMapper.class).deleteReply(br) == 1) {
				req.setAttribute("r", "댓글삭성공");
			} else {
				req.setAttribute("r", "댓글삭실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "댓글삭실패");
		}
	}
	
	//글검색 
	public void searchMsg(int page, HttpServletRequest req) {
		req.setAttribute("curPage", page);
		
		String search = (String) req.getSession().getAttribute("search"); //검색어
		
		int msgCount = 0;
		
		if(search == null) { //검색어가 없으면 전체 조회
			msgCount = allMsgCount;
			search= "";
		} else {
			BoardSelector bsel2 = new BoardSelector(search, 0, 0);
			msgCount = ss.getMapper(BoardMapper.class).getSearchMsgCount(bsel2);	
		}
		int allPageCount = (int) Math.ceil((double)msgCount / so.getSnsMsgPerPage());
		req.setAttribute("allPageCount", allPageCount);
		
		int start = (page - 1) * so.getSnsMsgPerPage() + 1;
		int end = (page == allPageCount) ? msgCount : start + so.getSnsMsgPerPage() - 1;
		
		BoardSelector bsel = new BoardSelector(search, start, end);
		List<BoardMsg> boardMsgs = ss.getMapper(BoardMapper.class).searchMsg(bsel);
		
		for (BoardMsg boardMsg : boardMsgs) {
			boardMsg.setS_replys(ss.getMapper(BoardMapper.class).getReply(boardMsg));
		}
		req.setAttribute("msgs", boardMsgs);
	}
	
	//검색어초기화
	public void searchClear(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
	//글검색
	public void searchMsg(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search", search);
	}
	
	//글수정
	public void updateMsg(BoardMsg bm, HttpServletRequest req) {
		try {
			if(ss.getMapper(BoardMapper.class).updateMsg(bm) == 1) {
				req.setAttribute("r", "글수정성공");
			} else {
				req.setAttribute("r", "글수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글수정실패");
		}
	}
	
	//글쓰기
	public void writeMsg(BoardMsg bm, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");

			String st2 = (String) req.getSession().getAttribute("st");
			
			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "글쓰기실패(새로고침)");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			bm.setId(m.getId());
			
			String text = bm.getS_text();
			text = text.replace("\r\n", "<br>");
			bm.setS_text(text);
			
			if(ss.getMapper(BoardMapper.class).writeMsg(bm) == 1) {
				req.setAttribute("r", "글쓰기성공");
				req.getSession().setAttribute("st", token);
				allMsgCount++;
			} else {
				req.setAttribute("r", "글쓰기실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글쓰기실패");
		}
	}
	
	//댓글쓰기
	public void writeReply(BoardReply br, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");

			String st2 = (String) req.getSession().getAttribute("st");
			
			if(st2 != null && token.equals(st2)) {
				req.setAttribute("r", "댓글실패");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			br.setSr_writer(m.getId());
			
			if(ss.getMapper(BoardMapper.class).writeReply(br) == 1) {
				req.setAttribute("r", "댓글성공");
				req.getSession().setAttribute("st", token);
			} else {
				req.setAttribute("r", "댓글실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "댓글실패");
		}
	}
}
