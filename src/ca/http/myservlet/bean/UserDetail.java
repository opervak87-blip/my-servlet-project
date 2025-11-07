package ca.http.myservlet.bean;

public class UserDetail {

	private int id;
	private String lastName;
	private String firstName;
	private String middleName;
	private String phone;
	private User user;
	private Address address;

	private UserDetail(Builder builder) {
		this.id = builder.id;
		this.lastName = builder.lastName;
		this.firstName = builder.firstName;
		this.middleName = builder.middleName;
		this.phone = builder.phone;
		this.user = builder.user;
		this.address = builder.address;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getPhone() {
		return phone;
	}

	public User getUser() {
		return user;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "UserDetail{" + "id=" + id + ", lastName='" + lastName + '\'' + ", firstName='" + firstName + '\''
				+ ", middleName='" + middleName + '\'' + ", phone='" + phone + '\'' + ", user=" + user + ", address="
				+ address + '}';
	}

	public static class Builder {
		private int id;
		private String lastName;
		private String firstName;
		private String middleName;
		private String phone;
		private User user;
		private Address address;

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder middleName(String middleName) {
			this.middleName = middleName;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder user(User user) {
			this.user = user;
			return this;
		}

		public Builder address(Address address) {
			this.address = address;
			return this;
		}

		public UserDetail build() {
			return new UserDetail(this);
		}
	}

}
