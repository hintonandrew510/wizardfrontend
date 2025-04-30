package web.google.slide;

import java.util.List;

import web.page.PieChart;
import web.page.clientobjectivesonepage.ClientObjectivesOnePageModel;
import web.page.clientobjectivesonepage.ClientObjectivesOnePageTwoModel;
import web.page.confidentialclientevaluationnonepage.ConfidentialClientEvaluationOnePageModel;
import web.page.extra.ExtraPageModel;
import web.page.marketplacecompetitionpage.MarketPlaceCompetitionPageModel;
import web.page.planABEPPage.PlanABEPPageModel;
import web.page.planBBEPPage.PlanBBEPPageModel;
import web.page.planDigitalroicalculatorpage.PlanDigitalROICalculatorPageModel;
import web.page.planalifetimevaluedpage.PlanALifetimeValuedPageModel;
import web.page.planamedipage.PlanMediaPageModel;
import web.page.planbLifetimevaluedpage.PlanBLifetimeValuedPageModel;
import web.page.planproposedpage.PlanProposedPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;
import web.page.strategicmarketingpagethree.StrategicMarketingHelper;
import web.page.strategicmarketingpagethree.StrategicMarketingPageThreeModel;
import web.page.targetmarketingpage.TargetMarketingHeaderRow;
import web.page.targetmarketingpage.TargetMarketingPageModel;
import web.page.teamcommitmentpage.TeamCommitmentPageModel;

public class PageModels {
	private ClientObjectivesOnePageModel clientObjectivesOnePageModel;
	private ConfidentialClientEvaluationOnePageModel confidentialClientEvaluationOnePageModel;
	private PresentedToPageModel presentedToPageModel;
	private TeamCommitmentPageModel teamCommitmentPageModel;
	private ExtraPageModel marketingStrategiesPageModel;
	private MarketPlaceCompetitionPageModel marketPlaceCompetitionPageModel;
	private StrategicMarketingPageOneModel strategicMarketingPageOneModel;
	private List<ClientObjectivesOnePageTwoModel> orderList;
	private StrategicMarketingPageThreeModel strategicMarketingPageThreeModel;
	private StrategicMarketingHelper strategicMarketingHelper;
	private TargetMarketingPageModel targetMarketingPageModel;
	private TargetMarketingHeaderRow targetMarketingHeaderRow;
	private PlanProposedPageModel planAProposedPageModel;
	private PlanProposedPageModel planBProposedPageModel;
	private PlanABEPPageModel planABEPPageModel;
	private PlanBBEPPageModel planBBEPPageModel;
	private PlanDigitalROICalculatorPageModel planADigitalROICalculatorPageModel;
	private PlanDigitalROICalculatorPageModel planBDigitalROICalculatorPageModel;
	private PlanALifetimeValuedPageModel planALifetimeValuedPageModel;
	private PlanBLifetimeValuedPageModel planBLifetimeValuedPageModel;
	private PlanMediaPageModel planAMediaPagedataPageModel;
	private PlanMediaPageModel planBMediaPagedataPageModel;
	private List<PieChart> pieChartConfidentialClientEvaluationOnePage;
	public List<PieChart> getPieChartConfidentialClientEvaluationOnePage() {
		return pieChartConfidentialClientEvaluationOnePage;
	}

	public void setPieChartConfidentialClientEvaluationOnePage(List<PieChart> pieChartConfidentialClientEvaluationOnePage) {
		this.pieChartConfidentialClientEvaluationOnePage = pieChartConfidentialClientEvaluationOnePage;
	}

	public List<PieChart> getPieChartConfidentialClientEvaluationProposed() {
		return pieChartConfidentialClientEvaluationProposed;
	}

	public void setPieChartConfidentialClientEvaluationProposed(
			List<PieChart> pieChartConfidentialClientEvaluationProposed) {
		this.pieChartConfidentialClientEvaluationProposed = pieChartConfidentialClientEvaluationProposed;
	}

	private List<PieChart> pieChartConfidentialClientEvaluationProposed;

	public PlanMediaPageModel getPlanAMediaPagedataPageModel() {
		return planAMediaPagedataPageModel;
	}

	public void setPlanAMediaPagedataPageModel(PlanMediaPageModel planAMediaPagedataPageModel) {
		this.planAMediaPagedataPageModel = planAMediaPagedataPageModel;
	}

	public PlanMediaPageModel getPlanBMediaPagedataPageModel() {
		return planBMediaPagedataPageModel;
	}

	public void setPlanBMediaPagedataPageModel(PlanMediaPageModel planBMediaPagedataPageModel) {
		this.planBMediaPagedataPageModel = planBMediaPagedataPageModel;
	}

	public PlanBLifetimeValuedPageModel getPlanBLifetimeValuedPageModel() {
		return planBLifetimeValuedPageModel;
	}

	public void setPlanBLifetimeValuedPageModel(PlanBLifetimeValuedPageModel planBLifetimeValuedPageModel) {
		this.planBLifetimeValuedPageModel = planBLifetimeValuedPageModel;
	}

	public PlanALifetimeValuedPageModel getPlanALifetimeValuedPageModel() {
		return planALifetimeValuedPageModel;
	}

	public void setPlanALifetimeValuedPageModel(PlanALifetimeValuedPageModel planALifetimeValuedPageModel) {
		this.planALifetimeValuedPageModel = planALifetimeValuedPageModel;
	}

	public PlanDigitalROICalculatorPageModel getPlanBDigitalROICalculatorPageModel() {
		return planBDigitalROICalculatorPageModel;
	}

