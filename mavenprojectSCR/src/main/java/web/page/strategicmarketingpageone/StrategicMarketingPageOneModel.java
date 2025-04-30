package web.page.strategicmarketingpageone;

public class StrategicMarketingPageOneModel {
	public StrategicMarketingPageOneModel(int yearsInBusiness, int numberOfLocations, boolean planToExpand,
			String misconceptions, String sellingAdvantages, String companyNameProjectImage,
			String currentCompanySlogan, boolean companySloganProjectImageYes) {
		super();
		this.yearsInBusiness = yearsInBusiness;
		this.numberOfLocations = numberOfLocations;
		this.planToExpand = planToExpand;
		this.misconceptions = misconceptions;
		this.sellingAdvantages = sellingAdvantages;
		this.companyNameProjectImage = companyNameProjectImage;
		this.currentCompanySlogan = currentCompanySlogan;
		this.companySloganProjectImageYes = companySloganProjectImageYes;
	}

	private int yearsInBusiness;
	private int numberOfLocations;
	private boolean planToExpand;
	private String misconceptions;
	private String sellingAdvantages;
	private String companyNameProjectImage;
	private String currentCompanySlogan;

	public int getYearsInBusiness() {
		return yearsInBusiness;
	}

	public void setYearsInBusiness(int yearsInBusiness) {
		this.yearsInBusiness = yearsInBusiness;
	}

	public int getNumberOfLocations() {
		return numberOfLocations;
	}

	public void setNumberOfLocations(int numberOfLocations) {
		this.numberOfLocations = numberOfLocations;
	}

	public boolean isPlanToExpand() {
		return planToExpand;
	}

	public void setPlanToExpand(boolean planToExpand) {
		this.planToExpand = planToExpand;
	}

	public String getMisconceptions() {
		return misconceptions;
	}

	public void setMisconceptions(String misconceptions) {
		this.misconceptions = misconceptions;
	}

	public String getSellingAdvantages() {
		return sellingAdvantages;
	}

	public void setSellingAdvantages(String sellingAdvantages) {
		this.sellingAdvantages = sellingAdvantages;
	}

	public String getCompanyNameProjectImage() {
		return companyNameProjectImage;
	}

	public void setCompanyNameProjectImage(String companyNameProjectImage) {
		this.companyNameProjectImage = companyNameProjectImage;
	}

	public String getCurrentCompanySlogan() {
		return currentCompanySlogan;
	}

	public void setCurrentCompanySlogan(String currentCompanySlogan) {
		this.currentCompanySlogan = currentCompanySlogan;
	}

	public boolean isCompanySloganProjectImageYes() {
		return companySloganProjectImageYes;
	}

	public void setCompanySloganProjectImageYes(boolean companySloganProjectImageYes) {
		this.companySloganProjectImageYes = companySloganProjectImageYes;
	}

	private boolean companySloganProjectImageYes;

}
