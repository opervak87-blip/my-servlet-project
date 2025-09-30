package ca.http.myservlet.bean;

public class Breadcrumb {

	private String label;
	private String url;
	
	public Breadcrumb (Builder builder) {
		this.label = builder.label;
		this.url = builder.url;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String getUrl() {
		return url;
	}
	
	@Override
    public String toString() {
        return "Breadcrumb{" +
                "label='" + label + 
                ", url='" + url + 
                '}';
    }
	public static class Builder{
		
		private String label;
		private String url;
		
		public Builder label(String label) {
			this.label = label;
			return this;
		}
		
		public Builder url(String url) {
			this.url = url;
			return this;
		}
		
		public Breadcrumb build() {
			return new Breadcrumb(this);
		}
	}

}
