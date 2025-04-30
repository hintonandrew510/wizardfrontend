package web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.web.context.annotation.SessionScope;

import web.util.EncryptionDecryptionManager;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "wizard")
@SessionScope
public class Wizard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer wizardid;
    private String encrypt;

	public String getEncrypt() {
		//encrypt = EncryptionDecryptionManager.encode(encrypt);
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	public Integer getWizardid() {
		return wizardid;
	}

	public void setWizardid(Integer wizardid) {
		this.wizardid = wizardid;
	}

	public Integer getAgentid() {
		return agentid;
	}

	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Integer agentid;

	private String name;

}
