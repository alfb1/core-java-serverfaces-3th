package com.corejsf;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

public class MessageLocale {

	public static String getMensagem(String property) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		//Remember : msg is the variable from faces-config.xml
		ResourceBundle resourceBundle = facesContext.getApplication().getResourceBundle( facesContext, "msg" );
		return resourceBundle.getString( property );
	}
	
	public static String getMensagem(String property, Object...parameters) {
		String mensagem = getMensagem( property );
		MessageFormat messageFormat = new MessageFormat( mensagem );
		return messageFormat.format(parameters);
	}
}
