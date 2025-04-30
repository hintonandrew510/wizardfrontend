package web.page;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import web.page.confidentialclientevaluationnonepage.ConfidentialClientEvaluationOnePageModel;

public class ChartBuilder {

	private static final Logger mLog = LoggerFactory.getLogger(ChartBuilder.class.getName());

	public static List<PieChart> buildLastYearConfidentialClientEvaluation(
			ConfidentialClientEvaluationOnePageModel model) {
		mLog.info("start buildLastYearConfidentialClientEvaluation");
		List<PieChart> pieCharts = new ArrayList<PieChart>();
		if (model.getLastYearLabel1() != null && model.getLastYearValue1() != null) {
			// amount
			try {

				int amount = parse(model.getLastYearValue1());
				PieChart pieChart = new PieChart(model.getLastYearLabel1(), amount);
			//	mLog.info(" add to piechart LastYear label [" + model.getLastYearLabel1() + "]");
			//	mLog.info(" add to piechart LastYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getLastYearValue1() + "]");
			}

		}

		if (model.getLastYearLabel2() != null && model.getLastYearValue2() != null) {
			// amount
			try {

				int amount = parse(model.getLastYearValue2());
				PieChart pieChart = new PieChart(model.getLastYearLabel2(), amount);
				pieCharts.add(pieChart);

			} catch (Exception ex) {
			}

		}
		if (model.getLastYearLabel3() != null && model.getLastYearValue3() != null) {
			// amount
			try {

				int amount = parse(model.getLastYearValue3());
				PieChart pieChart = new PieChart(model.getLastYearLabel3(), amount);
				//mLog.info(" add to piechart LastYear label [" + model.getLastYearLabel3() + "]");
				//mLog.info(" add to piechart LastYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse LastYear amount [" + model.getLastYearValue3() + "]");
			}

		}
		if (model.getLastYearLabel4() != null && model.getLastYearValue4() != null) {
			// amount
			try {

				int amount = parse(model.getLastYearValue4());
				PieChart pieChart = new PieChart(model.getLastYearLabel4(), amount);
				//mLog.info(" add to piechart LastYear label [" + model.getLastYearLabel4() + "]");
				//mLog.info(" add to piechart LastYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse LastYear amount [" + model.getLastYearValue4() + "]");
			}

		}
		if (model.getLastYearLabel5() != null && model.getLastYearValue5() != null) {
			// amount
			try {

				int amount = parse(model.getLastYearValue5());
				PieChart pieChart = new PieChart(model.getLastYearLabel5(), amount);
				//mLog.info(" add to piechart LastYear label [" + model.getLastYearLabel5() + "]");
				//mLog.info(" add to piechart  LastYearamount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not LastYear parse amount [" + model.getLastYearValue5() + "]");
			}

		}
		if (model.getLastYearLabel6() != null && model.getLastYearValue6() != null) {
			// amount
			try {

				int amount = parse(model.getLastYearValue6());
				PieChart pieChart = new PieChart(model.getLastYearLabel6(), amount);
				//mLog.info(" add to piechart LastYear label [" + model.getLastYearLabel6() + "]");
				//mLog.info(" add to piechart LastYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getLastYearValue6() + "]");
			}

		}
		if (model.getLastYearLabel7() != null && model.getLastYearValue7() != null) {
			// amount
			try {

				int amount = parse(model.getLastYearValue7());
				PieChart pieChart = new PieChart(model.getLastYearLabel7(), amount);
				//mLog.info(" add to piechart LastYear label [" + model.getLastYearLabel7() + "]");
				//mLog.info(" add to piechart LastYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse LastYear amount [" + model.getLastYearValue7() + "]");
			}

		}
		if (model.getLastYearLabel8() != null && model.getLastYearValue8() != null) {
			// amount
			try {

				int amount = parse(model.getLastYearValue8());
				PieChart pieChart = new PieChart(model.getLastYearLabel8(), amount);
				//mLog.info(" add to piechart LastYear label [" + model.getLastYearLabel8() + "]");
				//mLog.info(" add to piechart LastYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getLastYearValue8() + "]");
			}

		}
		if (model.getLastYearLabel9() != null && model.getLastYearValue9() != null) {
			// amount
			try {

				int amount = parse(model.getLastYearValue9());
				PieChart pieChart = new PieChart(model.getLastYearLabel9(), amount);
				//mLog.info(" add to piechart LastYear label [" + model.getLastYearLabel9() + "]");
				//mLog.info(" add to piechart LastYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getLastYearValue9() + "]");
			}

		}

		return pieCharts;
	}

