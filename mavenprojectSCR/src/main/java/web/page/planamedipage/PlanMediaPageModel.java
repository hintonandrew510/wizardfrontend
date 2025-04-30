package web.page.planamedipage;

import java.util.ArrayList;
import java.util.List;

public class PlanMediaPageModel {

	private String janType;
	private String febType;
	private String marType;
	private String aprType;
	private String mayType;
	private String junType;
	private String julType;
	private String augType;
	private String septType;
	private String octType;
	private String novType;
	private String decType;
	private String mediaRows;

	public String getMediaRows() {
		return mediaRows;
	}

	public void setMediaRows(String mediaRows) {
		this.mediaRows = mediaRows;
	}

	/**
	 * 
	 */
	private List<MediaRow> mediaRowList = new ArrayList<MediaRow>();

	public String getJanType() {
		return janType;
	}

	public void setJanType(String janType) {
		this.janType = janType;
	}

	public String getFebType() {
		return febType;
	}

	public String getSeptType() {
		return septType;
	}

	public void setSeptType(String septType) {
		this.septType = septType;
	}

	public void setFebType(String febType) {
		this.febType = febType;
	}

	public String getMarType() {
		return marType;
	}

	public PlanMediaPageModel(String janType, String febType, String marType, String aprType, String mayType,
			String junType, String julType, String augType, String septType, String octType, String novType,
			String decType, String mediaRows, List<MediaRow> mediaRowList) {
		super();
		this.janType = janType;
		this.febType = febType;
		this.marType = marType;
		this.aprType = aprType;
		this.mayType = mayType;
		this.junType = junType;
		this.julType = julType;
		this.augType = augType;
		this.septType = septType;
		this.octType = octType;
		this.novType = novType;
		this.decType = decType;
		this.mediaRows = mediaRows;
		this.mediaRowList = mediaRowList;
	}

	public void setMarType(String marType) {
		this.marType = marType;
	}

	public String getAprType() {
		return aprType;
	}

	public void setAprType(String aprType) {
		this.aprType = aprType;
	}

	public String getMayType() {
		return mayType;
	}

	public void setMayType(String mayType) {
		this.mayType = mayType;
	}

	public String getJunType() {
		return junType;
	}

	public void setJunType(String junType) {
		this.junType = junType;
	}

	public String getJulType() {
		return julType;
	}

	public void setJulType(String julType) {
		this.julType = julType;
	}

	public String getAugType() {
		return augType;
	}

	public void setAugType(String augType) {
		this.augType = augType;
	}

	public String getOctType() {
		return octType;
	}

	public void setOctType(String octType) {
		this.octType = octType;
	}

	public String getNovType() {
		return novType;
	}

	public void setNovType(String novType) {
		this.novType = novType;
	}

	public String getDecType() {
		return decType;
	}

	public void setDecType(String decType) {
		this.decType = decType;
	}

	public List<MediaRow> getMediaRowList() {
		return mediaRowList;
	}

	public void setMediaRowList(List<MediaRow> mediaRowList) {
		this.mediaRowList = mediaRowList;
	}
}
