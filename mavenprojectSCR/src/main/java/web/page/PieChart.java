package web.page;

public class PieChart {
	private String label;
	private int labelValue;

	public PieChart(String label, int labelValue) {
		super();
		this.label = label;
		this.labelValue = labelValue;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getLabelValue() {
		return labelValue;
	}

	public void setLabelValue(int labelValue) {
		this.labelValue = labelValue;
	}

}
