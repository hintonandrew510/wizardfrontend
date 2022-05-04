package web.google.slide.pages;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.Locale;
import web.google.slide.GoogleHelper;

public class PlanSpreadSheets {
	private static final Logger mLog = LoggerFactory.getLogger(PlanSpreadSheets.class.getName());
	private List<PlanSpreadSheet> planSpreadSheets;
	
	
	private String jan;
	public String getJan() {
		jan = formatDoubleToCurrency(janTotal);
		return jan;
	}

	public void setJan(String jan) {
		this.jan = jan;
	}

	public String getFeb() {
		feb = formatDoubleToCurrency(febTotal);
		return feb;
	}

	public void setFeb(String feb) {
		this.feb = feb;
	}

	public String getMar() {
		mar = formatDoubleToCurrency(marTotal);
		return mar;
	}

	public void setMar(String mar) {
		this.mar = mar;
	}

	public String getApr() {
		apr = formatDoubleToCurrency(aprTotal);
		return apr;
	}

	public void setApr(String apr) {
		this.apr = apr;
	}

	public String getMay() {
		may = formatDoubleToCurrency(mayTotal);
		return may;
	}

	public void setMay(String may) {
		this.may = may;
	}

	public String getJun() {
		jun = formatDoubleToCurrency(junTotal);
		mLog.info("get jUn " + jun + " source " + this.source);
		return jun;
	}

	public void setJun(String jun) {
		this.jun = jun;
	}

	public String getJul() {
		jul = formatDoubleToCurrency(julTotal);
		mLog.info("get Jul " + jul + " source " + this.source);
		return jul;
	}

	public void setJul(String jul) {
		this.jul = jul;
	}

	public String getAug() {
		aug = formatDoubleToCurrency(augTotal);
		return aug;
	}

	public void setAug(String aug) {
		this.aug = aug;
	}

	public String getSep() {
		sep = formatDoubleToCurrency(sepTotal);
		return sep;
	}

	public void setSep(String sep) {
		this.sep = sep;
	}

	public String getOct() {
		oct = formatDoubleToCurrency(octTotal);
		return oct;
	}

	public void setOct(String oct) {
		this.oct = oct;
	}

	public String getNov() {
		nov = formatDoubleToCurrency(novTotal);
		return nov;
	}

	public void setNov(String nov) {
		this.nov = nov;
	}

