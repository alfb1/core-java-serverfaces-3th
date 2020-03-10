package com.corejsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean( name="user" )
@SessionScoped 
public class UserBean implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -8177567765674386009L;
	private String name;
    private String password;
    private String aboutYourself;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAboutYourself() {
		return aboutYourself;
	}
	public void setAboutYourself(String aboutYourself) {
		this.aboutYourself = aboutYourself;
	}
    
    
}
