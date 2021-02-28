package web.page;

import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import web.google.slide.GoogleHelper;

public class JSONManager {
	private static Gson gson = new Gson();
	private static final Logger mLog = Logger.getLogger(JSONManager.class.getName());


	public static String convertToJson(Object pageModel) {

		String json = null;
		// convert map to JSON String
		// .json.gson.
		json = gson.toJson(pageModel);
		return json;
	}

	public static Object convertFromJson(String json, Class pageModelClass) {

		Gson gson = new GsonBuilder().create();
		Object pageModelObject = null;
		// convert map to JSON String
		try {
		   pageModelObject = gson.fromJson(json, pageModelClass);
		} catch (Exception ex) {
			mLog.severe("ERROR CONVERTING FROM JSON STRING TO CLASS " + pageModelClass.getCanonicalName());
			mLog.severe("ERROR CONVERTING FROM JSON " + json);
		}
		return pageModelObject;
	}

}
