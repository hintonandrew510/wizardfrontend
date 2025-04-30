package web.page.planproposedpage;

public class PlanProposedPageModel {
	private String planACity;
	private String planAReach;
	private String planAFrequency;
	private String planADigitalImpressionsMonthly;
	private String planAMonthly;
	private String planADaily;

	public PlanProposedPageModel(String planACity, String planAReach, String planAFrequency,
			String planADigitalImpressionsMonthly, String planAMonthly, String planADaily) {
		super();
		this.planACity = planACity;
		this.planAReach = planAReach;
		this.planAFrequency = planAFrequency;
		this.planADigitalImpressionsMonthly = planADigitalImpressionsMonthly;
		this.planAMonthly = planAMonthly;
		this.planADaily = planADaily;
	}

	public String getPlanACity() {
		return planACity;
	}

	public void setPlanACity(String planACity) {
		this.planACity = planACity;
	}

	public String getPlanAReach() {
		return planAReach;
	}

	public void setPlanAReach(String planAReach) {
		this.planAReach = planAReach;
	}

	public String getPlanAFrequency() {
		return planAFrequency;
	}

	public void setPlanAFrequency(String planAFrequency) {
		this.planAFrequency = planAFrequency;
	}

	public String getPlanADigitalImpressionsMonthly() {
		return planADigitalImpressionsMonthly;
	}

	public void setPlanADigitalImpressionsMonthly(String planADigitalImpressionsMonthly) {
		this.planADigitalImpressionsMonthly = planADigitalImpressionsMonthly;
	}

	public String getPlanAMonthly() {
		return planAMonthly;
	}

	public void setPlanAMonthly(String planAMonthly) {
		this.planAMonthly = planAMonthly;
	}

	public String getPlanADaily() {
		return planADaily;
	}

	public void setPlanADaily(String planADaily) {
		this.planADaily = planADaily;
	}

}