	public String getDec() {
		dec = formatDoubleToCurrency(decTotal);
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public String getRt() {
		rt = formatDoubleToCurrency(rtTotal);
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	private String feb;
	private String mar;
	private String apr;
	private String may;
	private String jun;
	private String jul;
	private String aug;
	private String sep;
	private String oct;
	private String nov;
	private String dec;
	private String rt;
	
	private long janTotal;
	private long febTotal;
	private long marTotal;
	private long aprTotal;
	private long mayTotal;
	private long junTotal;
	private long julTotal;
	private long augTotal;
	private long sepTotal;
	private long octTotal;
	private long novTotal;
	private long decTotal;
	private long rtTotal;
	public String monthlyAverage;
	private Long  monthlyAverageLong;
	private Long dailyCostLong;
	public String getMonthlyAverage() {
		monthlyAverage = formatDoubleToCurrency(monthlyAverageLong);
		
		return monthlyAverage;
	}

	public void setMonthlyAverage(String monthlyAverage) {
		this.monthlyAverage = monthlyAverage;
	}

	public String getDailyCost() {
		dailyCost = formatDoubleToCurrency(dailyCostLong);
		return dailyCost;
	}

	public void setDailyCost(String dailyCost) {
		this.dailyCost = dailyCost;
	}

	public String dailyCost;
	
	public List<PlanSpreadSheet> getPlanSpreadSheets() {
		return planSpreadSheets;
	}

	public void setPlanSpreadSheets(List<PlanSpreadSheet> planSpreadSheets) {
		this.planSpreadSheets = planSpreadSheets;
	}
	
	public String formatDoubleToCurrency(Number amount) {
		try {
			mLog.debug("formatDoubleToCurrency starting");
			mLog.debug("amount " + amount);
			 NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
			 usdCostFormat.setMaximumFractionDigits(0);
			String output = usdCostFormat.format(amount);
			mLog.debug("output " + output);
			mLog.debug("formatDoubleToCurrency ending");
			return output;
		} catch (Exception ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			mLog.error("ERROR  [" + sw.toString() + "]");
			
			return "0";
		}
	}
	private void constructBottomTotals() throws Exception {
		mLog.warn("constructBottomTotals starting");
	//	NumberFormat nf = NumberFormat.getNumberInstance();
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		
		
		
		
		for (PlanSpreadSheet rowData : planSpreadSheets ) {
			
		
			
	
			
			String numberStr = rowData.getRt();
			mLog.info("Rt " + numberStr);
			rtTotal = rtTotal +  Long.parseLong(numberStr);
			
			mLog.warn("constructBottomTotals ending");
			
		}//end of for
		monthlyAverageLong = rtTotal/12;
		dailyCostLong = monthlyAverageLong/30;
	}
	
	
	
	private void constructTotals() throws Exception {
		mLog.warn("constructTotals starting");
	//	NumberFormat nf = NumberFormat.getNumberInstance();
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		
		
		
		Number number = null;
		for (PlanSpreadSheet rowData : planSpreadSheets ) {
			
			  number = nf.parse(rowData.getJan());
			//amount= nf.format(rowData.getJan());
			mLog.debug("Jan " + number);
			
			janTotal = janTotal + (Long)number;
			
			number= nf.parse(rowData.getFeb());
			mLog.debug("feb " + number);
			febTotal = febTotal +   (Long)number;
			
			number= nf.parse(rowData.getMar());
			mLog.debug("mar " + number);
			marTotal = marTotal +  (Long)number;
			
			number= nf.parse(rowData.getApr());
			mLog.debug("Apr " + number);
			aprTotal = aprTotal +  (Long)number;
			
			number= nf.parse(rowData.getMay());
			mLog.debug("May " + number);
			mayTotal = mayTotal +  (Long)number;
			
			number= nf.parse(rowData.getJun());
			mLog.info("Jun " + number);
			junTotal = junTotal +  (Long)number;
			mLog.info("junTotal " + junTotal);
			
			number= nf.parse(rowData.getJul());
			mLog.info("Jul " + number);
			julTotal = julTotal +  (Long)number;
			mLog.info("julTotal " + julTotal);
			
			
			
		
			
			number= nf.parse(rowData.getAug());
			mLog.debug("Aug " + number);
			augTotal = augTotal +  (Long)number;
			
			number= nf.parse(rowData.getSep());
			mLog.debug("Sep " + number);
			sepTotal = sepTotal + (Long)number;
			
			number= nf.parse(rowData.getOct());
			mLog.debug("Oct " + number);
			octTotal = octTotal +  (Long)number;
			
			number= nf.parse(rowData.getNov());
			mLog.debug("Nov " + number);
			novTotal = novTotal +  (Long)number;
			
			
			number= nf.parse(rowData.getDec());
			mLog.debug("Dec " + number);
			decTotal = decTotal +  (Long)number;
			
			String numberStr = rowData.getRt();
			mLog.info("Rt " + numberStr);
			rtTotal = rtTotal +  Long.parseLong(numberStr);
			mLog.info("rtTotal " + rtTotal);
			
			
			mLog.warn("constructTotals ending");
			
		}//end of for
	
	}
	
	/*
	 * NumberFormat nf = NumberFormat.getNumberInstance();
nf.setGroupingUsed(false);
nf.setMinimumFractionDigits(2);
String ammount= nf.format(value);
	 */
	private String source;
	public PlanSpreadSheets(String json, String  source, boolean justBottomTotal) {
		this.source = source;
		try {
			mLog.warn("starting PlanSpreadSheets bottom for " + this.source);
			planSpreadSheets = new Gson().fromJson(json, new TypeToken<List<PlanSpreadSheet>>() {
			}.getType());
			this.constructBottomTotals();
			
		} catch (Exception ex) {
			mLog.error(ex.getMessage());
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			// mLog.error(ex);
			mLog.error("ERROR PlanASpreadSheet Constructor [" + sw.toString() + "]");
		
		}
		mLog.warn("ending PlanSpreadSheets bottom " + this.source);
	}
	
	public PlanSpreadSheets(String json,  String source) {
		this.source = source;
		try {
			mLog.warn("starting PlanSpreadSheets " + this.source);
			planSpreadSheets = new Gson().fromJson(json, new TypeToken<List<PlanSpreadSheet>>() {
			}.getType());
			constructTotals();
			
		} catch (Exception ex) {
			mLog.error(ex.getMessage());
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			// mLog.error(ex);
			mLog.error("ERROR PlanASpreadSheet Constructor [" + sw.toString() + "]");
		
		}
		mLog.warn("ending PlanSpreadSheets  " + this.source);
	}

}
