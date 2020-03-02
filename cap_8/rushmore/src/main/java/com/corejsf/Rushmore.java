package com.corejsf;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class Rushmore 
{
  private String outcome;
  private Rectangle washingtionRect = new Rectangle( 70, 30, 40, 40 );
  private Rectangle jeffersonRect   = new Rectangle( 115, 45, 40, 40 );
  private Rectangle rooseveltRect   = new Rectangle( 135, 65, 40, 40 );
  private Rectangle lincolnRect     = new Rectangle( 175, 62, 40, 40 );
  
  public void handleMouseClick( ActionEvent e)
  {
	  FacesContext context = FacesContext.getCurrentInstance();
	  String clientId = e.getComponent().getClientId( context );
	  
	  Map<String, String> requestParams = context.getExternalContext().getRequestParameterMap();
	  
	  int x = new Integer( (String) requestParams.get(clientId + ".x")).intValue();
	  int y = new Integer( (String) requestParams.get(clientId + ".y")).intValue();
	  
	  this.outcome = null;
	  
	  if ( washingtionRect.contains(new Point( x, y)))
		  this.outcome = "washington";
	  
	  if ( jeffersonRect.contains(new Point( x, y)))
		  this.outcome = "jefferson";
	  
	  if ( rooseveltRect.contains(new Point( x, y)))
		  this.outcome = "roosevelt";
	  
	  if ( lincolnRect.contains(new Point( x, y)))
		  this.outcome = "lincoln";
	  
  }
  
  public String navigate() {
	  return this.outcome;
  }
}
