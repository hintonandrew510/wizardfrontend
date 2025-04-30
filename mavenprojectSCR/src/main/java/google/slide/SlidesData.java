package web.google.slide;
import java.util.List;

import web.page.Publish;

public class SlidesData {
	private PageModels pageModels = new PageModels();
	private Publish publish = new Publish();
	public PageModels getPageModels() {
		return pageModels;
	}
	public void setPageModels(PageModels pageModels) {
		this.pageModels = pageModels;
	}
	public Publish getPublish() {
		return publish;
	}
	public void setPublish(Publish publish) {
		this.publish = publish;
	}
	
	
	

}
