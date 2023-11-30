package com.kwak.nov301.student;

import java.util.List;

public interface StudentMapper {
	//method 리턴타입
	//	insert / update / delete -> 영향을 받은 데이터 수 -> int(리턴타입) 
	//	select
	//		결과가 하나만 나오면 -> resultType객체(Student)
	//		결과가 여러개 나오면 -> List<resultType객체> (List<Student>)
	
	//result Type
	
	//메소드명 : mapper.xml의 id와 맞추기
	//파라미터 : mapper.xml의 parameterType과 맞추기
	public abstract int regStudent(Student s);
	public abstract List<Student> getAllStudent();
	
	
}
