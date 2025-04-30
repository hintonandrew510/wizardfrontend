package web.page.marketplacecompetitionpage;

public class MarketPlaceCompetitionPageModel {

	public MarketPlaceCompetitionPageModel(String firstTierBusiness, String secondTierBusiness,
			String thirdTierBusiness, String fourthTierBusiness, String competitionA, String competitionB,
			String competitionStrengthA, String competitionStrengthB, String competitionWeaknessA,
			String competitionWeaknessB) {
		super();
		this.firstTierBusiness = firstTierBusiness;
		this.secondTierBusiness = secondTierBusiness;
		this.thirdTierBusiness = thirdTierBusiness;
		this.fourthTierBusiness = fourthTierBusiness;
		this.competitionA = competitionA;
		this.competitionB = competitionB;
		this.competitionStrengthA = competitionStrengthA;
		this.competitionStrengthB = competitionStrengthB;
		this.competitionWeaknessA = competitionWeaknessA;
		this.competitionWeaknessB = competitionWeaknessB;
	}

	public String getFirstTierBusiness() {
		return firstTierBusiness;
	}

	public void setFirstTierBusiness(String firstTierBusiness) {
		firstTierBusiness = firstTierBusiness;
	}

	public String getSecondTierBusiness() {
		return secondTierBusiness;
	}

	public void setSecondTierBusiness(String secondTierBusiness) {
		secondTierBusiness = secondTierBusiness;
	}

	private String firstTierBusiness;
	private String secondTierBusiness;
	private String thirdTierBusiness;
	private String fourthTierBusiness;
	private String competitionA;
	private String competitionB;
	private String competitionStrengthA;
	private String competitionStrengthB;
	private String competitionWeaknessA;
	private String competitionWeaknessB;

	public String getThirdTierBusiness() {
		return thirdTierBusiness;
	}

	public void setThirdTierBusiness(String thirdTierBusiness) {
		this.thirdTierBusiness = thirdTierBusiness;
	}

	public String getFourthTierBusiness() {
		return fourthTierBusiness;
	}

	public void setFourthTierBusiness(String fourthTierBusiness) {
		this.fourthTierBusiness = fourthTierBusiness;
	}

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

}
