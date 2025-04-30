package web.google.slide;

public class GoogleErrorModel {
	private StringBuffer stringbufferError  = new StringBuffer();
	public final static String NAME = "GoogleErrorHelper";
	private String error;
	public String getError() {
		
		return error;
	}
	public void setError(String error) {
		this.error = this.stringbufferError.append(error).toString();
		
	}

}
