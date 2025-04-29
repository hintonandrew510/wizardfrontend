package web.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.Gson;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "webclient")
public class WebClient {
	private static Logger mLog = LoggerFactory.getLogger("WebClient");
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "executiondate")
	private String executionDate;

	public String getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}

	@NotNull
	@Column(name = "description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotNull
	@Column(name = "url")
	private String url;
	@Column(name = "request")
	@Size(max = 1004)
	private String request;

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	@NotNull // JSR303
	@Column(name = "author_id")
	private Integer authorId;
	@NotNull // JSR303
	@Column(name = "category_id")
	private Integer categoryId;
	@NotNull // JSR303
	@Column(name = "header")
	private transient String header;

	public String toString() {
		Gson gson = new Gson();
		String json = null;
		// convert map to JSON String
		// .json.gson.
		json = gson.toJson(this);

		// remove \
		String test = json.replaceAll("\"", "'");
		mLog.info(json);
		return json;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
