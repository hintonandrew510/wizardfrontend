package web.page.planamediapage;

public class MediaRow {
	private String name;
	private double jan;
	private double feb;
	private double mar;
	private double apr; 
	private double may;
	private double jun;
	private double jul;
	private double aug;
	private double oct; 
	private double nov;
	private double dec;
	public MediaRow(String name, double jan, double feb, double mar, double apr, double may, double jun, double jul,
			double aug, double oct, double nov, double dec) {
		super();
		this.name = name;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
		this.apr = apr;
		this.may = may;
		this.jun = jun;
		this.jul = jul;
		this.aug = aug;
		this.oct = oct;
		this.nov = nov;
		this.dec = dec;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getJan() {
		return jan;
	}
	public void setJan(double jan) {
		this.jan = jan;
	}
	public double getFeb() {
		return feb;
	}
	public void setFeb(double feb) {
		this.feb = feb;
	}
	public double getMar() {
		return mar;
	}
	public void setMar(double mar) {
		this.mar = mar;
	}
	public double getApr() {
		return apr;
	}
	public void setApr(double apr) {
		this.apr = apr;
	}
	public double getMay() {
		return may;
	}
	public void setMay(double may) {
		this.may = may;
	}
	public double getJun() {
		return jun;
	}
	public void setJun(double jun) {
		this.jun = jun;
	}
	public double getJul() {
		return jul;
	}
	public void setJul(double jul) {
		this.jul = jul;
	}
	public double getAug() {
		return aug;
	}
	public void setAug(double aug) {
		this.aug = aug;
	}
	public double getOct() {
		return oct;
	}
	public void setOct(double oct) {
		this.oct = oct;
	}
	public double getNov() {
		return nov;
	}
	public void setNov(double nov) {
		this.nov = nov;
	}
	public double getDec() {
		return dec;
	}
	public void setDec(double dec) {
		this.dec = dec;
	}
	
	
}