package web.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@Entity // This tells Hibernate to make a table out of this class
public class Category {
	private static Logger mLog = Logger.getLogger("Category");
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;	

    @OneToMany
    @JoinTable(
            name="webclient",
            joinColumns = @JoinColumn( name="category_id"),
            inverseJoinColumns = @JoinColumn( name="id")
    )
    private List<WebClient> mWebClients;

	public List<WebClient> getmWebClients() {
		return mWebClients;
	}

	public void setmWebClients(List<WebClient> mWebClients) {
		this.mWebClients = mWebClients;
	}

	public Integer getId() {
		return id;
	}
	
	public String toString() {
		Gson gson = new Gson();
		String json = null;
		 // convert map to JSON String
		//.json.gson.
		json = gson.toJson(mWebClients);
		
		//remove \
	String test  = json.replaceAll("\"", "'");
	mLog.info(test);
		return test;
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

