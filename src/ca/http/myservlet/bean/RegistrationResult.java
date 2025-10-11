package ca.http.myservlet.bean;

public class RegistrationResult {

	private String message;
	private boolean isSuccessful;

	RegistrationResult(Builder builder) {
		this.message = builder.message;
		this.isSuccessful = builder.isSuccessful;
	}

	public String getMessage() {
		return message;
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	@Override
	public String toString() {
	    return "RegistrationResult{" +
	            "message='" + message + '\'' +
	            ", isSuccessful=" + isSuccessful +
	            '}';
	} 
	
	public static class Builder {

		private String message;
		private boolean isSuccessful;

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public Builder isSuccessful(boolean isSuccessful) {
			this.isSuccessful = isSuccessful;
			return this;
		}

		public RegistrationResult build() {
			return new RegistrationResult(this);
		}

	}

}
