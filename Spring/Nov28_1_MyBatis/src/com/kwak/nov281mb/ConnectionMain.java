package com.kwak.nov281mb;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//			DB서버 연결			SQl						SQL명령문
//Java		JDBC			.java					.java
//JSP		ConnectionPool	META-INF/context.xml	.java(DAO)
//Spring	MyBatis			asdf.xml				fdsa.xml

//MyBatis(ver 3.x : MyBatis, ver2.x : iBatis)
//DB ORM(Object Relationship Mapping) framework : DB데이터 POJO를 통해 자동 매핑

//mybatis.jsr
//ojdbc.jar

public class ConnectionMain {
	public static void main(String[] args) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		//위에 세개 포함해서
		SqlSession ss = null;
		
		try {
			String resource = "asdf.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();
			
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
