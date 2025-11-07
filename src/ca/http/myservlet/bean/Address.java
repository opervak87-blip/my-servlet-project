package ca.http.myservlet.bean;

public class Address {

	private int id;
	private String streetNumber;
	private String streetName;
	private String apartmentNumber;
	private String postalCode;
	private City city;

	Address(Builder builder) {
		this.id = builder.id;
		this.streetNumber = builder.streetNumber;
		this.streetName = builder.streetName;
		this.apartmentNumber = builder.apartmentNumber;
		this.postalCode = builder.postalCode;
		this.city = builder.city;
	}

	public int getId() {
		return id;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public City getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Address{" + "id=" + id + ", streetNumber='" + streetNumber + '\'' + ", streetName='" + streetName + '\''
				+ ", apartmentNumber='" + apartmentNumber + '\'' + ", postalCode='" + postalCode + '\'' + ", city="
				+ city + '}';
	}

	public static class Builder {
		private int id;
		private String streetNumber;
		private String streetName;
		private String apartmentNumber;
		private String postalCode;
		private City city;

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder streetNumber(String streetNumber) {
			this.streetNumber = streetNumber;
			return this;
		}

		public Builder streetName(String streetName) {
			this.streetName = streetName;
			return this;
		}

		public Builder apartmentNumber(String apartmentNumber) {
			this.apartmentNumber = apartmentNumber;
			return this;
		}

		public Builder postalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public Builder city(City city) {
			this.city = city;
			return this;
		}

		public Address builder() {
			return new Address(this);
		}
	}

}
