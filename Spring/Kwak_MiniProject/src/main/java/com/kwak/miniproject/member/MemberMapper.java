package com.kwak.miniproject.member;

import java.util.List;


public interface MemberMapper {
	public abstract List<Member> getMemberById(Member m);
	public abstract int join(Member m);
	public abstract int bye(Member m);
	public abstract int update(Member m);
}
