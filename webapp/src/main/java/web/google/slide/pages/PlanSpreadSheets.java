package web.google.slide.pages;

import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Logger;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import web.google.slide.GoogleHelper;

public class PlanSpreadSheets {
	private static final Logger mLog = Logger.getLogger(PlanSpreadSheets.class.getName());
	private List<PlanSpreadSheet> planSpreadSheets;
	
	
	private String jan;
	public String getJan() {
		return jan;
	}

	public void setJan(String jan) {
		this.jan = jan;
	}

	public String getFeb() {
		return feb;
	}

	public void setFeb(String feb) {
		this.feb = feb;
	}

	public String getMar() {
		return mar;
	}

	public void setMar(String mar) {
		this.mar = mar;
	}

	public String getApr() {
		return apr;
	}

	public void setApr(String apr) {
		this.apr = apr;
	}

	public String getMay() {
		return may;
	}

	public void setMay(String may) {
		this.may = may;
	}

	public String getJun() {
		return jun;
	}

	public void setJun(String jun) {
		this.jun = jun;
	}

	public String getJul() {
		return jul;
	}

	public void setJul(String jul) {
		this.jul = jul;
	}

	public String getAug() {
		return aug;
	}

	public void setAug(String aug) {
		this.aug = aug;
	}

	public String getSep() {
		return sep;
	}

	public void setSep(String sep) {
		this.sep = sep;
	}

	public String getOct() {
		return oct;
	}

	public void setOct(String oct) {
		this.oct = oct;
	}

	public String getNov() {
		return nov;
	}

	public void setNov(String nov) {
		this.nov = nov;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public String getRt() {
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
	
	private double janTotal;
	private double febTotal;
	private double marTotal;
	private double aprTotal;
	private double mayTotal;
	private double junTotal;
	private double julTotal;
	private double augTotal;
	private double sepTotal;
	private double octTotal;
	private double novTotal;
	private double decTotal;
	private double rtTotal;
	
	public List<PlanSpreadSheet> getPlanSpreadSheets() {
		return planSpreadSheets;
	}

	public void setPlanSpreadSheets(List<PlanSpreadSheet> planSpreadSheets) {
		this.planSpreadSheets = planSpreadSheets;
	}
	
	private void constructTotals() {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setGroupingUsed(false);
		nf.setMinimumFractionDigits(0);
		String amount= null;
		for (PlanSpreadSheet rowData : planSpreadSheets ) {
			amount= nf.format(rowData.getJan());
			janTotal = janTotal + Double.parseDouble(amount);
			amount= nf.format(rowData.getFeb());
			febTotal = febTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getMar());
			marTotal = marTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getApr());
			aprTotal = aprTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getMay());
			mayTotal = mayTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getJun());
			junTotal = junTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getJul());
			julTotal = julTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getJun());
			junTotal = junTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getJul());
			julTotal = julTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getAug());
			augTotal = augTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getSep());
			sepTotal = sepTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getOct());
			octTotal = octTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getNov());
			novTotal = novTotal + Double.parseDouble(amount);
			
			
			amount= nf.format(rowData.getDec());
			decTotal = decTotal + Double.parseDouble(amount);
			
			amount= nf.format(rowData.getRt());
			rtTotal = rtTotal + Double.parseDouble(amount);
			
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
		}
		mLog.warning("ending PlanSpreadSheets");
	}

}
