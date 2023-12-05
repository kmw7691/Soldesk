package com.kwak.dec042.error;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorDAO {
	@Autowired
	private SqlSession ss;
	
	public void getAllError(HttpServletRequest req) {
		try {
			req.setAttribute("errors", ss.getMapper(ErrorMapper.class).getAllError());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Errors getJson(HttpServletRequest req) {
		return new Errors(ss.getMapper(ErrorMapper.class).getAllError());
	}
	
	public Errors searchError(Error e, HttpServletRequest req) {
		return new Errors(ss.getMapper(ErrorMapper.class).searchError(e));
	}
}
