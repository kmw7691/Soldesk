package com.kwak.miniproject.gall;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class GallDAO {
	@Autowired
	private SqlSession ss;
	
	//사진업로드
	public void upload(Gall g, HttpServletRequest req) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			
			//용량 20메가까지
			MultipartRequest mr = new MultipartRequest(req, path, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			String photo = mr.getFilesystemName("photo");
			photo = URLEncoder.encode(photo, "utf-8").replace("+", " ");
			g.setG_photo(photo);
			
			if(ss.getMapper(GallMapper.class).upload(g) == 1) {
				req.setAttribute("r", "사진업로드성공");
			} else {
				req.setAttribute("r", "사진업로드실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "사진업로드실패");
		}
	}
	
	//사진삭제
	public void delete(Gall g, HttpServletRequest req) {
		try {
			if(ss.getMapper(GallMapper.class).delete(g) == 1) {
				req.setAttribute("r", "사진삭제성공");
			} else {
				req.setAttribute("r", "사진삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "사진삭제실패");
		}
	}
}
