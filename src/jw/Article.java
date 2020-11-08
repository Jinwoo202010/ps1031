package jw;

public class Article {

	private int id;
	private String title;
	private String body;
	private String enrdate;
	private int views;
	private String writer;

	public Article(int id, String title, String body, String enrdate, int views, String writer) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.enrdate = enrdate;
		this.views = views;
		this.writer = writer;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getEnrdate() {
		return enrdate;
	}

	public void setEnrdate(String enrdate) {
		this.enrdate = enrdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
