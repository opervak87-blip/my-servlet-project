package ca.http.myservlet.bean;

public class RegistrationResult {

	private String message;
	private String path;
	private boolean isSuccessful;

	RegistrationResult(Builder builder) {
		this.message = builder.message;
		this.path = builder.path;
		this.isSuccessful = builder.isSuccessful;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "RegistrationResult{" + "message='" + message + '\'' + "path='" + path + '\'' + ", isSuccessful="
				+ isSuccessful + '}';
	}

	public static class Builder {

		private String message;
		private boolean isSuccessful;
		private String path;

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public Builder path(String path) {
			this.path = path;
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
