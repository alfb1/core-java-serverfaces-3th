package com.corejsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

public class Name implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1595053884808475688L;
	
	private String first;
	private String last;
	private boolean editable;
	
	public Name(String first, String last) {
		this.first = first ;
		this.last  = last ;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	

}
