package web.google.slide;

import java.util.List;

import com.google.api.services.slides.v1.model.Request;

public interface SlideInterface {
        public List<Request> updateSlide(SlideData slideData);
}
