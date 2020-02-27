package com.corejsf;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
//@Named("payment") //
@ManagedBean(name = "payment")
@SessionScoped
public class PaymentBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8752041026944482350L;
	/**
	 * 
	 */
	private double amount;
	private CreditCard card = new CreditCard("");
	private Date date = new Date();

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}