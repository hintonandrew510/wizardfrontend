package web.google.slide;

import java.util.ArrayList;
import java.util.List;

import com.google.api.services.slides.v1.model.Request;

public class ClientObjectivesOneSlide implements SlideInterface {

	@Override
	public List<Request> updateSlide(SlideData slideData) {
		Request request = new Request();
		List<Request> requests = new ArrayList();
		requests.add(request);
		return requests;
	}

}
