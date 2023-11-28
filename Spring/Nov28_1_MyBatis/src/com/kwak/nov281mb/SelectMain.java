package com.kwak.nov281mb;

import java.util.List;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("asdf.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();
			
			List<Fruit> fruits = ss.selectList("kwak.getAllFruit");
			
			for (Fruit f : fruits) {
				System.out.println("===========");
				System.out.println(f.getF_name());
				System.out.println(f.getF_price());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
