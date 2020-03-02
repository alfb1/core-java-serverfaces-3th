package com.corejsf;

import java.util.Locale;
import java.util.Map;

// or import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean ( name="localeBean" ) // or @Named
@RequestScoped
public class LocaleChanger 
{
   public String changeLocale() 
   {
	  FacesContext context = FacesContext.getCurrentInstance();
	  String languageCode = getLanguageCode(context);
      FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale( languageCode ));
      
      return null;
   }
   
   private String getLanguageCode( FacesContext context )
   {
	  Map<String, String> params = context.getExternalContext().getRequestParameterMap();
	  return params.get("languageCode");
   }
}
