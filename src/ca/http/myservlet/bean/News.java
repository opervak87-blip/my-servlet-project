package ca.http.myservlet.bean;

import java.util.Date;

public class News {
	
	private int id;
	private String title;
	private String article;
	private Date createdAt;

	News(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.article = builder.article;
		this.createdAt = builder.createdAt;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getArticle() {
		return article;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void print() {
		System.out.println("id : "+ this.getId() + " title : " + this.getTitle() + 
				" date : " + this.getCreatedAt() + " article : " + this.getArticle());
	}

	public static class Builder {
		private int id;
		private String title;
		private String article;
		private Date createdAt;

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder article(String article) {
			this.article = article;
			return this;
		}
		
		public Builder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
			
		}

		public News build() {
			return new News(this);
		}
	}


}
