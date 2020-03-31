package com.corejsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean (name="cardExpirationDate")
public class CreditCardExpiration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int month = 1;
	private int year  = 2010;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	

}
