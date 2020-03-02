package com.corejsf;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean( name="form" )
@SessionScoped
public class RegisterForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1732491269848777881L;
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	
	private static final Locale[] countries = { Locale.US, Locale.CANADA };
	
	public Locale[] getCountries() {
		return countries;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

    public void setCountry(String value) {
    	this.country = value;
    }

	
	public void countryChanged( ValueChangeEvent event)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		
		for ( Locale loc : countries )
			if ( loc.getCountry().equals( event.getNewValue() ))
				FacesContext.getCurrentInstance().getViewRoot().setLocale(loc);
		//utilizado para realizar o metodo com
		// immediate="true"
		context.renderResponse();
	}

}
