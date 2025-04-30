package web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.web.context.annotation.SessionScope;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "wizarddata")
@SessionScope
public class WizardData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer wizarddataid;
	private String pagedata;
	private Integer wizardid;
	private Integer pagesequence;
	private boolean excluded;

	public void setExcluded(boolean excluded) {
		this.excluded = excluded;
	}
	public boolean isExcluded() {
		return excluded;
	}
	public Integer getWizarddataid() {
		return wizarddataid;
	}

	public void setWizarddataid(Integer wizarddataid) {
		this.wizarddataid = wizarddataid;
	}

	public String getPagedata() {
		return pagedata;
	}

	public void setPagedata(String pagedata) {
		this.pagedata = pagedata;
	}

	public Integer getPagesequence() {
		return pagesequence;
	}

	public void setPagesequence(Integer pagesequence) {
		this.pagesequence = pagesequence;
	}

	public String getPagename() {
		return pagename;
	}

	public void setPagename(String pagename) {
		this.pagename = pagename;
	}

	public Integer getWizardid() {
		return wizardid;
	}

	public void setWizardid(Integer wizardid) {
		this.wizardid = wizardid;
	}

	private String pagename;

}
