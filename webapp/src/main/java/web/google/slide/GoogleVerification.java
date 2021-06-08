package web.google.slide;

public class GoogleVerification {
	private String clientSecretsStr="";
	private String accessToken="";
	private String email="";
	private boolean hasEmail;
	private boolean hasAccessToken;
	public boolean isHasAccessToken() {
		if (!this.accessToken.equals("")) {
			hasAccessToken = true;
		}
		return hasAccessToken;
	}
	public void setHasAccessToken(boolean hasAccessToken) {
		
		this.hasAccessToken = hasAccessToken;
	}
	public boolean isHasEmail() {
		if (!this.email.equals("")) {
			hasEmail = true;
		}
		return hasEmail;
	}
	public void setHasEmail(boolean hasEmail) {
		this.hasEmail = hasEmail;
	}
	private String comments="";
	private boolean hasComments;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public boolean isHasComments() {
		if (!this.comments.equals("")) {
			hasComments = true;
		}
		return hasComments;
	}
	public void setHasComments(boolean hasComments) {
		this.hasComments = hasComments;
	}
	private String newFileId="";
	private String newFileName="";
	private String driveStr="";
	private boolean canAccessGoogleDrive;
	
	public boolean isCanAccessGoogleDrive() {
		if (!this.newFileId.equals("")) {
			canAccessGoogleDrive = true;
		}
		return canAccessGoogleDrive;
	}
	public void setCanAccessGoogleDrive(boolean canAccessGoogleDrive) {
		this.canAccessGoogleDrive = canAccessGoogleDrive;
	}
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
