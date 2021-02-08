package web.google.slide;

import java.util.List;

import web.page.clientobjectivesonepage.ClientObjectivesOnePageModel;
import web.page.clientobjectivesonepage.ClientObjectivesOnePageTwoModel;
import web.page.confidentialclientevaluationnonepage.ConfidentialClientEvaluationOnePageModel;
import web.page.extra.ExtraPageModel;
import web.page.marketplacecompetitionpage.MarketPlaceCompetitionPageModel;
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
