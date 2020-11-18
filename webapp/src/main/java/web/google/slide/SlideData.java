package web.google.slide;

import java.util.List;

public class SlideData {
	public boolean includeSlide;
	public List<Object> pageData;
	
	
	public SlideData(boolean includeSlide, List<Object> pageData) {
		super();
		this.includeSlide = includeSlide;
		this.pageData = pageData;
	}
	public boolean isIncludeSlide() {
		return includeSlide;
	}
	public void setIncludeSlide(boolean includeSlide) {
		this.includeSlide = includeSlide;
	}
	public List<Object> getPageData() {
		return pageData;
	}
	public void setPageData(List<Object> pageData) {
		this.pageData = pageData;
	}

}
