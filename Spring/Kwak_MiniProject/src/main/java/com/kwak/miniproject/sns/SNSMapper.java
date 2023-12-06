package com.kwak.miniproject.sns;

import java.util.List;

public interface SNSMapper {
	public abstract int deleteMsg(SNSMsg sm);

	public abstract int deleteReply(SNSReply sr);

	public abstract int getAllMsgCount();

	public abstract List<SNSMsg> getMsg(SNSSelector sSel);

	public abstract List<SNSReply> getReply(SNSMsg sm);

	public abstract int getSearchMsgCount(SNSSelector sSel);

	public abstract int writeMsg(SNSMsg sm);

	public abstract int writeReply(SNSReply sr);

	public abstract int updateMsg(SNSMsg sm);
}
