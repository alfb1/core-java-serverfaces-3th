package com.corejsf.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Messages {

	public static FacesMessage getMessage( String bundleName, String resourceId, Object[] params)
	{
		if ( resourceId == null ) return null;
		
	    String summary = getMensagem( bundleName, resourceId, params );
		
		
		if ( summary == null ) summary = "???" + resourceId + "???";
		
		String detail = getMensagem( bundleName, resourceId + "_detail", params);
		
		return new FacesMessage( summary, detail );
	}
	
	

	public static String getMensagem(String bundleName, String propriedade) 
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle resourceBundle = facesContext.getApplication().getResourceBundle(facesContext, bundleName);
		
		return resourceBundle.getString(propriedade);
	}
	
	
	public static String getMensagem(String bundleName, String resourceId, Object...parametros) 
	{
		String mensagem = getMensagem(bundleName, resourceId);
		MessageFormat messageFormat = new MessageFormat(mensagem);
		
		return messageFormat.format(parametros);
	}
}
