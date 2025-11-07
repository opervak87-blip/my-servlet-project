package ca.http.myservlet.bean;

public class City {
	
	private int id;
	private String nameOfCity;
	private Province province;
	
	City(Builder builder){
		this.id = builder.id;
		this.nameOfCity = builder.nameOfCity;
		this.province = builder.province;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNameOfCity() {
		return nameOfCity;
	}
	
	public Province getProvince() {
		return province;
	}
	
	@Override
	public String toString() {
	    return "City{" +
	           "id=" + id +
	           ", nameOfCity='" + nameOfCity + '\'' +
	           ", province=" + (province != null ? province.toString() : "null") +
	           '}';
	}
	
	public static class Builder{
		
		private int id;
		private String nameOfCity;
		private Province province;
		
		public Builder id(int id) {
			this.id = id;
			return this;
		}
		
		public Builder nameOfCity(String nameOfCity) {
			this.nameOfCity = nameOfCity;
			return this;
		}
		
		public Builder province(Province province) {
			this.province = province;
			return this;
		}
		
		public City builder() {
			return new City(this);
		}
	}

}
