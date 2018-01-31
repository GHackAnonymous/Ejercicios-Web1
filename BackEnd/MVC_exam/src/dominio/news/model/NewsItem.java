package dominio.news.model;

import java.util.Date;
import java.util.Locale;

import domain.user.model.User;

public class NewsItem implements java.io.Serializable{
	private static final long serialVersionUID = 7927744272163377158L;
	private Integer newsItemId;
	private String title;
	private String body;
	private User author;
	private Date date;
	private Locale lang;
	
	public NewsItem(){}
	
	public Integer getNewsItemId() {
		return newsItemId;
	}
	public void setNewsItemId(Integer newsItemId) {
		this.newsItemId = newsItemId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Locale getLang() {
		return lang;
	}
	public void setLang(Locale lang) {
		this.lang = lang;
	}
	
	
	
}
