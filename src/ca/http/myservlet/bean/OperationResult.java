package ca.http.myservlet.bean;

public class OperationResult<T> {

	private String message;
	private boolean isSuccessful;
	private T data;

	OperationResult (Builder<T> builder) {
		this.message = builder.message;
		this.isSuccessful = builder.isSuccessful;
		this.data = builder.data;
	}

	public String getMessage() {
		return message;
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}
	
	public T getData() {
		return data;
	}


	@Override
	public String toString() {
		return "RegistrationResult{" + "message='" + message +  ", isSuccessful="
				+ isSuccessful + "data='" + (data != null ? data.toString() : "null") +'}';
	}

	public static class Builder<T> {

		private String message;
		private boolean isSuccessful;
		private T data;

		public Builder<T> message(String message) {
			this.message = message;
			return this;
		}


		public Builder<T> isSuccessful(boolean isSuccessful) {
			this.isSuccessful = isSuccessful;
			return this;
		}
		
		public Builder<T> data(T data) {
			this.data = data;
			return this;
		}

		public OperationResult<T>  build() {
			return new OperationResult<>(this);
		}

	}

}
