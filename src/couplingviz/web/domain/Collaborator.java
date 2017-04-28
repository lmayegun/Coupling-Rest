package couplingviz.web.domain;

import org.springframework.stereotype.Component;

/**
 * A POJO class annotated as a component and represents a class or an interface in a source code.
 * One of its fields is the object of the Properties class.
 * @version 1.0, April 2017
 */
@Component
public class Collaborator {
	
	private String id;
	private String packagename;
	private Properties properties;
	
	public Collaborator(){
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPackagename() {
		return packagename;
	}
	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}
	public Properties getProperties() {
		return properties;
	}
	//@Autowired
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	

}


