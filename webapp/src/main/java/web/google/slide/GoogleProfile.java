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
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	private String sheetsId;
	private String clientId;
	private String projectId;
	private String clientsecret;
	public String getClientsecret() {
		return clientsecret;
	}
	public void setClientsecret(String clientsecret) {
		this.clientsecret = clientsecret;
	}
	public GoogleProfile(String slidesId, String sheetsId, String clientId, String projectId, String clientsecret) {
		super();
		this.slidesId = slidesId;
		this.sheetsId = sheetsId;
		this.clientId = clientId;
		this.projectId = projectId;
		this.clientsecret = clientsecret;
	}

}