package ca.http.myservlet.bean;

public class AdminDropMenu {

	private int id;
	private AdminHeaderNavBar adminNavBar;
	private String title;
	private boolean inUse;

	AdminDropMenu(Builder builder) {
		this.id = builder.id;
		this.adminNavBar = builder.adminNavBar;
		this.title = builder.title;
		this.inUse = builder.inUse;
	}

	public int getId() {
		return id;
	}

	public AdminHeaderNavBar getAdminHeaderNavBar() {
		return adminNavBar;
	}

	public String getTitle() {
		return title;
	}

	public boolean getInUse() {
		return inUse;
	}

	@Override
	public String toString() {
		return "AdminDropMenu{" + "id=" + id + ", adminNavBar="
				+ (adminNavBar != null ? adminNavBar.toString() : "null") + ", title='" + title + ", inUse=" + inUse
				+ '}';
	}

	public static class Builder {

		private int id;
		private AdminHeaderNavBar adminNavBar;
		private String title;
		private boolean inUse;

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder AdminHeaderNavBar(AdminHeaderNavBar adminNavBar) {
			this.adminNavBar = adminNavBar;
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

		public AdminDropMenu build() {
			return new AdminDropMenu(this);
		}
	}

}
