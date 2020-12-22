package web.google.slide;

public class GoogleProfile {
	private String slidesId;
	public String getSlidesId() {
		return slidesId;
	}
	public void setSlidesId(String slidesId) {
		this.slidesId = slidesId;
	}
	public String getSheetsId() {
		return sheetsId;
	}
	public void setSheetsId(String sheetsId) {
		this.sheetsId = sheetsId;
	}


	private String sheetsId;
	
	private String generatedFolderId;
	public String getGeneratedFolderId() {
		return generatedFolderId;
	}
	public void setGeneratedFolderId(String generatedFolderId) {
		this.generatedFolderId = generatedFolderId;
	}
	
	
	public GoogleProfile(String slidesId, 
			String sheetsId,String generatedFolderId) {
		super();
		this.slidesId = slidesId;
		this.sheetsId = sheetsId;
		
		this.generatedFolderId = generatedFolderId;
	}

}
