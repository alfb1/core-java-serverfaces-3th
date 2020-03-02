package com.corejsf;

import java.util.Locale;
import java.util.Map;

// or import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean ( name="localeBean" ) // or @Named
@RequestScoped
public class LocaleChanger 
{
   public String changeLocale( ActionEvent event ) 
   {
	  UIComponent component = event.getComponent();
	  String languageCode = getLanguageCode( component );
      FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale( languageCode ));
      
      return null;
   }
   
   private String getLanguageCode( UIComponent component )
   {
	  Map<String, Object> attrs = component.getAttributes();
	  return (String) attrs.get("languageCode");
   }
}
