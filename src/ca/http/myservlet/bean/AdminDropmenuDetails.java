package ca.http.myservlet.bean;

public class AdminDropmenuDetails {

	private int id;
	private AdminDropMenu dropMenu;
	private String title;
	private String article;
	private boolean inUse;

	public int getId() {
		return id;
	}

	public AdminDropMenu getAdminDropMenu() {
		return dropMenu;
	}

	public String getTitle() {
		return title;
	}

	public String getArticle() {
		return article;
	}

	public boolean getInUse() {
		return inUse;
	}

	@Override
	public String toString() {
		return "AdminDropmenuDetails{" + "id=" + id + ", dropMenu=" + (dropMenu != null ? dropMenu.toString() : "null")
				+ ", title='" + title + ", article='" + article +  ", inUse=" + inUse + '}';
	}

	AdminDropmenuDetails(Builder builder) {
		this.id = builder.id;
		this.dropMenu = builder.dropMenu;
		this.title = builder.title;
		this.article = builder.article;
		this.inUse = builder.inUse;
	}

	public static class Builder {

		private int id;
		private AdminDropMenu dropMenu;
		private String title;
		private String article;
		private boolean inUse;

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder adminDropMenu(AdminDropMenu dropMenu) {
			this.dropMenu = dropMenu;
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

		public Builder inUse(boolean inUse) {
			this.inUse = inUse;
			return this;
		}

		public AdminDropmenuDetails build() {
			return new AdminDropmenuDetails(this);
		}
	}

}
