package web.google.slide;

public class ErrorSessionHelper {
	private static GoogleErrorModel sGoogleErrorModel;
	private static boolean available = false;
	public static void setGoogleErromModel(GoogleErrorModel googleErrorModel) {
		available = true;
		sGoogleErrorModel = googleErrorModel;
	}
	public static GoogleErrorModel getGoogleErrorModel() {
		return sGoogleErrorModel;
	}
	public static boolean isAvailable() {
        return available;
    }

}
