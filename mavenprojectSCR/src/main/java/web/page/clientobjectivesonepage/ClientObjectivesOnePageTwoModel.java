package web.page.clientobjectivesonepage;

public class ClientObjectivesOnePageTwoModel {
	private String key;
	private int sortOrder;
	private String label;
	private String inputNameId;

	public String getInputNameId() {
		inputNameId = key + "SortOrderStr";
		return inputNameId;
	}

	public void setInputNameId(String inputNameId) {
		this.inputNameId = inputNameId;
	}

	public String getLabel() {
		if (this.label != null) {
			return label;
		}
		label = key + "Label";
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public ClientObjectivesOnePageTwoModel(String key, int sortOrder) {
		super();
		this.key = key;
		this.sortOrder = sortOrder;
	}

	public ClientObjectivesOnePageTwoModel(String key, int sortOrder, String label) {
		super();
		this.key = key;
		this.sortOrder = sortOrder;
		this.label = label;
	}

}
