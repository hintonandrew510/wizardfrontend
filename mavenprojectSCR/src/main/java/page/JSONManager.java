package web.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import web.google.slide.GoogleHelper;

public class JSONManager {
	private static Gson gson = new Gson();
	private static final Logger mLog = LoggerFactory.getLogger(JSONManager.class.getName());


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
			mLog.error("ERROR CONVERTING FROM JSON STRING TO CLASS " + pageModelClass.getCanonicalName());
			mLog.error("ERROR CONVERTING FROM JSON " + json);
		}
		return pageModelObject;
	}

}
