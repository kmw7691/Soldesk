package com.kwak.nov293;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwak.nov293.fruit.Fruit;
import com.kwak.nov293.member.MemberDAO;

@Controller
public class HomeController {
	
	@Autowired
	private Fruit f;
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println(f.getName());
		System.out.println(f.getPrice());
		
		mDAO.test();
		
		return "home";
	}
	
}
