package ca.http.myservlet.bean;

import java.util.List;

public class User {

	private int id;
	private String fullName;
	private String email;
	private String login;
	private String password;
	private boolean isActive;
	private UserDetail userDetail;
	private List<String> roles;

	User(Builder builder) {
		this.id = builder.id;
		this.email = builder.email;
		this.fullName = builder.fullName;
		this.login = builder.login;
		this.password = builder.password;
		this.isActive = builder.isActive;
		this.roles = builder.roles;
		this.userDetail = builder.userDetail;
	}

	public int getId() {
		return id;
	}
	
	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
	
	public UserDetail getUserDetail() {
		return userDetail;
	}
	
	public boolean getIsActive() {
		return isActive;
	}
	
	public List<String> getRoles(){
		return roles;
	}
	
	@Override
	public String toString() {
	    return "User{" +
	            "id=" + id +
	            ", fullName='" + fullName + '\'' +
	            ", email='" + email + '\'' +
	            ", login='" + login + '\'' +
	            ", password='" + (password != null ? "****" : null) + '\'' +
	            ", isActive=" + isActive +
	            ", roles=" + (roles != null ? roles : "[]") +
	            ", userDetail=" + (userDetail != null ? userDetail.toString() : "[]") +
	            '}';
	}

	public static class Builder {
		private int id;
		private String fullName;
		private String email;
		private String login;
		private String password;
		private UserDetail userDetail;
		private boolean isActive;
		private List<String> roles;

		public Builder id(int id) {
			this.id = id;
			return this;
		}
		
		public Builder fullName(String fullName) {
			this.fullName = fullName;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
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
		
		public Builder userDetail(UserDetail userDetail) {
			this.userDetail = userDetail;
			return this;
		}
		
		public Builder isActive(boolean isActive) {
			this.isActive = isActive;
			return this;
		}
		
		public Builder roles(List<String> roles) {
			this.roles = roles;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
