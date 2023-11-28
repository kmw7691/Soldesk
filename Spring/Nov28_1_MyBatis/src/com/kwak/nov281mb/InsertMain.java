package com.kwak.nov281mb;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InsertMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		
		try {
			InputStream is = Resources.getResourceAsStream("asdf.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();
			
			//값넣기
			Scanner k = new Scanner(System.in);
			System.out.print("과일이름 : ");
			String n = k.next();
			System.out.print("과일가격 : ");
			BigDecimal p = k.nextBigDecimal();
			
			//입력받은 값들은 자바빈으로
			Fruit f = new Fruit(n, p);
			
			if(ss.insert("kwak.regFruit", f) == 1) {
				System.out.println("굿");
				ss.commit(); //실질적으로 db적용
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