	public static List<PieChart> buildNextYearConfidentialClientEvaluation(
			ConfidentialClientEvaluationOnePageModel model) {
		mLog.info("start buildNextYearConfidentialClientEvaluation");
		List<PieChart> pieCharts = new ArrayList<PieChart>();
		if (model.getProposedLabel1() != null && model.getProposedValue1() != null) {
			// amount
			try {

				int amount = parse(model.getProposedValue1());
				PieChart pieChart = new PieChart(model.getProposedLabel1(), amount);
				//mLog.info(" add to piechart NextYear label [" + model.getProposedLabel1() + "]");
				//mLog.info(" add to piechart NextYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getLastYearValue1() + "]");
			}

		}

		if (model.getProposedLabel2() != null && model.getProposedValue2() != null) {
			// amount
			try {

				int amount = parse(model.getProposedValue2());
				PieChart pieChart = new PieChart(model.getProposedLabel2(), amount);
				pieCharts.add(pieChart);

			} catch (Exception ex) {
			}

		}
		if (model.getProposedLabel3() != null && model.getProposedValue3() != null) {
			// amount
			try {

				int amount = parse(model.getProposedValue3());
				PieChart pieChart = new PieChart(model.getProposedLabel3(), amount);
				//mLog.info(" add to piechart NextYearlabel [" + model.getProposedLabel3() + "]");
				//mLog.info(" add to piechart NextYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getProposedValue3() + "]");
			}

		}
		if (model.getProposedLabel4() != null && model.getProposedValue4() != null) {
			// amount
			try {

				int amount = parse(model.getProposedValue4());
				PieChart pieChart = new PieChart(model.getProposedLabel4(), amount);
				//mLog.info(" add to piechart NextYear label [" + model.getProposedLabel4() + "]");
				//mLog.info(" add to piechart NextYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getLastYearValue4() + "]");
			}

		}
		if (model.getProposedLabel5() != null && model.getProposedValue5() != null) {
			// amount
			try {

				int amount = parse(model.getProposedValue5());
				PieChart pieChart = new PieChart(model.getProposedLabel5(), amount);
				//mLog.info(" add to piechart NextYear label [" + model.getProposedLabel5() + "]");
				//mLog.info(" add to piechart NextYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getProposedValue5() + "]");
			}

		}
		if (model.getProposedLabel6() != null && model.getProposedValue6() != null) {
			// amount
			try {

				int amount = parse(model.getProposedValue6());
				PieChart pieChart = new PieChart(model.getProposedLabel6(), amount);
				//mLog.info(" add to piechart NextYear label [" + model.getProposedLabel6() + "]");
				//mLog.info(" add to piechart NextYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getProposedValue6() + "]");
			}

		}
		if (model.getProposedLabel7() != null && model.getProposedValue7() != null) {
			// amount
			try {

				int amount = parse(model.getProposedValue7());
				PieChart pieChart = new PieChart(model.getProposedLabel7(), amount);
				//mLog.info(" add to piechart NextYear label [" + model.getProposedLabel7() + "]");
				//mLog.info(" add to piechart NextYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getProposedValue7() + "]");
			}

		}
		if (model.getProposedLabel8() != null && model.getProposedValue8() != null) {
			// amount
			try {

				int amount = parse(model.getProposedValue8());
				PieChart pieChart = new PieChart(model.getProposedLabel8(), amount);
				//mLog.info(" add to piechart NextYear label [" + model.getProposedLabel8() + "]");
				//mLog.info(" add to piechart NextYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getProposedValue8() + "]");
			}

		}
		if (model.getProposedLabel9() != null && model.getProposedValue9() != null) {
			// amount
			try {

				int amount = parse(model.getProposedValue9());
				PieChart pieChart = new PieChart(model.getProposedLabel9(), amount);
				//mLog.info(" add to piechart NextYear label [" + model.getProposedLabel9() + "]");
				//mLog.info(" add to piechart NextYear amount [" + amount + "]");
				pieCharts.add(pieChart);

			} catch (Exception ex) {
				mLog.warn("Could not parse amount [" + model.getProposedValue9() + "]");
			}

		}

		return pieCharts;
	}

	public static int parse(String amount) throws ParseException {
		if (amount == null || amount.trim().isEmpty()) {
			return 0;
		}
		String stramount = amount.replace("$", "");
		stramount = stramount.replace(",", "");
		Double doubleAmount = Double.parseDouble(stramount);
		int convertedAmount = doubleAmount.intValue();
		//mLog.info("Converted amount = [" + convertedAmount + "]");
		return convertedAmount;
	}
}
