package com.kwak.nov292;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwak.nov292.book.Book;
import com.kwak.nov292.dog.Dog;

//Spring : Java에서 IoC로 DI해주는 Framework
//		   평소) 객체를 .java에서 만들엇음
//		  지금) 객체를 외부파일(.xml)에 만들기 -> .java에서 불러서 사용할수 있게

//		IoC(제어의 역전 - Inversion of Control)
//			 프로그램의 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것
//		DI(의존성 주입 - Dependency injection)
//			이런 제어의 역전 패턴을 달성하는 방법 중 하나

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		//원래는 객체를 이렇게 만들었음
//		Dog d = new Dog("개", 3);
//		System.out.println(d.getName());
//		System.out.println(d.getAge());
		
		//bean.xml만들기
		//src/main/resources에서 우클릭 -> new -> other -> spirng검색
		//Spring Bean Configuration File 클릭
		
		//nov292Beans.xml 불러오기 -> xml파일에 등록해놓은 객체를 만들어서
		//AbstractApplicationContext : Bean 객체를 생성하고 관리하는 기능
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("nov292Beans.xml");
		
		//aac가 없어질때 등록해놓은 객체들 다 없애기
		aac.registerShutdownHook();
		
		//id가 d인 강아지 객체 불러오기
		Dog d = aac.getBean("d", Dog.class); //xml객체 불러오기
		System.out.println(d);
		
		//DI(의존성주입)
		//		xml에서 객체를 만들고, 속성값 넣고
		//		java에서 가져다쓰는
		Dog d3 = aac.getBean("d3", Dog.class);
		System.out.println(d3.getName());
		System.out.println(d3.getAge());
		
		Dog dog = aac.getBean("d2", Dog.class);
		System.out.println(dog.getName());
		System.out.println(dog.getAge());
		
		//Book이라는 자바빈
		//nov292beans에 객체만들고 이름~가격 출력
		//두가지 방법 다사용
		Book b1 = aac.getBean("book1", Book.class);
		System.out.println(b1);
		
		Book b2 = aac.getBean("book1", Book.class);
		System.out.println(b2.getName());
		System.out.println(b2.getPrice());
		//aac없애기
		aac.close();
		
		return "home";
	}
	
}
