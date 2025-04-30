package web.page.presentedtopage;

public class PresentedToPageModel {

	public PresentedToPageModel(String portfolioPhoneNumber, String portfolioManagerName, String clientBusinessName,
			String clientContactName, String station) {
		super();
		this.portfolioPhoneNumber = portfolioPhoneNumber;
		this.portfolioManagerName = portfolioManagerName;
		this.clientBusinessName = clientBusinessName;
		this.clientContactName = clientContactName;
		this.station = station;
	}

	private String portfolioPhoneNumber;

	public String getPortfolioPhoneNumber() {
		return portfolioPhoneNumber;
	}

	public void setPortfolioPhoneNumber(String portfolioPhoneNumber) {
		this.portfolioPhoneNumber = portfolioPhoneNumber;
	}

	private String portfolioManagerName;
	private String clientBusinessName;
	private String clientContactName;

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	private String station;

	public String getPortfolioManagerName() {
		return portfolioManagerName;
	}

	public void setPortfolioManagerName(String portfolioManagerName) {
		this.portfolioManagerName = portfolioManagerName;
	}

	public String getClientBusinessName() {
		return clientBusinessName;
	}

	public void setClientBusinessName(String clientBusinessName) {
		this.clientBusinessName = clientBusinessName;
	}

	public String getClientContactName() {
		return clientContactName;
	}

	public void setClientContactName(String clientContactName) {
		this.clientContactName = clientContactName;
	}

}
