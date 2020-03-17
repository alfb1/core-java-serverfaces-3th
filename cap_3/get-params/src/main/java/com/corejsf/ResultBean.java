package com.corejsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ResultBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String myParam1;
	String myParam2;

	public String getMyParam1() {
		return myParam1;
	}

	public void setMyParam1(String myParam1) {
		this.myParam1 = myParam1;
	}

	public String getMyParam2() {
		return myParam2;
	}

	public void setMyParam2(String myParam2) {
		this.myParam2 = myParam2;
	}

}
