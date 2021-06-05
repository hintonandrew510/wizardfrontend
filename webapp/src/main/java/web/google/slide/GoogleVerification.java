package web.google.slide;

public class GoogleVerification {
	private String clientSecretsStr="";
	private String accessToken="";
	private String email="";
	private String newFileId="";
	private String newFileName="";
	private String driveStr="";
	public String getClientSecretsStr() {
		return clientSecretsStr;
	}
	public void setClientSecretsStr(String clientSecretsStr) {
		this.clientSecretsStr = clientSecretsStr;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNewFileId() {
		return newFileId;
	}
	public void setNewFileId(String newFileId) {
		this.newFileId = newFileId;
	}
	public String getNewFileName() {
		return newFileName;
	}
	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}
	public String getDriveStr() {
		return driveStr;
	}
	public void setDriveStr(String driveStr) {
		this.driveStr = driveStr;
	}
}
