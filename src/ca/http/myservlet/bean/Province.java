package ca.http.myservlet.bean;

public class Province {
	
	private int id;
	private String nameOfProvince;
	private String shortNameOfProvince;
	
	Province (Builder builder){
		this.id = builder.id;
		this.nameOfProvince = builder.nameOfProvince;
		this.shortNameOfProvince = builder.shortNameOfProvince;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getNameOfProvince() {
		return nameOfProvince;
	}
	
	public String getShortNameOfProvince() {
		return shortNameOfProvince;
	}
	
	@Override
	public String toString() {
	    return "Province{" +
	           "id=" + id +
	           ", nameOfProvince='" + nameOfProvince + '\'' +
	           ", shortNameOfProvince='" + shortNameOfProvince + '\'' +
	           '}';
	}
	
	public static class Builder{
		
		private int id;
		private String nameOfProvince;
		private String shortNameOfProvince;
		
		public Builder id (int id) {
			this.id = id;
			return this;
		}
		
		public Builder nameOfProvince(String nameOfProvince) {
			this.nameOfProvince = nameOfProvince;
			return this;
		}
		
		public Builder shortNameOfProvince(String shortNameOfProvince) {
			this.shortNameOfProvince = shortNameOfProvince;
			return this;
		}
		
		public Province builder() {
			return new Province(this);
		}
	}

}
