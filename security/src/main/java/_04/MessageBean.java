package _04;

import java.sql.Timestamp;

public class MessageBean {
	int seqno; 
	String fromId; 
	String toId; 
	String title; 
	String content;
	Timestamp ts;
	
    public MessageBean(String fromId, String toId, String title, String content) {
		this.fromId = fromId;
		this.toId = toId;
		this.title = title;
		this.content = content;
	}
    
	public MessageBean(int seqno, String fromId, String toId, String title,
			 Timestamp ts, String content) {
		super();
		this.seqno = seqno;
		this.fromId = fromId;
		this.toId = toId;
		this.title = title;
		this.content = content;
		this.ts = ts;
	}

	public MessageBean() {
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	
	
	
}
