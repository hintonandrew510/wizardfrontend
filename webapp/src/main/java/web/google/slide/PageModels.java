package web.google.slide;


import web.page.clientobjectivesonepage.ClientObjectivesOnePageModel;
import web.page.confidentialclientevaluationnonepage.ConfidentialClientEvaluationOnePageModel;
import web.page.presentedtopage.PresentedToPageModel;

public class PageModels {
 private ClientObjectivesOnePageModel clientObjectivesOnePageModel;
 private ConfidentialClientEvaluationOnePageModel confidentialClientEvaluationOnePageModel;
 private PresentedToPageModel presentedToPageModel;
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
