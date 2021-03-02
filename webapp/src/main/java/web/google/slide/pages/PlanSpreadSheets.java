package web.google.slide.pages;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.Locale;
import web.google.slide.GoogleHelper;

public class PlanSpreadSheets {
	private static final Logger mLog = Logger.getLogger(PlanSpreadSheets.class.getName());
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
		return jun;
	}

	public void setJun(String jun) {
		this.jun = jun;
	}

	public String getJul() {
		jul = formatDoubleToCurrency(julTotal);
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
	
	public List<PlanSpreadSheet> getPlanSpreadSheets() {
		return planSpreadSheets;
	}

	public void setPlanSpreadSheets(List<PlanSpreadSheet> planSpreadSheets) {
		this.planSpreadSheets = planSpreadSheets;
	}
	
	public String formatDoubleToCurrency(Number amount) {
		try {
			mLog.warning("formatDoubleToCurrency starting");
			mLog.info("amount " + amount);
			 NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
			 usdCostFormat.setMaximumFractionDigits(0);
			String output = usdCostFormat.format(amount);
			mLog.info("output " + output);
			mLog.warning("formatDoubleToCurrency ending");
			return output;
		} catch (Exception ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			mLog.severe("ERROR  [" + sw.toString() + "]");
			
			return "0";
		}
	}
	
	private void constructTotals() throws Exception {
		mLog.warning("constructTotals starting");
	//	NumberFormat nf = NumberFormat.getNumberInstance();
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		
		
		
		Number number = null;
		for (PlanSpreadSheet rowData : planSpreadSheets ) {
			
			  number = nf.parse(rowData.getJan());
			//amount= nf.format(rowData.getJan());
			mLog.info("Jan " + number);
			
			janTotal = janTotal + (Long)number;
			
			number= nf.parse(rowData.getFeb());
			mLog.info("feb " + number);
			febTotal = febTotal +   (Long)number;
			
			number= nf.parse(rowData.getMar());
			mLog.info("mar " + number);
			marTotal = marTotal +  (Long)number;
			
			number= nf.parse(rowData.getApr());
			mLog.info("Apr " + number);
			aprTotal = aprTotal +  (Long)number;
			
			number= nf.parse(rowData.getMay());
			mLog.info("May " + number);
			mayTotal = mayTotal +  (Long)number;
			
			number= nf.parse(rowData.getJun());
			mLog.info("Jun " + number);
			junTotal = junTotal +  (Long)number;
			
			number= nf.parse(rowData.getJul());
			mLog.info("Jul " + number);
			julTotal = julTotal +  (Long)number;
			
			number= nf.parse(rowData.getJun());
			mLog.info("Jun " + number);
			junTotal = junTotal +  (Long)number;
			
			number= nf.parse(rowData.getJul());
			mLog.info("Jul " + number);
			julTotal = julTotal +  (Long)number;
			
			number= nf.parse(rowData.getAug());
			mLog.info("Aug " + number);
			augTotal = augTotal +  (Long)number;
			
			number= nf.parse(rowData.getSep());
			mLog.info("Sep " + number);
			sepTotal = sepTotal + (Long)number;
			
			number= nf.parse(rowData.getOct());
			mLog.info("Oct " + number);
			octTotal = octTotal +  (Long)number;
			
			number= nf.parse(rowData.getNov());
			mLog.info("Nov " + number);
			novTotal = novTotal +  (Long)number;
			
			
			number= nf.parse(rowData.getDec());
			mLog.info("Dec " + number);
			decTotal = decTotal +  (Long)number;
			
			String numberStr = rowData.getRt();
			mLog.info("Rt " + numberStr);
			rtTotal = rtTotal +  Long.parseLong(numberStr);
			
			mLog.warning("constructTotals ending");
			
		}
	}
	
	/*
	 * NumberFormat nf = NumberFormat.getNumberInstance();
nf.setGroupingUsed(false);
nf.setMinimumFractionDigits(2);
String ammount= nf.format(value);
	 */

	public PlanSpreadSheets(String json) {
		try {
			mLog.warning("starting PlanSpreadSheets");
			planSpreadSheets = new Gson().fromJson(json, new TypeToken<List<PlanSpreadSheet>>() {
			}.getType());
			constructTotals();
			
		} catch (Exception ex) {
			mLog.severe(ex.getMessage());
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			// mLog.severe(ex);
			mLog.severe("ERROR PlanASpreadSheet Constructor [" + sw.toString() + "]");
		
		}
		mLog.warning("ending PlanSpreadSheets");
	}

}
