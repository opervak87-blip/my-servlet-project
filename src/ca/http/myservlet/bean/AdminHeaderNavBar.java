package ca.http.myservlet.bean;

public class AdminHeaderNavBar {

	private int id;
	private String title;
	private boolean inUse;

	AdminHeaderNavBar(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.inUse = builder.inUse;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public boolean getInUse() {
		return inUse;
	}

	@Override
	public String toString() {
		return "AdminHeaderNavBar{" + "id=" + id + ", title='" + title  + ", inUse=" + inUse + '}';
	}

	public static class Builder {
		private int id;
		private String title;
		private boolean inUse;

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder inUse(boolean inUse) {
			this.inUse = inUse;
			return this;
		}

		public AdminHeaderNavBar build() {
			return new AdminHeaderNavBar(this);
		}
	}

}
