package web.page.teamcommitmentpage;

public class TeamCommitmentPageModel {
	private String topLevelName;
	private String topLevelTitle;
	private String secondLevelName;
	private String secondLevelTitle;
	private String thirdLevelName;
	private String thirdLevelTitle;
	private String fourthLevelName;
	private String fourthLevelTitle;

	public TeamCommitmentPageModel(String topLevelName, String topLevelTitle, String secondLevelName,
			String secondLevelTitle, String thirdLevelName, String thirdLevelTitle, String fourthLevelName,
			String fourthLevelTitle) {
		super();
		this.topLevelName = topLevelName;
		this.topLevelTitle = topLevelTitle;
		this.secondLevelName = secondLevelName;
		this.secondLevelTitle = secondLevelTitle;
		this.thirdLevelName = thirdLevelName;
		this.thirdLevelTitle = thirdLevelTitle;
		this.fourthLevelName = fourthLevelName;
		this.fourthLevelTitle = fourthLevelTitle;
	}

	public String getTopLevelName() {
		return topLevelName;
	}

	public void setTopLevelName(String topLevelName) {
		this.topLevelName = topLevelName;
	}

	public String getTopLevelTitle() {
		return topLevelTitle;
	}

	public void setTopLevelTitle(String topLevelTitle) {
		this.topLevelTitle = topLevelTitle;
	}

	public String getSecondLevelName() {
		return secondLevelName;
	}

	public void setSecondLevelName(String secondLevelName) {
		this.secondLevelName = secondLevelName;
	}

	public String getSecondLevelTitle() {
		return secondLevelTitle;
	}

	public void setSecondLevelTitle(String secondLevelTitle) {
		this.secondLevelTitle = secondLevelTitle;
	}

	public String getThirdLevelName() {
		return thirdLevelName;
	}

	public void setThirdLevelName(String thirdLevelName) {
		this.thirdLevelName = thirdLevelName;
	}

	public String getThirdLevelTitle() {
		return thirdLevelTitle;
	}

	public void setThirdLevelTitle(String thirdLevelTitle) {
		this.thirdLevelTitle = thirdLevelTitle;
	}

	public String getFourthLevelName() {
		return fourthLevelName;
	}

	public void setFourthLevelName(String fourthLevelName) {
		this.fourthLevelName = fourthLevelName;
	}

	public String getFourthLevelTitle() {
		return fourthLevelTitle;
	}

	public void setFourthLevelTitle(String fourthLevelTitle) {
		this.fourthLevelTitle = fourthLevelTitle;
	}

}
