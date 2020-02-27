package com.corejsf;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
// for locale purpose :
import java.util.Locale;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List ;
//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
//@Named("payment") //
@ManagedBean(name="payment")
@SessionScoped
public class PaymentBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8752041026944482350L;
	private double amount;
	private String card="";
	private Date date = new Date();
	//Locale
	private List<Locale> languagens;
	private String language = "pt";
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Locale> getLanguages()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Iterator<Locale> locales = facesContext.getApplication().getSupportedLocales();
		
		this.languagens = new ArrayList<Locale>();
		
		while ( locales.hasNext() ) {
			this.languagens.add(locales.next());
		}
		
		return this.languagens;
	}
	
	public void setUserLanguage() {
		String[] info = this.language.split("_");
		Locale locale = new Locale( info[0] );
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getViewRoot().setLocale(locale);
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	public void languageCodeChanged(ValueChangeEvent e){
		this.setLanguage(e.getNewValue().toString());
		this.setUserLanguage();
	}
	
	
}