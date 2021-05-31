package web.google.slide;

public class GoogleErrorModel {
	private StringBuffer stringbufferError  = new StringBuffer();
	public final static String NAME = "GoogleErrorHelper";
	private String error;
	public String getError() {
		return stringbufferError.toString();
	}
	public void setError(String error) {
		
		this.stringbufferError.append(error);
	}

}
