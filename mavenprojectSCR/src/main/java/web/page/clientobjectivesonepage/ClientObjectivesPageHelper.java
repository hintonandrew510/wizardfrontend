package web.page.clientobjectivesonepage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientObjectivesPageHelper {
	public static List<ClientObjectivesOnePageTwoModel> getList(boolean performSort,
			ClientObjectivesOnePageModel clientObjectivesOnePageModel) {
		List<ClientObjectivesOnePageTwoModel> orderList = new ArrayList<ClientObjectivesOnePageTwoModel>();

		if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
			ClientObjectivesOnePageTwoModel callAttentiontoBrandsPrivateLabelsCarried = new ClientObjectivesOnePageTwoModel(
					"callAttentiontoBrandsPrivateLabelsCarried",
					clientObjectivesOnePageModel.getCallAttentiontoBrandsPrivateLabelsCarriedSortOrder());
			orderList.add(callAttentiontoBrandsPrivateLabelsCarried);

		}

		if (clientObjectivesOnePageModel.isChangeConsumerAttitudes()) {
			ClientObjectivesOnePageTwoModel changeConsumerAttitudes = new ClientObjectivesOnePageTwoModel(
					"changeConsumerAttitudes", clientObjectivesOnePageModel.getChangeConsumerAttitudesSortOrder());
			orderList.add(changeConsumerAttitudes);

		}
		if (clientObjectivesOnePageModel.isDevelopAQuarterlySpike()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("developAQuarterlySpike",
					clientObjectivesOnePageModel.getDevelopAQuarterlySpikeSortOrder());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isDevelopDatabaseMarketing()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("developDatabaseMarketing",
					clientObjectivesOnePageModel.getDevelopDatabaseMarketingSortOrder());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isDevelopSpeciallyStagedEvent()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel(
					"developSpeciallyStagedEvent",
					clientObjectivesOnePageModel.getDevelopSpeciallyStagedEventSortOrder());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isEstablishorReestablishBusinessImage()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel(
					"establishorReestablishBusinessImage",
					clientObjectivesOnePageModel.getEstablishorReestablishBusinessImageSortOrder());
			orderList.add(modelObj);

		}

		if (clientObjectivesOnePageModel.isCreatePentUpDemand()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("createPentUpDemand",
					clientObjectivesOnePageModel.getCreatePentUpDemandSortOrder());
			orderList.add(modelObj);

		}

		if (clientObjectivesOnePageModel.isExpandTargetConsumers()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("expandTargetConsumers",
					clientObjectivesOnePageModel.getExpandTargetConsumersSortOrder());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isImproveBusinessNameBrand()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("improveBusinessNameBrand",
					clientObjectivesOnePageModel.getImproveBusinessNameBrandSortOrder());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isIncreaseCustomerVisits()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("increaseCustomerVisits",
					clientObjectivesOnePageModel.getIncreaseCustomerVisitsSortOrder());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isQuarterlySeasonalCampaign()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel(
					"quarterlySeasonalCampaign",
					clientObjectivesOnePageModel.getQuarterlySeasonalCampaignSortOrder());
			orderList.add(modelObj);

		}
		
		if (clientObjectivesOnePageModel.isIncreaseDigitalMobileOnlineResponse()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel(
					"increaseDigitalMobileOnlineResponse",
					clientObjectivesOnePageModel.getIncreaseDigitalMobileOnlineResponseSortOrder());
			orderList.add(modelObj);

		}
		
		
		
		if (clientObjectivesOnePageModel.isIncreaseMarketShare()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("increaseMarketShare",
					clientObjectivesOnePageModel.getIncreaseMarketShareSortOrder());
			orderList.add(modelObj);

		}

		if (clientObjectivesOnePageModel.isIncreaseTrafficLeadCalls()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("increaseTrafficLeadCalls",
					clientObjectivesOnePageModel.getIncreaseTrafficLeadCallsSortOrder());
			orderList.add(modelObj);

		}

		if (clientObjectivesOnePageModel.isInitiateCauseMarketingProgram()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel(
					"initiateCauseMarketingProgram",
					clientObjectivesOnePageModel.getInitiateCauseMarketingProgramSortOrder());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isMaintainMarketDominance()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("maintainMarketDominance",
					clientObjectivesOnePageModel.getMaintainMarketDominanceSortOrder());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isMakePromotionalEventsStronger()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel(
					"makePromotionalEventsStronger",
					clientObjectivesOnePageModel.getMakePromotionalEventsStrongerSortOrder());
			orderList.add(modelObj);

		}

		if (clientObjectivesOnePageModel.isOther()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("other",
					clientObjectivesOnePageModel.getOtherSortOrder(), clientObjectivesOnePageModel.getOtherText());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isPromoteOffPriceItemsServices()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel(
					"promoteOffPriceItemsServices",
					clientObjectivesOnePageModel.getPromoteOffPriceItemsServicesSortOrder());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isUtilizeCoopVendorDollars()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("utilizeCoopVendorDollars",
					clientObjectivesOnePageModel.getUtilizeCoopVendorDollarsSortOrder());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isRetainCurrentConsumers()) {
			ClientObjectivesOnePageTwoModel modelObj = new ClientObjectivesOnePageTwoModel("retainCurrentConsumers",
					clientObjectivesOnePageModel.getRetainCurrentConsumersSortOrder());
			orderList.add(modelObj);

		}
		if (clientObjectivesOnePageModel.isFeatureSpecificProducts()) {
			ClientObjectivesOnePageTwoModel featureSpecificProducts = new ClientObjectivesOnePageTwoModel(
					"featureSpecificProducts", clientObjectivesOnePageModel.getFeatureSpecificProductsSortOrder());
			orderList.add(featureSpecificProducts);

		}
		if (clientObjectivesOnePageModel.isIntroduceNewDepartment()) {
			ClientObjectivesOnePageTwoModel introduceNewDepartment = new ClientObjectivesOnePageTwoModel(
					"introduceNewDepartment", clientObjectivesOnePageModel.getIntroduceNewDepartmentSortOrder());
			orderList.add(introduceNewDepartment);

		}

		if (performSort) {
			Collections.sort(orderList, new ClientObjectivesSortOrder());
		}

		return orderList;
	}
}
