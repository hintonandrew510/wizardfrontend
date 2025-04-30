package web.page.planalifetimevaluedpage;

public class PlanALifetimeValuedPageModel {
	private String averageSale;
	private String grossProfitMargin;
	private String averageRepeatSales;
	private String yearsOfPatronage;

	private String grossProfitPerSale;
	private String averageCustomerValue;
	private String lifetimeValuePerCustomer;

	private String monthlyInvestmentAverage;
	private String prospectsNeededToBreakEven;

	public PlanALifetimeValuedPageModel(String averageSale, String grossProfitMargin, String averageRepeatSales,
			String yearsOfPatronage, String grossProfitPerSale, String averageCustomerValue,
			String lifetimeValuePerCustomer, String monthlyInvestmentAverage, String prospectsNeededToBreakEven) {
		super();
		this.averageSale = averageSale;
		this.grossProfitMargin = grossProfitMargin;
		this.averageRepeatSales = averageRepeatSales;
		this.yearsOfPatronage = yearsOfPatronage;
		this.grossProfitPerSale = grossProfitPerSale;
		this.averageCustomerValue = averageCustomerValue;
		this.lifetimeValuePerCustomer = lifetimeValuePerCustomer;
		this.monthlyInvestmentAverage = monthlyInvestmentAverage;
		this.prospectsNeededToBreakEven = prospectsNeededToBreakEven;
	}

	public String getAverageSale() {
		return averageSale;
	}

	public void setAverageSale(String averageSale) {
		this.averageSale = averageSale;
	}

	public String getGrossProfitMargin() {
		return grossProfitMargin;
	}

	public void setGrossProfitMargin(String grossProfitMargin) {
		this.grossProfitMargin = grossProfitMargin;
	}

	public String getAverageRepeatSales() {
		return averageRepeatSales;
	}

	public void setAverageRepeatSales(String averageRepeatSales) {
		this.averageRepeatSales = averageRepeatSales;
	}

	public String getYearsOfPatronage() {
		return yearsOfPatronage;
	}

	public void setYearsOfPatronage(String yearsOfPatronage) {
		this.yearsOfPatronage = yearsOfPatronage;
	}

	public String getGrossProfitPerSale() {
		return grossProfitPerSale;
	}

	public void setGrossProfitPerSale(String grossProfitPerSale) {
		this.grossProfitPerSale = grossProfitPerSale;
	}

	public String getAverageCustomerValue() {
		return averageCustomerValue;
	}

	public void setAverageCustomerValue(String averageCustomerValue) {
		this.averageCustomerValue = averageCustomerValue;
	}

	public String getLifetimeValuePerCustomer() {
		return lifetimeValuePerCustomer;
	}

	public void setLifetimeValuePerCustomer(String lifetimeValuePerCustomer) {
		this.lifetimeValuePerCustomer = lifetimeValuePerCustomer;
	}

	public String getMonthlyInvestmentAverage() {
		return monthlyInvestmentAverage;
	}

	public void setMonthlyInvestmentAverage(String monthlyInvestmentAverage) {
		this.monthlyInvestmentAverage = monthlyInvestmentAverage;
	}

	public String getProspectsNeededToBreakEven() {
		return prospectsNeededToBreakEven;
	}

	public void setProspectsNeededToBreakEven(String prospectsNeededToBreakEven) {
		this.prospectsNeededToBreakEven = prospectsNeededToBreakEven;
	}

}
