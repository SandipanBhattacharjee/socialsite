package sf.crom.restservice.model;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Messege {
	private long id;
	private String author;
	private String messege;
	private Date createdDate;
	private Map<Long, Comment> commentMap=new HashMap<>();
	
	public Messege(){}
	
	public Messege(long id,  String messege, String author) {
		super();
		this.id = id;
		this.author = author;
		this.messege = messege;
		this.createdDate = new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@XmlTransient
	public Map<Long, Comment> getCommentMap() {
		return commentMap;
	}

	public void setCommentMap(Map<Long, Comment> commentMap) {
		this.commentMap = commentMap;
	}
	
	

}
