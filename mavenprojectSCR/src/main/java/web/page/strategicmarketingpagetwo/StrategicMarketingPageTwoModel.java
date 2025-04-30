package web.page.strategicmarketingpagetwo;

public class StrategicMarketingPageTwoModel {
	private String competitionA;
	private String competitionB;
	private String competitionStrengthA;

	public StrategicMarketingPageTwoModel(String competitionA, String competitionB, String competitionStrengthA,
			String competitionStrengthB, String competitionWeaknessA, String competitionWeaknessB,
			String companyNameProjectImage, String currentCompanySlogan, boolean companySloganProjectImage) {
		super();
		this.competitionA = competitionA;
		this.competitionB = competitionB;
		this.competitionStrengthA = competitionStrengthA;
		this.competitionStrengthB = competitionStrengthB;
		this.competitionWeaknessA = competitionWeaknessA;
		this.competitionWeaknessB = competitionWeaknessB;
		this.companyNameProjectImage = companyNameProjectImage;
		this.currentCompanySlogan = currentCompanySlogan;
		this.companySloganProjectImage = companySloganProjectImage;
	}

	private String competitionStrengthB;
	private String competitionWeaknessA;
	private String competitionWeaknessB;
	private String companyNameProjectImage;
	private String currentCompanySlogan;

	public String getCompetitionA() {
		return competitionA;
	}

	public void setCompetitionA(String competitionA) {
		this.competitionA = competitionA;
	}

	public String getCompetitionB() {
		return competitionB;
	}

	public void setCompetitionB(String competitionB) {
		this.competitionB = competitionB;
	}

	public String getCompetitionStrengthA() {
		return competitionStrengthA;
	}

	public void setCompetitionStrengthA(String competitionStrengthA) {
		this.competitionStrengthA = competitionStrengthA;
	}

	public String getCompetitionStrengthB() {
		return competitionStrengthB;
	}

	public void setCompetitionStrengthB(String competitionStrengthB) {
		this.competitionStrengthB = competitionStrengthB;
	}

	public String getCompetitionWeaknessA() {
		return competitionWeaknessA;
	}

	public void setCompetitionWeaknessA(String competitionWeaknessA) {
		this.competitionWeaknessA = competitionWeaknessA;
	}

	public String getCompetitionWeaknessB() {
		return competitionWeaknessB;
	}

	public void setCompetitionWeaknessB(String competitionWeaknessB) {
		this.competitionWeaknessB = competitionWeaknessB;
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

	public boolean isCompanySloganProjectImage() {
		return companySloganProjectImage;
	}

	public void setCompanySloganProjectImage(boolean companySloganProjectImage) {
		this.companySloganProjectImage = companySloganProjectImage;
	}

	private boolean companySloganProjectImage;

}
