package web.page.targetmarketingpage;

public class TargetMarketingHeaderRow {

	private String rowStatus = "unknown";

	public String getRowStatus() {
		return rowStatus;
	}

	public void setRowStatus(String rowStatus) {
		this.rowStatus = rowStatus;
	}

	public TargetMarketingHeaderRow(TargetMarketingPageModel targetMarketingPageModel) {
		super();

		if (targetMarketingPageModel.getWant12to18() == 10 && targetMarketingPageModel.getWant19to25() == 10) {
			rowStatus = "Want12to18ToWant19to25";
		}
		if (targetMarketingPageModel.getWant19to25() == 10 && targetMarketingPageModel.getWant26to35() == 10) {
			rowStatus = "Want19to25ToWant26to35";
		}

		if (targetMarketingPageModel.getWant26to35() == 10 && targetMarketingPageModel.getWant36to45() == 10) {
			rowStatus = "Want26to35ToWant36to45";
		}
		if (targetMarketingPageModel.getWant36to45() == 10 && targetMarketingPageModel.getWant46to55() == 10) {
			rowStatus = "Want36to45ToWant46to55";
		}
		if (targetMarketingPageModel.getWant46to55() == 10 && targetMarketingPageModel.getWant55Plus() == 10) {
			rowStatus = "Want46to55ToWant55Plus";
		}
	}
}
