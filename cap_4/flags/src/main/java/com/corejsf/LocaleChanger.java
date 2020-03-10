package com.corejsf;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LocaleChanger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7411347511029602422L;
   
	public String germanAction()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(Locale.GERMAN);
		
		return null;
	}
	
	public String englishAction()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(Locale.ENGLISH);
		
		return null;
	}
}
