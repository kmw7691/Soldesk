package com.kwak.miniproject.board;

import java.util.List;

public interface BoardMapper {
	public abstract int deleteMsg(BoardMsg bm);

	public abstract int deleteReply(BoardReply br);

	public abstract int getAllMsgCount();

	public abstract List<BoardMsg> searchMsg(BoardSelector bsel);

	public abstract List<BoardReply> getReply(BoardMsg bm);

	public abstract int getSearchMsgCount(BoardSelector bsel);

	public abstract int writeMsg(BoardMsg bm);

	public abstract int writeReply(BoardReply br);

	public abstract int updateMsg(BoardMsg bm);
}
