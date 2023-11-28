package com.kwak.nov171.apple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kwak.db.manager.KwakDBManager;

//메소드는 메소드명 기준 알파벳순 <- 국룰


public class appleDAO {
	
	private int allAppleCount;
	
	private static final appleDAO APPLEDAO = new appleDAO();
	
	public appleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	//AppleController에서는 getAppleDAO로만 appleDAO파일 접근 가능
	public static appleDAO getAppleDAO() {
		return APPLEDAO;
	}
	
	//모든 사과데이터 가져오기 - Read(select)
	public void getAllApples(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//db연결
			con = KwakDBManager.connect("kwakPool");
			
			//sql문 작성
			String sql = "select*from nov17_apple order by a_price";
			pstmt = con.prepareStatement(sql);
			
			//C U D : pstmt.executeUpdate()로 실행 -> 데이터가 몇개 영향 받앗는지
			//R : pstmt.executeQuery()로 실행 >> select의 결과가 ResultSet으로 보내짐
			rs = pstmt.executeQuery(); 
			
			//rs에 있는 것들을 담을 빈 ArrayList 생성
			ArrayList<Apple> apples = new ArrayList<Apple>();
			Apple apple = null;
			
			while(rs.next()) {
				apple = new Apple(); //새 객체하나 꺼내기
				apple.setA_location(rs.getString("a_location"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_introduce(rs.getString("a_introduce"));
				apples.add(apple); //javabean하나 원성되면 ArrayList에 담기
			}
			
			//다 담긴 ArrayList를 jsp파일에 풀기 위해 >> setAttribute
			request.setAttribute("apples", apples);
		} catch (Exception e) {
			e.printStackTrace();
		}
		KwakDBManager.close(con, pstmt, rs);
		//dao <-> controller <->jsp
	}

	//사과 등록하기 - C(create) - insert
	public void reg(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			
			//web에서 작성한 데이터 가져오기
			request.setCharacterEncoding("utf-8");
			
			//apple폴더 안에 있는 reg.jsp의 name부분 받아오기
			String location = request.getParameter("a_location");
			String color = request.getParameter("a_color");
			String flavor = request.getParameter("a_flavor");
			int price = Integer.parseInt(request.getParameter("a_price"));
			String introduce = request.getParameter("a_introduce").replace("\r\n", "<br>");
			
			//db sql문 작성
			String sql = "insert into nov17_apple values("
						+ "?, ?, ?, ?, ?)";
			
			//db총괄 매니저
			pstmt = con.prepareStatement(sql);
			
			//sql문 완성 -> ?채우기
			pstmt.setString(1, location);
			pstmt.setString(2, color);
			pstmt.setString(3, flavor);
			pstmt.setInt(4, price);
			pstmt.setString(5, introduce);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[등록 성공]");
				allAppleCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[등록 실패]");
		}
		KwakDBManager.close(con, pstmt, null);
	}

	//총 사과데이터가 몇개인가
	public void countApples() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			
			String sql = "select count(*) from nov17_apple";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allAppleCount = rs.getInt("count(*)");
			System.out.println(allAppleCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		KwakDBManager.close(con, pstmt, rs);
	}

	//만약 데이터가 너무 많으면 -> 해당페이지 번호에 맞는 데이터만 가져오게
	public void getApples(int pageNo, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			
			//SQL실행하는데 필요한 값 챙기기
			//allAppleCount = 전체 사과 데이터 수
			int applePerPage = 5; //한페이지에 사과데이터 5개
			
			//총 데이터수 : 6
			//필요한 페이지 : 2
			//Math.ceil : 숫자 올림(반올림x)
			int pageCount = (int) Math.ceil(allAppleCount / (double) applePerPage);
			request.setAttribute("pageCount", pageCount); //apple/apple.jsp에서 EL사용함
			//////////////////////////////////////////////
			//페이지당 시작데이터 숫자 & 끝데이터 숫자
			int start = (applePerPage * (pageNo - 1) + 1);
			int end = (pageNo == pageCount) ? allAppleCount : (start + applePerPage - 1);
			
			String sql = "select * from( "
					+ " select rownum as rn, a_location, a_color, a_flavor, a_price, a_introduce "
					+ "	from( "
					+ "		select * "
					+ "			from nov17_apple order by a_price "
					+ "		) "
					+ " ) "
					+ " where rn >= ? and rn <= ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			//빈 ArrayList
			ArrayList<Apple> apples = new ArrayList<Apple>();
			//빈 Javabean
			Apple apple = null;
			
			while(rs.next()) {
				apples.add(new Apple(
							rs.getString("a_location"),
							rs.getString("a_color"),
							rs.getString("a_flavor"),
							rs.getInt("a_price"),
							rs.getString("a_introduce"))
						);
			}
			request.setAttribute("apples", apples);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		KwakDBManager.close(con, pstmt, rs);
	}

	//상세정보조회 : primary key 이용
	//제대로 정보가 가져와지면true, 아니면 false
	public boolean getAppleDetail(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			String location = request.getParameter("a_location");
			
			String sql = "select*from nov17_apple where a_location = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Apple apple = new Apple();
				apple.setA_location(rs.getString("a_location"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_introduce(rs.getString("a_introduce"));
				request.setAttribute("apple", apple);	//detail.jsp에서씀
					
				return true;	//일반적인 상황 : 데이터가 한개
			}
			
			return false;		//ex) 이미 지워져버린 데이터 or 데이터가 없으면
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;		//DB문제
		} finally {
			KwakDBManager.close(con, pstmt, rs);
		}
	}

	//데이터 수정하기 : U (update)
	public boolean update(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			
			request.setCharacterEncoding("utf-8");
			String location = request.getParameter("a_location");
			String color = request.getParameter("a_color");
			String flavor = request.getParameter("a_flavor");
			int price = Integer.parseInt(request.getParameter("a_price"));
			String intro = request.getParameter("a_introduce").replace("\r\n", "<br>");
			
			String sql = "update nov17_apple set a_color = ?, a_flavor = ?, "
					+ " a_price = ?, a_introduce = ? where a_location = ?";
				
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, color);
			pstmt.setString(2, flavor);
			pstmt.setInt(3, price);
			pstmt.setString(4, intro);
			pstmt.setString(5, location);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "수정성공");
				return true;
			} else {
				request.setAttribute("r", "수정실패");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "수정실패");
			return false;
		} finally {
			KwakDBManager.close(con, pstmt, null);
		}
	}

	//데이터 삭제하기 : D (delete)
	public void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = KwakDBManager.connect("kwakPool");
			
			String location = request.getParameter("a_location");
			String sql = "delete from nov17_apple where a_location = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, location);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제성공");
				allAppleCount--;
			} else {
				request.setAttribute("r", "삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "삭제실패");
		}
		KwakDBManager.close(con, pstmt, null);
	}
}








































