package com.corejsf;

import java.io.Serializable;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean ( name="user")
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6930499000809407190L;
	
	private String name = "";
	private String password;
	private boolean loggedIn;
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
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String login() {
		this.loggedIn = true;
		return "index";
	}
	
	public String logout() {
		this.loggedIn = false ;
		return "login";
	}
	
	public void checkLogin( ComponentSystemEvent event ) 
	{
		if( !loggedIn ) 
		{
		   FacesContext context = FacesContext.getCurrentInstance();
		   ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
		   
		   handler.performNavigation( "login" );
		}
		
	}
	

}
