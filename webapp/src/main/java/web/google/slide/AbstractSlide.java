package web.google.slide;

public abstract class AbstractSlide implements SlideInterface {
	private SlidesData mSlidesData;
	public SlidesData getmSlidesData() {
		return mSlidesData;
	}
	public void setmSlidesData(SlidesData mSlidesData) {
		this.mSlidesData = mSlidesData;
	}
	public AbstractSlide(SlidesData slidesData) {
		mSlidesData = slidesData;
	}

}
