package ca.http.myservlet.bean;

public class User {

	private int id;
	private String login;
	private String password;

	User(Builder builder) {
		this.id = builder.id;
		this.login = builder.login;
		this.password = builder.password;
	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
	
	public void print(User user) {
		System.out.println("id : "+ user.getId() + " login : " + user.getLogin() + " password : " + user.getPassword());
	}

	public static class Builder {
		private int id;
		private String login;
		private String password;

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder login(String login) {
			this.login = login;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
