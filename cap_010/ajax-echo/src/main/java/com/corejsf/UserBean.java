package com.corejsf;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name="user")
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name="";
	private String password;
	private String city="" ;
	
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
	
	public void validateName( FacesContext fc, UIComponent c, Object value) {
		if ( ((String) value).contains("_")) throw new ValidatorException(
				                                           new FacesMessage("Name cannot contains underscores "));
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	

}
