package com.kwak.nov223.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.kwak.db.manager.KwakDBManager;

public class BoardDAO {
	private int allBoardCount;
	
	private static final BoardDAO BDAO = new BoardDAO();
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void countAllBoard() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			String sql = "select count(*) from nov27_board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allBoardCount = rs.getInt("conut(*)");
			System.out.println(allBoardCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		KwakDBManager.close(con, pstmt, rs);
	}
	
	private int countSerachMsg(String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			
			String sql = "select count(*) from nov27_board, NOV22_MEMBER "
					+ "	where b_writer = m_id and b_text like '%||?||%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			rs.next();
			
			return rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			KwakDBManager.close(con, pstmt, rs);
		}
	}
	
	//검색어 값 가져오기
	public void searchBoardMsg(HttpServletRequest req) {
		//새로운 요청이 일어났을때(페이지 전환)에도 검색어가 살아잇어야됨
		String search = req.getParameter("search"); //<input name="search">
		//검색(요청) - 25개 - 한페이지에 10개 보여줄것
		//검색한것의 2페이지로 요청, 검색한것의 3페이지로 요청
		// ->session
		req.getSession().setAttribute("search", search);
	}
	
	//게시판에 처음 접근 or 검색어 입력 안햇을때
	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
	//게시글 보이게하기
	public void getBoardMsg(HttpServletRequest req, int pageNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			
			int boardCount = allBoardCount; //게시글 전체 개수
			String search = (String) req.getSession().getAttribute("search");
			if(search == null) { //검색어가없다 -> 게시글 전체조회
				search = ""; //sql문 검색어부분을 빈칸
			} else { //검색어가있다
				boardCount = countSerachMsg(search); //위 메소드 가져오기
			}
			
			int boardPerPage = 3; //페이지당 보이는 게시글 3개
			
			//소수점올림 : Math.ceil();
			int pageCount = (int)Math.ceil(boardCount / (double) boardPerPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}	



















