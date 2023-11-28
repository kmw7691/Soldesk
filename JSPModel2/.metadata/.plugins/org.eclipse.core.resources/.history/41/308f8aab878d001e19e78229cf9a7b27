package com.kwak.nov223.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kwak.db.manager.KwakDBManager;
import com.kwak.nov223.member.Member;


public class BoardDAO {
	private int allBoardCount;
	
	private static final BoardDAO BDAO = new BoardDAO();
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static BoardDAO getBDAO() {
		return BDAO;
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
			allBoardCount = rs.getInt("count(*)");
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
					+ "	where b_writer = m_id and b_text like '%'||?||'%'";
			
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
	public void getBoardMsg(int pageNo, HttpServletRequest req) {
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
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("pageNo", pageNo);
			
			//페이지별 첫번째 게시글, 마지막 게시글
			int start = boardPerPage * (pageNo - 1) + 1;
			int end = (pageNo == pageCount) ? boardCount : (start + boardPerPage -1);
			
			String sql = "select * from( "
					+ "	select rownum as rn, b_no, b_writer, b_when, b_text, m_photo "
					+ "		from ( "
					+ "			select*from NOV27_BOARD, NOV22_MEMBER "
					+ "			where m_id = b_writer and b_text like '%'||?||'%' "
					+ "			order by b_when desc "
					+ "		) "
					+ "	) "
					+ "	where rn >= ? and rn <= ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Board> boards = new ArrayList<Board>();
			Board board = null;
			
			while(rs.next()) {
				board = new Board();
				board.setB_no(rs.getInt("b_no"));
				board.setB_writer(rs.getString("b_writer"));
				board.setB_when(rs.getDate("b_when"));
				board.setB_text(rs.getString("b_text"));
				board.setM_photo(rs.getString("m_photo"));
				boards.add(board);
			}
			req.setAttribute("boards", boards);
		} catch (Exception e) {
			e.printStackTrace();
		}
		KwakDBManager.close(con, pstmt, rs);
	}

	//게시글 작성하기
	public void write(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			
			//insert에 넣을 값
			//	글번호 - sequence
			//	날짜 - sysdate
			//	작성자 - 로그인해서 사용하는 사람의 id
			//	글내용 - b_text
			Member m = (Member) req.getSession().getAttribute("loginMember");
			String b_writer = m.getM_id();
			String b_text = req.getParameter("b_text").replace("\r\n", "<br>");
			
			String formerToken = (String) req.getSession().getAttribute("formerToken");
			System.out.println("fromerToken : " + formerToken);
			
			String token = req.getParameter("token");
			System.out.println("token " + token);

			if(!token.equals(formerToken)) {
				String sql = "insert into NOV27_BOARD values( "
						+ " nov27_board_seq.nextval, ?, sysdate, ?)";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, b_writer);
				pstmt.setString(2, b_text);
				
				if(pstmt.executeUpdate() == 1) {
					req.setAttribute("r", "글쓰기성공");
					req.getSession().setAttribute("formerToken", token);
					allBoardCount++;
				}
			} else {
				req.setAttribute("r", "새로고침문제");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글쓰기실패");
		}
		KwakDBManager.close(con, pstmt, null);
	}

	//게시글 삭제하기
	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			
			int no = Integer.parseInt(req.getParameter("b_no"));
			
			String sql = "delete from NOV27_BOARD where b_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			if(pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "삭제성공");
				allBoardCount--;
			} else {
				req.setAttribute("r", "삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "삭제실패-DB문제");
		}
		KwakDBManager.close(con, pstmt, null);
	}
}	



