	public void setPlanBDigitalROICalculatorPageModel(
			PlanDigitalROICalculatorPageModel planBDigitalROICalculatorPageModel) {
		this.planBDigitalROICalculatorPageModel = planBDigitalROICalculatorPageModel;
	}

	public PlanDigitalROICalculatorPageModel getPlanADigitalROICalculatorPageModel() {
		return planADigitalROICalculatorPageModel;
	}

	public void setPlanADigitalROICalculatorPageModel(
			PlanDigitalROICalculatorPageModel planADigitalROICalculatorPageModel) {
		this.planADigitalROICalculatorPageModel = planADigitalROICalculatorPageModel;
	}

	public PlanBBEPPageModel getPlanBBEPPageModel() {
		return planBBEPPageModel;
	}

	public void setPlanBBEPPageModel(PlanBBEPPageModel planBBEPPageModel) {
		this.planBBEPPageModel = planBBEPPageModel;
	}

	public PlanABEPPageModel getPlanABEPPageModel() {
		return planABEPPageModel;
	}

	public void setPlanABEPPageModel(PlanABEPPageModel planABEPPageModel) {
		this.planABEPPageModel = planABEPPageModel;
	}

	public PlanProposedPageModel getPlanBProposedPageModel() {
		return planBProposedPageModel;
	}

	public void setPlanBProposedPageModel(PlanProposedPageModel planBProposedPageModel) {
		this.planBProposedPageModel = planBProposedPageModel;
	}

	public PlanProposedPageModel getPlanAProposedPageModel() {
		return planAProposedPageModel;
	}

	public void setPlanAProposedPageModel(PlanProposedPageModel planAProposedPageModel) {
		this.planAProposedPageModel = planAProposedPageModel;
	}

	public TargetMarketingPageModel getTargetMarketingPageModel() {
		return targetMarketingPageModel;
	}

	public void setTargetMarketingPageModel(TargetMarketingPageModel targetMarketingPageModel) {
		this.targetMarketingPageModel = targetMarketingPageModel;
	}

	public TargetMarketingHeaderRow getTargetMarketingHeaderRow() {
		return targetMarketingHeaderRow;
	}

	public void setTargetMarketingHeaderRow(TargetMarketingHeaderRow targetMarketingHeaderRow) {
		this.targetMarketingHeaderRow = targetMarketingHeaderRow;
	}

	public StrategicMarketingPageThreeModel getStrategicMarketingPageThreeModel() {
		return strategicMarketingPageThreeModel;
	}

	public void setStrategicMarketingPageThreeModel(StrategicMarketingPageThreeModel strategicMarketingPageThreeModel) {
		this.strategicMarketingPageThreeModel = strategicMarketingPageThreeModel;
	}

	public StrategicMarketingHelper getStrategicMarketingHelper() {
		return strategicMarketingHelper;
	}

	public void setStrategicMarketingHelper(StrategicMarketingHelper strategicMarketingHelper) {
		this.strategicMarketingHelper = strategicMarketingHelper;
	}

	public List<ClientObjectivesOnePageTwoModel> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ClientObjectivesOnePageTwoModel> orderList) {
		this.orderList = orderList;
	}

	public StrategicMarketingPageOneModel getStrategicMarketingPageOneModel() {
		return strategicMarketingPageOneModel;
	}

	public void setStrategicMarketingPageOneModel(StrategicMarketingPageOneModel strategicMarketingPageOneModel) {
		this.strategicMarketingPageOneModel = strategicMarketingPageOneModel;
	}

	public MarketPlaceCompetitionPageModel getMarketPlaceCompetitionPageModel() {
		return marketPlaceCompetitionPageModel;
	}

	public void setMarketPlaceCompetitionPageModel(MarketPlaceCompetitionPageModel marketPlaceCompetitionPageModel) {
		this.marketPlaceCompetitionPageModel = marketPlaceCompetitionPageModel;
	}

	public ExtraPageModel getMarketingStrategiesPageModel() {
		return marketingStrategiesPageModel;
	}

	public void setMarketingStrategiesPageModel(ExtraPageModel marketingStrategiesPageModel) {
		this.marketingStrategiesPageModel = marketingStrategiesPageModel;
	}

	public TeamCommitmentPageModel getTeamCommitmentPageModel() {
		return teamCommitmentPageModel;
	}

	public void setTeamCommitmentPageModel(TeamCommitmentPageModel teamCommitmentPageModel) {
		this.teamCommitmentPageModel = teamCommitmentPageModel;
	}

	public ClientObjectivesOnePageModel getClientObjectivesOnePageModel() {
		return clientObjectivesOnePageModel;
	}

	public void setClientObjectivesOnePageModel(ClientObjectivesOnePageModel clientObjectivesOnePageModel) {
		this.clientObjectivesOnePageModel = clientObjectivesOnePageModel;
	}

	public ConfidentialClientEvaluationOnePageModel getConfidentialClientEvaluationOnePageModel() {
		return confidentialClientEvaluationOnePageModel;
	}

	public void setConfidentialClientEvaluationOnePageModel(
			ConfidentialClientEvaluationOnePageModel confidentialClientEvaluationOnePageModel) {
		this.confidentialClientEvaluationOnePageModel = confidentialClientEvaluationOnePageModel;
	}

	public PresentedToPageModel getPresentedToPageModel() {
		return presentedToPageModel;
	}

	public void setPresentedToPageModel(PresentedToPageModel presentedToPageModel) {
		this.presentedToPageModel = presentedToPageModel;
	}

}
