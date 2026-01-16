package ca.http.myservlet.bean.dto;

import java.util.List;

public class RegistrationRequestDTO {
	
		private String email;
	    private String password;
	    private String login;
	    private String firstName;
	    private String lastName;
	    private String middleName;
	    private String streetNumber;
	    private String streetName;
	    private String apartmentNumber;
	    private String provinceId;
	    private String cityId;
	    private String postalCode;
	    private String phone;
	    private List<String> roles;
	    
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getStreetNumber() {
			return streetNumber;
		}
		public void setStreetNumber(String streetNumber) {
			this.streetNumber = streetNumber;
		}
		public String getStreetName() {
			return streetName;
		}
		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}
		public String getApartmentNumber() {
			return apartmentNumber;
		}
		public void setApartmentNumber(String apartmentNumber) {
			this.apartmentNumber = apartmentNumber;
		}
		public String getProvinceId() {
			return provinceId;
		}
		public void setProvinceId(String provinceId) {
			this.provinceId = provinceId;
		}
		public String getCityId() {
			return cityId;
		}
		public void setCityId(String cityId) {
			this.cityId = cityId;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public List<String> getRoles() {
			return roles;
		}
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
		@Override
		public String toString() {
			return "RegistrationRequestDTO [email=" + email + ", password=" + password + ", login=" + login
					+ ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
					+ ", streetNumber=" + streetNumber + ", streetName=" + streetName + ", apartmentNumber="
					+ apartmentNumber + ", provinceId=" + provinceId + ", cityId=" + cityId + ", postalCode="
					+ postalCode + ", phone=" + phone + ", roles=" + roles + "]";
		}
	    
	    
	
}
